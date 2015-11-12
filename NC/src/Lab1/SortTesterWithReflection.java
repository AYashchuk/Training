package Lab1;

import Lab1.domain.Sort;
import Lab1.service.generator.GenRandomArray;
import Lab1.service.printer.Printer;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;



public class SortTesterWithReflection {
	public static void main(String[] args) {
		useSortingWithReflection();
	}

	/**
	 * Overview:
	 * This method using reflection for search and use some method of sort
 	 * @author Yashchuk A. F.
	 *
	 */
	public static void useSortingWithReflection() {
		GenRandomArray generator = new GenRandomArray();
		Printer printer = new Printer();
		int [] array = new int [50];
		generator.generate(array);
		Class clazz = Sort.class;
		Package pack = clazz.getPackage();
		List<Class<?>> classes = getClassesForPackage(pack);
		for(int i=0;i<classes.size();i++){
			Class classMethodOfSort = classes.get(i);
			if(classMethodOfSort.getSuperclass() != null){
				if(classMethodOfSort.getSuperclass().equals(Sort.class) ) {
					System.out.println(classMethodOfSort);
					try {
						Sort sort = (Sort) classMethodOfSort.newInstance();
						System.out.println("Method of sort: " + sort.getNameOfSort());
						int[] tmp = Arrays.copyOf(array, array.length);
						System.out.println("input:");
						printer.print(tmp);
						sort.sort(tmp);
						System.out.println("output:");
						printer.print(tmp);
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}else System.out.println(classMethodOfSort);


		}
	}


	/**
	 * Overview:
	 * This method using reflection API for find classes in out JAR file
	 * and create ArrayList<Class>
	 * @author Yashchuk A. F.
	 * @param pkg - it is point to enter where we would search Class
	 * @return ArrayList<Class<?>> - list classes which we find
	 *
	 */
	private static ArrayList<Class<?>> getClassesForPackage(Package pkg) {
		String pkgname = pkg.getName();
		ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
		// Get a File object for the package
		File directory = null;
		String fullPath;
		String relPath = pkgname.replace('.', '/');
		System.out.println("ClassDiscovery: Package: " + pkgname + " becomes Path:" + relPath);
		URL resource = ClassLoader.getSystemClassLoader().getResource(relPath);
		System.out.println("ClassDiscovery: Resource = " + resource);
		if (resource == null) {
			throw new RuntimeException("No resource for " + relPath);
		}
		fullPath = resource.getFile();
		System.out.println("ClassDiscovery: FullPath = " + resource);

		try {
			directory = new File(resource.toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(pkgname + " (" + resource + ") does not appear to be a valid URL / URI.  Strange, since we got it from the system...", e);
		} catch (IllegalArgumentException e) {
			directory = null;
		}
		System.out.println("ClassDiscovery: Directory = " + directory);

		if (directory != null && directory.exists()) {
			// Get the list of the files contained in the package
			String[] files = directory.list();
			for (int i = 0; i < files.length; i++) {
				// we are only interested in .class files
				if (files[i].endsWith(".class")) {
					// removes the .class extension
					String className = pkgname + '.' + files[i].substring(0, files[i].length() - 6);
					System.out.println("ClassDiscovery: className = " + className);
					try {
						classes.add(Class.forName(className));
					}
					catch (ClassNotFoundException e) {
						throw new RuntimeException("ClassNotFoundException loading " + className);
					}
				}
			}
		}
		else {
			try {
				String jarPath = fullPath.replaceFirst("[.]jar[!].*", ".jar").replaceFirst("file:", "");
				JarFile jarFile = new JarFile(jarPath);
				Enumeration<JarEntry> entries = jarFile.entries();
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					String entryName = entry.getName();
					if(entryName.startsWith(relPath) && entryName.length() > (relPath.length() + "/".length())) {
						System.out.println("ClassDiscovery: JarEntry: " + entryName);
						String className = entryName.replace('/', '.').replace('\\', '.').replace(".class", "");
						System.out.println("ClassDiscovery: className = " + className);
						try {
							classes.add(Class.forName(className));
						}
						catch (ClassNotFoundException e) {
							throw new RuntimeException("ClassNotFoundException loading " + className);
						}
					}
				}
			} catch (IOException e) {
				throw new RuntimeException(pkgname + " (" + directory + ") does not appear to be a valid package", e);
			}
		}
		return classes;
	}
}


