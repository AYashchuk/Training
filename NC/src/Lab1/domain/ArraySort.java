package Lab1.domain;

import Lab1.Sort;

import java.util.Arrays;

public class ArraySort extends Sort{
	@Override
	public void sort(int[] array) {
		Arrays.sort(array);
	}
}
