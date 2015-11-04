package Lab1.service.sorterCreator;

import Lab1.TyprOfSort;
import Lab1.domain.*;

public class MySort extends SorterCreator {

	@Override
	public Sort createSort(Enum typeOfSort) {
		if(typeOfSort == TyprOfSort.BUBBLE){
			sort = new BubbleSort();
		}if(typeOfSort == TyprOfSort.ARRAYS){
			sort = new ArraySort();
		}if(typeOfSort == TyprOfSort.EXCHANGE){
			sort = new ExchangeSort();
		}if(typeOfSort == TyprOfSort.MERG){
			sort = new MergeSsort();
		}if(typeOfSort == TyprOfSort.RECURSIVE){
			sort = new RecursiveSort();
		}
		return sort;
	}
}
