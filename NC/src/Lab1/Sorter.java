package Lab1;

import Lab1.domain.*;

public class Sorter <SortType>{
	private Enum typeOfSort;
	private Sort sorter;

	public Sorter(Enum typeOfSort) {
		this.typeOfSort = typeOfSort;
	}

	private void createSort(){
		if(typeOfSort == TyprOfSort.BUBBLE){
			sorter = new BubbleSort();
		}if(typeOfSort == TyprOfSort.ARRAYS){
			sorter = new ArraySort();
		}if(typeOfSort == TyprOfSort.EXCHANGE){
			sorter = new ExchangeSort();
		}if(typeOfSort == TyprOfSort.MERG){
			sorter = new MergSsort();
		}if(typeOfSort == TyprOfSort.RECURSIVE){
			sorter = new RecursiveSort();
		}
	}

	public void makeSort(int array[]){
		sorter.sort(array);
	}

	public void makeSort(double array[]){
		sorter.sort(array);
	}

	public void makeSort(char array[]){
		sorter.sort(array);
	}

	public void makeSort(float array[]){
		sorter.sort(array);
	}

	public void makeSort(byte array[]){
		sorter.sort(array);
	}
}