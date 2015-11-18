package Lab2.journals;

import Lab2.domain.Record;
import Lab2.comparators.DateComparator;
import Lab2.comparators.ImportanceComparator;
import Lab2.comparators.SourceComparator;
import Lab2.exception.WrongInputDataException;
import Lab2.sorters.SimpleSorter;

import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;



/**
 * Overview:
 * @author Yashchuk A. F.
 * @version 1.0
 * @see java.util.ArrayList
 */
public class ArrayJournal <E extends Record> implements Iterable<E>, Journal {
	/** Simple sorter for sort using different comparators */
	private SimpleSorter simpleSorter;
	/** current array */
	private Record[] array;
	/** image length of current array */
	private int imageLength;


	/**
	 * Overview:
	 * Copy constructor
	 * @param journal input journal which will be add to current journal
	 */
	public ArrayJournal(Journal journal) {
		this.add(journal);
	}

	/**
	 * Overview:
	 * Empty constructor
	 * create empty journal
	 */
	public ArrayJournal() {
		this.array = new Record[11];
		simpleSorter = new SimpleSorter(new DateComparator(),new ImportanceComparator(),new SourceComparator());
	}

	/**
	 * Overview:
	 * This method enlarge current array if image seeks on array.length()
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
	 * This method add value {@link Lab2.Record} in journal{@link Journal}
	 * @param value - it is value that we would add
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
	 * This method add journal {@link Journal} in current journal{@link Journal}
	 * @param j - it is Journal {@link Journal} which will based current journal
	 */
	@Override
	public void add(Journal j) {
		for(int i=0;i<j.size();i++){
			add(j.get(i));
		}
	}

	/**
	 * Overview:
	 * This method remove Record {@link Lab2.Record} in current journal{@link Journal}
	 * @param r - it is Record value which we would remove from journal
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
	 * This method get Record {@link Lab2.Record} from current journal{@link Journal}
	 * @param index - it is index of which element we would get from journal
	 * @return E - it is value Record{@link Lab2.Record} or his subclass
	 * @throws java.lang.ArrayIndexOutOfBoundsException()- throw if invalid index
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
	 * This method insert Record {@link Lab2.Record} in position index in current journal{@link Journal}
	 * @param index - it is index of which position we would insert element in journal
	 * @param  value - it is value which we would insert
	 */
	@Override
	public void insert(int index, Record value) {
		add(index,value);
	}

	/**
	 * Overview:
	 * This method set Record {@link Lab2.Record} in position index in current journal{@link Journal}
	 * @param index - it is index of which position we would insert element in journal
	 * @param  value - it is value which we would set
	 * @throws java.lang.IndexOutOfBoundsException() - throw if invalid index
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
	 * This method add Record {@link Lab2.Record} in position index in current journal{@link Journal}
	 * @param index - it is index of which position we would insert element in journal
	 * @param  value - it is value which we would insert
	 * @throws java.lang.IndexOutOfBoundsException() - throw if invalid index
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
	 * This method find Record {@link Lab2.Record} in current journal{@link Journal}
	 * @param  value - it is value which we would find
	 * @return int value, if element had been find value it is index of find element, if element not find return -1
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
	 * This method return capacity current journal{@link Journal}
	 * @return imageLength
	 */
	public int size() {
		return imageLength;
	}

	/**
	 * Overview:
	 * This method compare source on Records which create on base String s
	 * and return new Journal with the same source
	 * @param s String value which based create Record
	 * @return new Journal with the same source
	 */
	@Override
	public Journal filter(String s) {
		Journal journal = new ArrayJournal<Record>();
		Record record = null;
		try {
			record = new Record(s);
		} catch (WrongInputDataException e) {
			e.printStackTrace();
			return  null;
		}
		for(int i=0;i<imageLength;i++){
			Record tmpRecord = array[i];
			if(tmpRecord.getSource().equals(record.getSource())){
				journal.add(array[i]);
			}
		}
		return journal;
	}

	/**
	 * Overview:
	 * This method compare source on Records which date is located in period of date
	 * @param fromDate - start date period
	 * @param toDate - end of date period
	 * @return new Journal which date located in period of date
	 */
	@Override
	public Journal filter(Date fromDate, Date toDate) {
		if(fromDate.compareTo(toDate)>0){
			Date tmp = fromDate;
			fromDate = toDate;
			toDate = tmp;
		}
		Journal j = new ArrayJournal<Record>();
		for(int i=0;i<imageLength;i++){
			Record tmpRecord = array[i];
			if(tmpRecord.getDate().compareTo(fromDate)>=0 && tmpRecord.getDate().compareTo(toDate)<=0){
				j.add(array[i]);
			}
		}
		return j;
	}

	/**
	 * Overview:
	 * Method sort Journal by date
	 */
	@Override
	public void sortByDate() {
		simpleSorter.sortingByDate(this);
	}

	/**
	 * Overview:
	 * Method sort Journal by importance and date
	 */
	@Override
	public void sortByImportanceDate() {
		simpleSorter.sortingByImportanceDate(this);
	}

	/**
	 * Overview:
	 * Method sort Journal by importance, source and date
	 */
	@Override
	public void sortByImportanceSourceDate() {
		simpleSorter.sortingByImportanceSourceDate(this);
	}

	/**
	 * Overview:
	 * Method sort Journal by source and date
	 */
	@Override
	public void sortBySourceDate() {
		simpleSorter.sortingBySourceDate(this);
	}

	/**
	 * Overview:
	 * Method print all Records in Journal
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
	 * Method remove record on index
	 * @param index - index which record must remove
	 * @throws IndexOutOfBoundsException - throw if input index invalid
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
	 * Method remove record in scope from index1 to index2
	 * @param fromIndex first scope
	 * @param toIndex second scope
	 * @throws IndexOutOfBoundsException - throw if invalid scope
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
	 * This method remove all elements in journal
	 */
	@Override
	public void removeAll() {
		array = new Record[11];
		imageLength = 0;
	}


	/**
	 * Overview:
	 * Method view journal
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
	 * My realization of simple iterator for journal
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
		 * enlarge courrent position of iterator
		 */
		@Override
		public boolean hasNext() {
			return index< imageLength ;
		}

		/**
		 * Overview:
		 * return next element of iterator
		 * @return next element
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
		 * remove current element of iterator
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
}
