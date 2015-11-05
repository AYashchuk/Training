package Lab1.testing;

import Lab1.TyprOfSort;
import Lab1.domain.Sort;
import Lab1.service.generator.Generator;
import Lab1.service.printer.Printer;
import Lab1.service.sorterCreator.SorterCreator;
import java.util.Arrays;


public class Test extends MainTest{
	// Overview:
	// this class testing different type of sort with using one type of generator

	private int [] currentArray;             // array wich using testing method for sorting
	private String nameFasterSortMethod;     // this name of faster method in current test
	private long sortTime = Long.MAX_VALUE;  // time of sorting faster method

	public Test(Generator generator, Printer printer, SorterCreator sorter, int arrayLength) {
		super(generator, printer, sorter, arrayLength);
	}

	public Test(Generator generator, Printer printer, SorterCreator sorter, String nameOfTest, int id, int arrayLength) {
		super(generator, printer, sorter, nameOfTest, id, arrayLength);
	}

	@Override
	public void testing() {                                                                    // this method testing different type of sort
		long currTime = 0;
	    System.out.println("\n\n\n\n\n");
		System.out.println("Test name: \"" + getNameOfTest() + "\", test number: "  + getId());// create header of test using his name and id
		System.out.println("Overview:" );                                                      // print overview
		System.out.println("Arrays length: " + array.length);                                  // length using array
		System.out.println("Using type of generator: " + generator);                           // type using generator
		for(int i=0;i<5;i++){                                                                  // because we have 5 type of sort using cycle
			switch (i){
				case 0:{                                                                       // test bubble sort
					if((currTime = testingSort("Bubble", sorter.createSort(TyprOfSort.BUBBLE),i+1)) < sortTime){ // calling testingSort();
						nameFasterSortMethod = "Bubble sort";
						sortTime = currTime;
					}
					if(generator.getGeneratorName().equals("Current behavior: This generator generate random array"))
						bubbleSort.add(new ResultTesting(array.length,currTime,generator));
				break;}
				case 1:{
					if((currTime = testingSort("Exchange", sorter.createSort(TyprOfSort.EXCHANGE),i+1)) < sortTime){
						nameFasterSortMethod = "Exchange sort";
						sortTime = currTime;
					}
					if(generator.getGeneratorName().equals("Current behavior: This generator generate random array"))
						exchangeSort.add(new ResultTesting(array.length,currTime,generator));
				break;}
				case 2:{
					if((currTime = testingSort("Arrays.sort()", sorter.createSort(TyprOfSort.ARRAYS),i+1)) < sortTime){
						nameFasterSortMethod = "Arrays.sort()";
						sortTime = currTime;
					}
					if(generator.getGeneratorName().equals("Current behavior: This generator generate random array"))
						arraysSort.add(new ResultTesting(array.length,currTime,generator));
				break;}
				case 3:{
					if((currTime = testingSort("Merge sort", sorter.createSort(TyprOfSort.MERGE),i+1)) < sortTime){
						nameFasterSortMethod = "Merge sort";
						sortTime = currTime;
					}
					if(generator.getGeneratorName().equals("Current behavior: This generator generate random array"))
						mergeSort.add(new ResultTesting(array.length,currTime,generator));
				break;}
				case 4:{
					if((currTime = testingSort("Recursive sort", sorter.createSort(TyprOfSort.RECURSIVE),i+1)) < sortTime){
						nameFasterSortMethod = "Recursive sort";
						sortTime = currTime;
					}
					if(generator.getGeneratorName().equals("Current behavior: This generator generate random array"))
						recursiveSort.add(new ResultTesting(array.length,currTime,generator));
				break;}
				default: {
					System.out.println("not found method");
				}

			}
		}
		System.out.println("\nResult of test: ");
		System.out.println("the faster sort method: " + nameFasterSortMethod);
		System.out.println("time of sort: " + sortTime + " micro s.");
	}

	private long testingSort(String sortName,Sort sort, int id){ // method testing sort
		System.out.println("\n\n");
		long time = 0;
		System.out.println(id+ ") Testing "+ sortName +" sort"); // print name of sort
		currentArray = Arrays.copyOf(array,array.length);        // prepare array for sort (copy from input array in tmp)
		System.out.println("input array:");
		printer.print(currentArray);                             // print had prepared array
		System.out.println("\noutput array:");
		sort.sort(currentArray);                                 // sorting array using current method of sort
		printer.print(currentArray);                             // print out array
		time = sort.getSortingTime();                            // get time current sorting
		System.out.println("\nTime of sorting: " + sort.getSortingTime());
		if(sortName.equals("Bubble")){                           // if we testing Bubble sort we must calling revers Bubble sort
			currentArray = Arrays.copyOf(array,array.length);    // prepare array for sort (copy from input array in tmp)
			sort.setMod(true);                                   // set mod revers sort
			System.out.println("\noutput array:");               // ...
			sort.sort(currentArray);
			printer.print(currentArray);
			System.out.println("\nTime of sorting: " + sort.getSortingTime());
			if(time < sort.getSortingTime()) return sort.getSortingTime(); // checked who faster (line bubble sort or revers bubble sort),
																		   // and return faster result
		}
		return time;
	}

	public String getNameFasterSortMethod() {
		return nameFasterSortMethod;
	}

	public long getSortTime() {
		return sortTime;
	}


}
