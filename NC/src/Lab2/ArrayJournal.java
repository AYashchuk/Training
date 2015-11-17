package Lab2;

import Lab2.comparators.DateComparator;
import Lab2.comparators.ImportanceComparator;
import Lab2.comparators.SourceComparator;
import Lab2.filters.SimpleFilter;
import Lab2.sorters.SimpleSorter;

import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;



/**
 * Overview:
 * @author Yashchuk A. F.
 * @version 1.0
 * @see java.util.ArrayList
 *
 */
public class ArrayJournal <E extends Record> implements Iterable<E>, Journal {
	/**  */
	private SimpleSorter simpleSorter = new SimpleSorter(new DateComparator(),new ImportanceComparator(),new SourceComparator());
	/**  */
	private SimpleFilter simpleFilter = new SimpleFilter(this);
	/**  */
	private Record[] array = new Record[11];
	/**  */
	private int imageLength;


	/**
	 * Overview:
	 * This method enlarge current array
	 */
	private void enlargeArray() {
		int length = array.length;
		if (length < 20000) {
			length = length + (int) (length * 1.5); // enlarge size of array in 1.5
		} else {
			if (length < 20000000) {
				length = length + (int) (length * 0.5); // enlarge size of array  50%
			} else {
				length = length + (int) (length * 0.001); //enlarge size of array  1/10%
			}
		}
		Record newArray[] = new Record[length];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
	}


	/**
	 * Overview:
	 *
	 */
	@Override
	public void add(Record value) {
		if (array.length > imageLength) {  // если реальная длина масива больше мнимой, то споколйно добавляем елемент
			array[imageLength] = value;
		} else {
			enlargeArray();              // если же нет, то вызываем метод рашырения масива
			array[imageLength] = value;// и спокойно добавляем новый елемент
		}
		imageLength++;// увелииваем мнимую длину на единицу
	}

	/**
	 * Overview:
	 *
	 */
	@Override
	public void add(Journal j) {

	}

	/**
	 * Overview:
	 *
	 */
	@Override
	public void remove(Record r) {
		for(int i=0;i< imageLength;i++){
			if(array[i].equals(r)){
				remove(i);
			}
		}
	}

	/**
	 * Overview:
	 *
	 * @throws java.lang.ArrayIndexOutOfBoundsException()
	 */
	public E get(int index) {
		if (index < 0 || index >= imageLength) {
			throw new ArrayIndexOutOfBoundsException("Current array size: " + imageLength +", you index: "+index);
		} else {
			return (E) array[index];
		}
	}



	/**
	 * Overview:
	 *
	 */
	@Override
	public void insert(int index, Record record) {
		add(index,record);
	}

	/**
	 * Overview:
	 *
	 * @throws java.lang.IndexOutOfBoundsException
	 */
	@Override
	public void set(int index, Record value) {
		if (index < 0 || index >= imageLength) {
			throw new IndexOutOfBoundsException("Current array size: " + imageLength +", you index: "+index);
		} else {
			array[index] = value;
		}
	}

	/**
	 * Overview:
	 *
	 * @throws java.lang.IndexOutOfBoundsException
	 *
	 */
	public boolean add(int index, Record value) {
		if (index < 0 || index > imageLength) {
			throw  new IndexOutOfBoundsException("Current array size: " + imageLength +", you index: "+index);
		} else {
			if (array.length <= imageLength + 1) {               // if real length <= image length enlarge array
				enlargeArray();
			}                                                    // else real size bigger then image size add element
			E tmp1 = null;
			E tmp2 = null;
			for (int i = index; i < imageLength + 1; i++) {
				if (i == index) tmp1 = (E) array[i];
				tmp2 = (E) array[i + 1];
				array[i + 1] = tmp1;
				tmp1 = tmp2;
			}
			array[index] = value;
			imageLength++;
			return true;
		}
	}


