package Lab1.testing;

import Lab1.TyprOfSort;
import Lab1.domain.Sort;
import Lab1.service.generator.Generator;
import Lab1.service.printer.Printer;
import Lab1.service.sorterCreator.SorterCreator;

import java.util.Arrays;

public class Test extends MainTest{
	private int [] currentArray;
	private String nameFasterSortMethod;
	private long sortTime = Long.MAX_VALUE;

	public Test(Generator generator, Printer printer, SorterCreator sorter, int arrayLength) {
		super(generator, printer, sorter, arrayLength);
	}

	public Test(Generator generator, Printer printer, SorterCreator sorter, String nameOfTest, int id, int arrayLength) {
		super(generator, printer, sorter, nameOfTest, id, arrayLength);
	}

	@Override
	public void testing() {
		long currTime = 0;
	    System.out.println("\n\n\n\n\n");
		System.out.println("Test name: \"" + getNameOfTest() + "\", test number: "  + getId());
		System.out.println("Overview:" );
		System.out.println("Arrays length: " + array.length);
		System.out.println("Using type of generator: " + generator);
		for(int i=0;i<5;i++){
			switch (i){
				case 0:{
					if((currTime = testingSort("Bubble", sorter.createSort(TyprOfSort.BUBBLE),i+1)) < sortTime){
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
					if((currTime = testingSort("Merge sort", sorter.createSort(TyprOfSort.MERG),i+1)) < sortTime){
						nameFasterSortMethod = "Merge sort";
						sortTime = currTime;
					}
					if(generator.getGeneratorName().equals("Current behavior: This generator generate random array"))
						mergSort.add(new ResultTesting(array.length,currTime,generator));
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

	private long testingSort(String sortName,Sort sort, int id){
		System.out.println("\n\n");
		long time = 0;
		System.out.println(id+ ") Testing "+ sortName +" sort");
		currentArray = Arrays.copyOf(array,array.length);
		System.out.println("input array:");
		printer.print(currentArray);
		System.out.println("\noutput array:");
		sort.sort(currentArray);
		printer.print(currentArray);
		time = sort.getSortingTime();
		System.out.println("\nTime of sorting: " + sort.getSortingTime());
		if(sortName.equals("Bubble")){
			currentArray = Arrays.copyOf(array,array.length);
			sort.setMod(true);
			System.out.println("\noutput array:");
			sort.sort(currentArray);
			printer.print(currentArray);
			System.out.println("\nTime of sorting: " + sort.getSortingTime());
			if(time < sort.getSortingTime()) return sort.getSortingTime();
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
