package Lab1.testing;

import Lab1.service.sorterCreator.SorterCreator;
import Lab1.service.generator.Generator;
import Lab1.service.printer.Printer;
import java.util.ArrayList;
import java.util.List;

public abstract class MainTest {
	static List<ResultTesting> bubbleSort = new ArrayList<>();   // ths lists are collecting statistics about speed this type of sort
	static List<ResultTesting> arraysSort = new ArrayList<>();   // -||-
	static List<ResultTesting> exchangeSort = new ArrayList<>(); // -||-
	static List<ResultTesting> mergeSort = new ArrayList<>();    // -||-
	static List<ResultTesting> recursiveSort = new ArrayList<>();// -||-
	protected Generator generator;                               // type of generator wich using
	protected Printer printer;                                   // type of printer wich using
	protected SorterCreator sorter;                              // type of sorter creator
	protected String nameOfTest;                                 // name of this test
	protected int id;                                            // id of this test
	protected int [] array;

	protected MainTest(Generator generator, Printer printer, SorterCreator sorter,int arrayLength) {
		this.generator = generator;
		this.printer = printer;
		this.sorter = sorter;
		this.array =  new int [arrayLength];
		generator.generate(array);
	}

	protected MainTest(Generator generator, Printer printer, SorterCreator sorter, String nameOfTest, int id, int arrayLength) {
		this(generator,printer,sorter, arrayLength);
		this.id = id;
		this.nameOfTest = nameOfTest;
	}

	public abstract void testing();

	public Generator getGenerator() {
		return generator;
	}

	public Printer getPrinter() {
		return printer;
	}

	public SorterCreator getSorter() {
		return sorter;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public void setSorter(SorterCreator sorter) {
		this.sorter = sorter;
	}

	public String getNameOfTest() {
		return nameOfTest;
	}

	public void setNameOfTest(String nameOfTest) {
		this.nameOfTest = nameOfTest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static List<ResultTesting> getBubbleSort() {
		return bubbleSort;
	}

	public static List<ResultTesting> getArraysSort() {
		return arraysSort;
	}

	public static List<ResultTesting> getExchangeSort() {
		return exchangeSort;
	}

	public static List<ResultTesting> getMergeSort() {
		return mergeSort;
	}

	public static List<ResultTesting> getRecursiveSort() {
		return recursiveSort;
	}


	// this class use for  includes collecting statistics about speed this type of sort (for Advanced task)
	public class ResultTesting{
		                               // he include:
		private Generator generator;   // type of generator
		private int arrayLength;       // length of testing array
		private long timeSort;         // time of sorting

		protected ResultTesting(int arrayLength, long timeSort, Generator generator) {
			this.arrayLength = arrayLength;
			this.timeSort = timeSort;
			this.generator = generator;
		}


		public int getArrayLength() {
			return arrayLength;
		}

		public void setArrayLength(int arrayLength) {
			this.arrayLength = arrayLength;
		}

		public long getTimeSort() {
			return timeSort;
		}

		public void setTimeSort(long timeSort) {
			this.timeSort = timeSort;
		}

		public Generator getGenerator() {
			return generator;
		}

		@Override
		public String toString(){
			return timeSort + "\t" + arrayLength + "\t";
		}
	}
}
