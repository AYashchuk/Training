package Lab1;

import Lab1.domain.*;

public enum TypeOfSort {
	BUBBLE,
	EXCHANGE,
	MERGE,
	RECURSIVE,
	ARRAYS;

	public Sort getInstance(Enum typeOfSort) {
		Sort sort = null;
		if(typeOfSort == TypeOfSort.BUBBLE){
			sort = new BubbleSort();
		}if(typeOfSort == TypeOfSort.ARRAYS){
			sort = new ArraySort();
		}if(typeOfSort == TypeOfSort.EXCHANGE){
			sort = new ExchangeSort();
		}if(typeOfSort == TypeOfSort.MERGE){
			sort = new MergeSsort();
		}if(typeOfSort == TypeOfSort.RECURSIVE){
			sort = new RecursiveSort();
		}
		return sort;
	}
}
