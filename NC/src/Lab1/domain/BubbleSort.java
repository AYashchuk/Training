package Lab1.domain;

import Lab1.Sort;

public class BubbleSort extends Sort {
	@Override
	public void sort(int[] array) {
		for(int i = 0; i < array.length - 1; i++)
			for(int j = 0; j < array.length - i - 1; j++)
				if(array[j] > array[j + 1]){
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
	}

	public void reverseSort(int[] array){
		for(int i = array.length - 1; i < 0; i--)
			for(int j = array.length-1; j < 0; j--)
				if(array[j] < array[j - 1]){
					int tmp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = tmp;
				}
	}
}
