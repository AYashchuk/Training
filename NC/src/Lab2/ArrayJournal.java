package Lab2;

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
	private Record[] array = new Record[11];
	/**  */
	private int imageLength;


	/**
	 * Overview:	// метод расшіряет текущий масив
	 * @author Yashchuk A. F.
	 *
	 */
	private void enlargeArray() {
		int length = array.length;
		if (length < 20000) {
			length = length + (int) (length * 1.5); // увеличиваем размер масива в 1.5 раза
		} else {
			if (length < 20000000) {
				length = length + (int) (length * 0.5); // увеличиваем размер масива на 50%
			} else {
				length = length + (int) (length * 0.001); // увеличиваем размер масива на 1/10 процента
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
	 * @author Yashchuk A. F.
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
	 * @author Yashchuk A. F.
	 *
	 */
	@Override
	public void add(Journal j) {

	}

	/**
	 * Overview:
	 * @author Yashchuk A. F.
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
	 * @author Yashchuk A. F.
	 *
	 */
	public E get(int index) {
		if (index < 0 || index >= imageLength) {
			throw new ArrayIndexOutOfBoundsException(index);
		} else {
			return (E) array[index];
		}
	}



	/**
	 * Overview:
	 * @author Yashchuk A. F.
	 *
	 */
	@Override
	public void insert(int index, Record record) {
		add(index,record);
	}

	/**
	 * Overview:
	 * @author Yashchuk A. F.
	 *
	 */
	@Override
	public void set(int index, Record value) {
		if (index < 0 || index >= imageLength) {
			throw new IndexOutOfBoundsException();
		} else {
			array[index] = value;
		}
	}

	/**
	 * Overview:
	 * @author Yashchuk A. F.
	 *
	 */
	public boolean add(int index, Record value) {
		if (index < 0 || index > imageLength) {
			return false;
		} else {
			if (array.length <= imageLength + 1) {  // если реальная длина масива больше мнимой, то споколйно добавляем елемент
				enlargeArray();
			}
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
	 * @author Yashchuk A. F.
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
	 * @author Yashchuk A. F.
	 *
	 */
	public int size() {
		//System.out.println("real  size: " + array.length);
		//System.out.println("image size: " + (imageLength));
		return imageLength;
	}

	/**
	 * Overview:
	 * @author Yashchuk A. F.
	 *
	 */
	@Override
	public Journal filter(String s) {
		return null;
	}

	/**
	 * Overview:
	 * @author Yashchuk A. F.
	 *
	 */
	@Override
	public Journal filter(Date fromDate, Date toDate) {
		return null;
	}

	/**
	 * Overview:
	 * @author Yashchuk A. F.
	 *
	 */
	@Override
	public void sortByDate() {

	}

	/**
	 * Overview:
	 * @author Yashchuk A. F.
	 *
	 */
	@Override
	public void sortByImportanceDate() {

	}

	/**
	 * Overview:
	 * @author Yashchuk A. F.
	 *
	 */
	@Override
	public void sortByImportanceSourceDate() {

	}

	/**
	 * Overview:
	 * @author Yashchuk A. F.
	 *
	 */
	@Override
	public void sortBySourceDate() {

	}

	/**
	 * Overview:
	 * @author Yashchuk A. F.
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
	 * @author Yashchuk A. F.
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
	 * @author Yashchuk A. F.
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
	 * @author Yashchuk A. F.
	 *
	 */
	@Override
	public void removeAll() {
		array = new Record[11];
		imageLength = 0;
	}


	/**
	 * Overview:
	 * @author Yashchuk A. F.
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
		// System.out.println("real  Array: " + Arrays.toString(array));
		System.out.println("image Array: " + imageArray);
		return "";
	}

	/**
	 * Overview:
	 * @author Yashchuk A. F.
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
		 * @author Yashchuk A. F.
		 *
		 */
		@Override
		public boolean hasNext() {

			return index< imageLength ;
		}

		/**
		 * Overview:
		 * @author Yashchuk A. F.
		 *
		 */
		@Override
		public E next() {
			if (index < imageLength) {
				return (E) array[index++];
			} else throw new NoSuchElementException();

		}

		/**
		 * Overview:
		 * @author Yashchuk A. F.
		 *
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
