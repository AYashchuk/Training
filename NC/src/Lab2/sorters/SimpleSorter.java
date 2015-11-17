package Lab2.sorters;

import Lab2.Journal;
import Lab2.Record;
import Lab2.comparators.DateComparator;
import Lab2.comparators.ImportanceComparator;
import Lab2.comparators.SourceComparator;

import java.util.Comparator;


/**
 * Overview:
 * This class sort objects how implements interface
 * Journal  {@link Lab2.Journal} by three types of sort.
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
	/** comparator for date */
	private Comparator<Record> dateComparator = new DateComparator();
	/** comparator for importance */
	private Comparator <Record> importanceComparator = new ImportanceComparator();
	/** comparator for source */
	private Comparator <Record> sourceComparator = new SourceComparator();

	public SimpleSorter(Comparator<Record> dateComparator, Comparator<Record> importanceComparator, Comparator<Record> sourceComparator) {
		this.dateComparator = dateComparator;
		this.importanceComparator = importanceComparator;
		this.sourceComparator = sourceComparator;
	}

	/**
	 * Overview:
	 * Method sorting using bubble sort
	 * @see Lab1.domain.BubbleSort
	 *
	 */
	public void sortingByDate(Journal tmpArray) {
		for(int i = 0; i < tmpArray.size()- 1; i++)
			for(int j = 0; j < tmpArray.size() - i - 1; j++) {
				if(dateComparator.compare(tmpArray.get(j),tmpArray.get(j+1))>0){
					swap(tmpArray,j,j+1);
				}
			}
	}

	/**
	 * Overview:
	 * Method sorting using bubble sort
	 * @see Lab1.domain.BubbleSort
	 *
	 */
	public void sortingByImportanceDate(Journal tmpArray) {
		for(int i = 0; i < tmpArray.size()- 1; i++)
			for(int j = 0; j < tmpArray.size() - i - 1; j++) {
				if(importanceComparator.compare(tmpArray.get(j),tmpArray.get(j+1)) > 0){
					swap(tmpArray,j,j+1);
				}if(importanceComparator.compare(tmpArray.get(j),tmpArray.get(j+1)) == 0){
					if(dateComparator.compare(tmpArray.get(j),tmpArray.get(j+1)) > 0){
						swap(tmpArray,j,j+1);
					}
				}
			}
	}


	/**
	 * Overview:
	 * Method sorting using bubble sort
	 * @see Lab1.domain.BubbleSort
	 *
	 */
	public void sortingByImportanceSourceDate(Journal tmpArray) {
		for(int i = 0; i < tmpArray.size()- 1; i++)
			for(int j = 0; j < tmpArray.size() - i - 1; j++) {
				if(importanceComparator.compare(tmpArray.get(j),tmpArray.get(j+1)) > 0){
					swap(tmpArray,j,j+1);
				}if(importanceComparator.compare(tmpArray.get(j),tmpArray.get(j+1)) == 0){
					if(sourceComparator.compare(tmpArray.get(j),tmpArray.get(j+1)) > 0){
						swap(tmpArray,j,j+1);
					}if(sourceComparator.compare(tmpArray.get(j),tmpArray.get(j+1)) == 0){
						if(dateComparator.compare(tmpArray.get(j),tmpArray.get(j+1))>0){
							swap(tmpArray,j,j+1);
						}
					}
				}
			}
	}


	/**
	 * Overview:
	 * Method sorting using bubble sort
	 * @see Lab1.domain.BubbleSort
	 *
	 */
	public void sortingBySourceDate(Journal tmpArray){
		for(int i = 0; i < tmpArray.size()- 1; i++)
			for(int j = 0; j < tmpArray.size() - i - 1; j++) {
				if(sourceComparator.compare(tmpArray.get(j),tmpArray.get(j+1)) > 0){
					swap(tmpArray,j,j+1);
				}if(sourceComparator.compare(tmpArray.get(j),tmpArray.get(j+1)) == 0){
					if(dateComparator.compare(tmpArray.get(j),tmpArray.get(j+1)) > 0){
						swap(tmpArray,j,j+1);
					}
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

}
