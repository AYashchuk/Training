package Lab1.domain;

import Lab1.Sort;

import java.util.Arrays;

public class ArraySort extends Sort{
	@Override
	public void sort(int[] array) {
		Arrays.sort(array);
	}

	@Override
	public void sort(double[] array) {
		Arrays.sort(array);
	}

	@Override
	public void sort(float[] array) {
		Arrays.sort(array);
	}

	@Override
	public void sort(char[] array) {
		Arrays.sort(array);
	}

	@Override
	public void sort(byte[] array) {
		Arrays.sort(array);
	}
}
