package Lab1;

import Lab1.service.Generator;
import Lab1.service.Printer;

public class SortTester {
    public static void main(String[] args) {
	    Generator generator = new Generator();
	    Printer printer = new Printer();
		int [] array = new int[10];


	    generator.generate(array);


	    System.out.println("Int array:");
	    printer.print(array);
	    Sorter sorter = new Sorter(TyprOfSort.ARRAYS);
	    sorter.makeSort(array);
	    System.out.println("\nafter sort:");
	    printer.print(array);
	    System.out.println("\n\n\n");


	    System.out.println("Double array:");
	    generator.generate(array);
	    printer.print(array);
	    System.out.println("\n\n\n");


	    System.out.println("Float array:");
	    generator.generate(array);
	    printer.print(array);
	    System.out.println("\n\n\n");


	    System.out.println("Byte array:");
	    generator.generate(array);
	    printer.print(array);
	    System.out.println("\n\n\n");

    }
}
