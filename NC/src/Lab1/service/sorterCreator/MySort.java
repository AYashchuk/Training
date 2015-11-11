package Lab1.service.sorterCreator;

import Lab1.TypeOfSort;
import Lab1.domain.*;



/**
 * Overview:
 * This class it is Realisation of sort method creator;
 * using pattern Factory method
 * @author Yashchuk A. F.
 *
 */
public class MySort extends SorterCreator {

	/**
	 * Overview:
	 * This method testing different type of sort
	 * this is Factory method
	 * @param typeOfSort - it is type which Object we want create
	 * @return Sort - Object which can sort according some method
	 */
	@Override
	public Sort createSort(Enum typeOfSort) { // Factory method
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
