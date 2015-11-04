package Lab1.domain;

public class RecursiveSort extends Sort {
	private int ARRAY_LENGTH;
	private int[] array;

	public RecursiveSort() {
		this.nameOfSort = "Using method Recursive sort";
	}


	@Override
	protected void sorting(int[] array) {
		this.array = array;
		this.ARRAY_LENGTH = array.length;
		int startIndex = 0;
		int endIndex = ARRAY_LENGTH - 1;
		doSort(startIndex, endIndex);
	}


	private void doSort(int start, int end) {
		if (start >= end)
			return;
		int i = start, j = end;
		int cur = i - (i - j) / 2;
		while (i < j) {
			while (i < cur && (array[i] <= array[cur])) {
				i++;
			}
			while (j > cur && (array[cur] <= array[j])) {
				j--;
			}
			if (i < j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				if (i == cur)
					cur = j;
				else if (j == cur)
					cur = i;
			}
		}
		doSort(start, cur);
		doSort(cur+1, end);
	}
}