	/**
	 * Overview:
	 *
	 */
	public int indexOf(Record value) {
		for (int i = 0; i < imageLength; i++) {
			if (array[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Overview:
	 *
	 */
	public int size() {
		return imageLength;
	}

	/**
	 * Overview:
	 *
	 */
	@Override
	public Journal filter(String s) {
		return null;
	}

	/**
	 * Overview:
	 *
	 */
	@Override
	public Journal filter(Date fromDate, Date toDate) {

		return null;
	}

	/**
	 * Overview:
	 *
	 */
	@Override
	public void sortByDate() {
		simpleSorter.sortingByDate(this);
	}

	/**
	 * Overview:
	 *
	 */
	@Override
	public void sortByImportanceDate() {
		simpleSorter.sortingByImportanceDate(this);
	}

	/**
	 * Overview:
	 *
	 */
	@Override
	public void sortByImportanceSourceDate() {
		simpleSorter.sortingByImportanceSourceDate(this);
	}

	/**
	 * Overview:
	 *
	 */
	@Override
	public void sortBySourceDate() {
		simpleSorter.sortingBySourceDate(this);
	}

	/**
	 * Overview:
	 *
	 */
	@Override
	public void printRecords() {
		if(imageLength == 0) System.out.println("[ ]");
		else
		for(int i=0;i<imageLength;i++){
			System.out.println("["+array[i]+"]");
		}
	}

	/**
	 * Overview:
	 *
	 */
	@Override
	public void remove(int index) {
		if (index < 0 || index >= imageLength) {
			throw new IndexOutOfBoundsException();
		} else {
			if (array.length == imageLength) {
				enlargeArray();
			}
			for (int i = index; i < imageLength; i++) {
				array[i] = array[i + 1];
			}
			imageLength--;
		}
	}

	/**
	 * Overview:
	 *
	 */
	@Override
	public void remove(int fromIndex, int toIndex) {
		int j = fromIndex;
		if(fromIndex > toIndex || fromIndex < 0 || toIndex >= imageLength) throw new IndexOutOfBoundsException();
		for(int i=toIndex;i < imageLength;i++, j++){
			array[j] = array[i];
		}
		imageLength = imageLength - (toIndex-fromIndex);
	}

	/**
	 * Overview:
	 *
	 */
	@Override
	public void removeAll() {
		array = new Record[11];
		imageLength = 0;
	}


	/**
	 * Overview:
	 *
	 */
	@Override
	public String toString() {
		String imageArray = "[";
		for (int i = 0; i < imageLength; i++) {
			if (array[i] != null) {
				imageArray = imageArray + array[i].toString() + " ";
			} else {
				imageArray = imageArray + "null" + " ";
			}
		}
		imageArray = imageArray + "]";
		System.out.println("image Array: " + imageArray);
		return "";
	}

	/**
	 * Overview:
	 * My realization of simple iterator
	 * @see java.util.Iterator
	 */
	@Override
	public Iterator iterator () {
		return new MyIterator();
	}


	private class MyIterator <User> implements Iterator {
		private int index;
		public MyIterator() {
			index  = 0;
		}

		/**
		 * Overview:
		 *
		 */
		@Override
		public boolean hasNext() {
			return index< imageLength ;
		}

		/**
		 * Overview:
		 *
		 * @throws java.util.NoSuchElementException
		 */
		@Override
		public E next() {
			if (index < imageLength) {
				return (E) array[index++];
			} else throw new NoSuchElementException();

		}

		/**
		 * Overview:
		 *
		 * @throws java.lang.IllegalStateException()
		 */
		@Override
		public void remove() {
			if (array.length == imageLength) {
				enlargeArray();
			}
			if(index-1 >=0){
				for (int i = index-1; i < imageLength; i++) {
					array[i] = array[i + 1];
				}
				index--;
				imageLength--;
			}else{
				throw  new IllegalStateException();
			}
		}
	}

	public SimpleSorter getSimpleSorter() {
		return simpleSorter;
	}
}
