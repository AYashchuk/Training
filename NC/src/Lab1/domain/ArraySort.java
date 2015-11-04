package Lab1.domain;

import java.util.Arrays;

public class ArraySort extends Sort {
	public ArraySort() {
		this.nameOfSort = "Using method Arrays.sort(); ";
	}

	@Override
	protected void sorting(int[] array) {
		Arrays.sort(array);
	}
}
