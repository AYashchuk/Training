package Lab2.sorters;

import Lab2.domain.Record;
import Lab2.journals.ArrayJournal;
import Lab2.journals.Journal;

import java.util.Comparator;


/**
 * Overview:
 * This class sort objects how implements interface
 * Journal  {@link Lab2.journals.Journal} by three types of sort.
 * He has some method of sort:
 * 1) sorting by date
 * 2) sorting by importance date
 * 3) sorting by importance source date
 * 4) sorting by source date
 *
 * @author Yashchuk A. F.
 * @version 1.0
 *
 */
public class SimpleSorter {
	/**
	 * Overview:
	 * Method sorting using bubble sort
	 * @see Lab1.domain.BubbleSort
	 *
	 */
	public void sort(Journal tmpArray, Comparator comparator) {
		for(int i = 0; i < tmpArray.size()- 1; i++)
			for(int j = 0; j < tmpArray.size() - i - 1; j++) {
				if(comparator.compare(tmpArray.get(j),tmpArray.get(j+1))>0){
					swap(tmpArray,j,j+1);
				}
			}
	}


	/**
	 * Overview:
	 * Method swap arrays elements
	 *
	 */
	protected void swap(Journal tmpArray, int index1, int index2){
		Record tmp = tmpArray.get(index1);
		tmpArray.set(index1,tmpArray.get(index2));
		tmpArray.set(index2, tmp);
	}

	/**
	 * Overview:
	 * Method copy input array
	 *
	 */
	protected Journal copyJournal(Journal tmpArray){
		ArrayJournal<Record> journal = new ArrayJournal<>();
		for(int i=0;i<tmpArray.size()-1;i++){
			journal.add(tmpArray.get(i));
		}
		return journal;
	}

}
