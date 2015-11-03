package Lab1;

import Lab1.domain.BubbleSort;
import Lab1.service.Generator;
import Lab1.service.Printer;

public class SortTester {
    public static void main(String[] args) {
	    int length = 20;
	    Generator generator = new Generator(length*5);
	    Printer printer = new Printer();
	    Sorter sorter;
	    int [] array = new int[length];




	    System.out.println("Test 1 (array had bean sorted)________________________________________\n\n");
	    generator.generate(array, 0);
	    System.out.println("1) Arrays.sort():");
	    System.out.println("before:");
	    printer.print(array);
	    sorter = new Sorter(TyprOfSort.ARRAYS);
	    long start = System.nanoTime();
	    sorter.makeSort(array);
	    long time = System.nanoTime() - start;
	    System.out.println("\nSorted time: "+ time + " nano s.");
	    System.out.println("\nafter:");
	    printer.print(array);
	    System.out.println("\n\n\n");



	    System.out.println("2) Bubble sort");
	    System.out.println("before:");
	    generator.generate(array, 0);
	    printer.print(array);
	    System.out.println("\nafter Bubble revers sort:");
	    BubbleSort bubbleSort = new BubbleSort();
	    start = System.nanoTime();
	    bubbleSort.reverseSort(array);
	    time = System.nanoTime() - start;
	    System.out.println("\nSorted time: " + time + " nano s.");
	    printer.print(array);
	    generator.generate(array, 0);
	    System.out.println("\nbefore:");
	    printer.print(array);
	    System.out.println("\nafter Bubble classic sort:");
	    sorter = new Sorter(TyprOfSort.BUBBLE);
	    sorter.makeSort(array);
	    printer.print(array);
	    System.out.println("\n\n\n");


	    System.out.println("3) Recursive sort");
	    generator.generate(array, 0);
	    System.out.println("before:");
	    printer.print(array);
	    sorter = new Sorter(TyprOfSort.RECURSIVE);
	    start = System.nanoTime();
	    sorter.makeSort(array);
	    time = System.nanoTime() - start;
	    System.out.println("\nafter:");
	    System.out.println("\nSorted time: " + time + " nano s.");
	    printer.print(array);
	    System.out.println("\n\n\n");


	    System.out.println("4) Merg sort");
	    generator.generate(array, 0);
	    System.out.println("before:");
	    printer.print(array);
	    sorter = new Sorter(TyprOfSort.MERG);
	    sorter.makeSort(array);
	    System.out.println("\nafter:");
	    printer.print(array);
	    System.out.printf("\n\n\n");


	    System.out.println("5) Exchange sort");
	    generator.generate(array, 0);
	    System.out.println("before:");
	    printer.print(array);
	    sorter = new Sorter(TyprOfSort.EXCHANGE);
	    sorter.makeSort(array);
	    System.out.println("\nafter:");
	    printer.print(array);
	    System.out.printf("\n\n\n");



	    System.out.println("Test 2 (array had bean sorted) but last element is random ________________________________________\n\n");
	    generator.generate(array,1);
	    System.out.println("1) Arrays.sort():");
	    System.out.println("before:");
	    printer.print(array);
	    sorter = new Sorter(TyprOfSort.ARRAYS);
	    sorter.makeSort(array);
	    System.out.println("\nafter:");
	    printer.print(array);
	    System.out.println("\n\n\n");



	    System.out.println("2) Bubble sort");
	    System.out.println("before:");
	    generator.generate(array,1);
	    printer.print(array);
	    System.out.println("\nafter Bubble revers sort:");
	    bubbleSort = new BubbleSort();
	    bubbleSort.reverseSort(array);
	    printer.print(array);
	    generator.generate(array, 1);
	    System.out.println("\nbefore:");
	    printer.print(array);
	    System.out.println("\nafter Bubble classic sort:");
	    sorter = new Sorter(TyprOfSort.BUBBLE);
	    sorter.makeSort(array);
	    printer.print(array);
	    System.out.println("\n\n\n");


	    System.out.println("3) Recursive sort");
	    generator.generate(array, 1);
	    System.out.println("before:");
	    printer.print(array);
	    sorter = new Sorter(TyprOfSort.RECURSIVE);
	    sorter.makeSort(array);
	    System.out.println("\nafter:");
	    printer.print(array);
	    System.out.println("\n\n\n");


	    System.out.println("4) Merg sort");
	    generator.generate(array, 1);
	    System.out.println("before:");
	    printer.print(array);
	    sorter = new Sorter(TyprOfSort.MERG);
	    sorter.makeSort(array);
	    System.out.println("\nafter:");
	    printer.print(array);
	    System.out.printf("\n\n\n");


	    System.out.println("5) Exchange sort");
	    generator.generate(array, 1);
	    System.out.println("before:");
	    printer.print(array);
	    sorter = new Sorter(TyprOfSort.EXCHANGE);
	    sorter.makeSort(array);
	    System.out.println("\nafter:");
	    printer.print(array);
	    System.out.printf("\n\n\n");



	    System.out.println("Test 3 (array had bean reverse sorted) ________________________________________\n\n");
	    generator.generate(array,2);
	    System.out.println("1) Arrays.sort():");
	    System.out.println("before:");
	    printer.print(array);
	    sorter = new Sorter(TyprOfSort.ARRAYS);
	    sorter.makeSort(array);
	    System.out.println("\nafter:");
	    printer.print(array);
	    System.out.println("\n\n\n");



	    System.out.println("2) Bubble sort");
	    System.out.println("before:");
	    generator.generate(array,2);
	    printer.print(array);
	    System.out.println("\nafter Bubble revers sort:");
	    bubbleSort = new BubbleSort();
	    bubbleSort.reverseSort(array);
	    printer.print(array);
	    generator.generate(array, 2);
	    System.out.println("\nbefore:");
	    printer.print(array);
	    System.out.println("\nafter Bubble classic sort:");
	    sorter = new Sorter(TyprOfSort.BUBBLE);
	    sorter.makeSort(array);
	    printer.print(array);
	    System.out.println("\n\n\n");


	    System.out.println("3) Recursive sort");
	    generator.generate(array, 2);
	    System.out.println("before:");
	    printer.print(array);
	    sorter = new Sorter(TyprOfSort.RECURSIVE);
	    sorter.makeSort(array);
	    System.out.println("\nafter:");
	    printer.print(array);
	    System.out.println("\n\n\n");


	    System.out.println("4) Merg sort");
	    generator.generate(array, 2);
	    System.out.println("before:");
	    printer.print(array);
	    sorter = new Sorter(TyprOfSort.MERG);
	    sorter.makeSort(array);
	    System.out.println("\nafter:");
	    printer.print(array);
	    System.out.printf("\n\n\n");


	    System.out.println("5) Exchange sort");
	    generator.generate(array, 2);
	    System.out.println("before:");
	    printer.print(array);
	    sorter = new Sorter(TyprOfSort.EXCHANGE);
	    sorter.makeSort(array);
	    System.out.println("\nafter:");
	    printer.print(array);
	    System.out.printf("\n\n\n");




	    System.out.println("Test 4 (array contains random elements) ________________________________________\n\n");
	    generator.generate(array,3);
	    System.out.println("1) Arrays.sort():");
	    System.out.println("before:");
	    printer.print(array);
	    sorter = new Sorter(TyprOfSort.ARRAYS);
	    sorter.makeSort(array);
	    System.out.println("\nafter:");
	    printer.print(array);
	    System.out.println("\n\n\n");



	    System.out.println("2) Bubble sort");
	    System.out.println("before:");
	    generator.generate(array,3);
	    printer.print(array);
	    System.out.println("\nafter Bubble revers sort:");
	    bubbleSort = new BubbleSort();
	    bubbleSort.reverseSort(array);
	    printer.print(array);
	    generator.generate(array, 3);
	    System.out.println("\nbefore:");
	    printer.print(array);
	    System.out.println("\nafter Bubble classic sort:");
	    sorter = new Sorter(TyprOfSort.BUBBLE);
	    sorter.makeSort(array);
	    printer.print(array);
	    System.out.println("\n\n\n");


	    System.out.println("3) Recursive sort");
	    generator.generate(array, 3);
	    System.out.println("before:");
	    printer.print(array);
	    sorter = new Sorter(TyprOfSort.RECURSIVE);
	    sorter.makeSort(array);
	    System.out.println("\nafter:");
	    printer.print(array);
	    System.out.println("\n\n\n");


	    System.out.println("4) Merg sort");
	    generator.generate(array, 3);
	    System.out.println("before:");
	    printer.print(array);
	    sorter = new Sorter(TyprOfSort.MERG);
	    sorter.makeSort(array);
	    System.out.println("\nafter:");
	    printer.print(array);
	    System.out.printf("\n\n\n");


	    System.out.println("5) Exchange sort");
	    generator.generate(array, 3);
	    System.out.println("before:");
	    printer.print(array);
	    sorter = new
			    Sorter(TyprOfSort.EXCHANGE);
	    sorter.makeSort(array);
	    System.out.println("\nafter:");
	    printer.print(array);
	    System.out.printf("\n\n\n");

    }
}
