package Lab1.domain;

import Lab1.TypeOfSort;

import java.util.Arrays;
/**
 * This class for sort use standard method used {@link java.util.Arrays#sort(int[])  Arrays.sort() };
 * @author Yashchuk A. F.
 * @version 1.0
 * {@link java.util.Arrays#sort(int[])}  used this method}
 * @see java.util.Arrays#sort(int[])
 *
 */
@MySorter(type = TypeOfSort.ARRAYS)
public class ArraySort extends Sort {

	public ArraySort() {
		this.nameOfSort = "Using method Arrays.sort(); ";
	}

	/**
	 * Method sorting array
	 * @param array - it is input array
	 * @return void
	 */
	@Override
	protected void sorting(int[] array) {
		Arrays.sort(array);
		ArraySort as = new ArraySort();

	}
}
