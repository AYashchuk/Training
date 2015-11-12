package Lab1;

import Lab1.domain.Sort;
import Lab1.service.generator.GenRandomArray;
import Lab1.service.printer.Printer;
import Lab1.service.sorterCreator.MySort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class SortTesterWithReflection {
	public static void main(String[] args) {
		GenRandomArray generator = new GenRandomArray();
		Printer printer = new Printer();
		int [] array = new int [50];
		generator.generate(array);


		MySort mySort = new MySort();
		Class clazz = mySort.getClass();
		System.out.println(clazz.getFields());
		TypeOfSort [] types = TypeOfSort.values();
		for(int i=0;i<types.length;i++){

			try {
				Method method = clazz.getMethod("createSort", TypeOfSort.class);
				Object obj =  method.invoke(mySort,types[i]);
				Sort sort = (Sort) obj;
				System.out.println("Method of sort: " + sort.getNameOfSort());
				int[] tmp = Arrays.copyOf(array,array.length);
				printer.print(tmp);
				sort.sort(tmp);
				printer.print(tmp);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}

		}
	}
}
