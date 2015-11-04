package Lab1;

import Lab1.service.generator.*;
import Lab1.service.printer.Printer;
import Lab1.service.sorterCreator.MySort;
import Lab1.service.sorterCreator.SorterCreator;
import Lab1.testing.MainTest;
import Lab1.testing.Test;

import java.util.ArrayList;
import java.util.List;

public class SortTester {
	private static MainTest [] mainTests = new MainTest[4];
	private  static int length = 20;
	private static List<MainTest> testsGener1 = new ArrayList<>();
	private static List<MainTest> testsGener2 = new ArrayList<>();
	private static List<MainTest> testsGener3 = new ArrayList<>();
	private static List<MainTest> testsGener4 = new ArrayList<>();
	static Printer printer = new Printer();

	static Generator randomGenerator = new MyGenerator(new GenRandomArrat());
	static Generator reversSortGenerator = new MyGenerator(new GenReversSortArray());
	static Generator reversSortWithoutLastElemenrGenerator = new MyGenerator(new GenSoertArrayWithoutLastElement());
	static Generator sortGenerator = new MyGenerator(new GenSortArray());
	static SorterCreator sorterCreator = new MySort();

    public static void main(String[] args) {

	    basicTask();

	    //AdvancedTask();

    }


	public static void basicTask(){
		addTestAndStart();
	}


	public static void addTestAndStart(){
		for(int j=0; j<4;j++){
			if(j==0){
				testsGener1.add(new Test(sortGenerator,
						printer,
						sorterCreator,
						"testing with sort elements",j+1, length));
				testsGener1.get(testsGener1.size()-1).testing();
			}if(j==1){
				testsGener2.add(new Test(reversSortWithoutLastElemenrGenerator,
						printer,
						sorterCreator,
						"testing sort array but last element random",j+1, length));
				testsGener2.get(testsGener2.size()-1).testing();
			}
			if(j==2){
				testsGener3.add(new Test(reversSortGenerator,
						printer,
						sorterCreator,
						"testing revers sort array",j+1, length));
				testsGener3.get(testsGener3.size()-1).testing();
			}
			if(j==3){
				testsGener4.add(new Test(randomGenerator,
						printer,
						sorterCreator,
						"testing with random elements",j+1, length));
				testsGener4.get(testsGener4.size()-1).testing();
			}
		}
	}


	public static void AdvancedTask(){
		for(int i=1; i<= 8;i++){
			length = length + length ;
			addTestAndStart();
		}


		System.out.println("\n\n\n\n\n");
		System.out.println("Result of Bubble sort:");
		System.out.println("1) " + testsGener1.get(0).getGenerator());
		List<MainTest.ResultTesting> result1 = testsGener1.get(0).getBubbleSort();
		for(int j=0;j<result1.size();j++){
			System.out.println(result1.get(j));
		}

		System.out.println("\n\n\n\n\n");
		System.out.println("Result of Arrays.sort() sort:");
		System.out.println("2) " + testsGener1.get(0).getGenerator());
		List<MainTest.ResultTesting> result2 = testsGener1.get(0).getArraysSort();
		for(int j=0;j<result2.size();j++){
			System.out.println(result2.get(j));
		}

		System.out.println("\n\n\n\n\n");
		System.out.println("Result of Exchange sort:");
		System.out.println("3) " + testsGener1.get(0).getGenerator());
		List<MainTest.ResultTesting> result3 = testsGener1.get(0).getExchangeSort();
		for(int j=0;j<result3.size();j++){
			System.out.println(result3.get(j));
		}


		System.out.println("\n\n\n\n\n");
		System.out.println("Result of Merge sort:");
		System.out.println("4) " + testsGener1.get(0).getGenerator());
		List<MainTest.ResultTesting> result4 = testsGener1.get(0).getMergSort();
		for(int j=0;j<result4.size();j++){
			System.out.println(result4.get(j));
		}

		System.out.println("\n\n\n\n\n");
		System.out.println("Result of Recursive sort:");
		System.out.println("5) " + testsGener1.get(0).getGenerator());
		List<MainTest.ResultTesting> result5 = testsGener1.get(0).getRecursiveSort();
		for(int j=0;j<result5.size();j++){
			System.out.println(result5.get(j));
		}

	}
}
