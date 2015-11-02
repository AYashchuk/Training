package Lab1;

import Lab1.service.Generator;
import Lab1.service.Printer;

public class SortTester {
    public static void main(String[] args) {
	    Generator generator = new Generator();

		int [] array = new int[10];
	    double [] array1 = new double[10];
	    float [] array3 = new float[10];
	    byte [] array4 = new byte[10];

	    generator.generate(array);
	    generator.generate(array1);
	    generator.generate(array3);
	    generator.generate(array4);



	    Printer printer = new Printer();

	    System.out.println("Int array:");
	    printer.print(array);
	    System.out.println();


	    System.out.println("Double array:");
	    printer.print(array1);
	    System.out.println();


	    System.out.println("Float array:");
	    printer.print(array3);
	    System.out.println();


	    System.out.println("Byte array:");
	    printer.print(array4);
	    System.out.println();

    }
}
