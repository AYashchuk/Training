package Lab1.domain;

public class BubbleSort extends Sort {
	public BubbleSort() {
		this.nameOfSort = "Using method Bubble sort (line and revers) ";
	}

	@Override
	protected void sorting(int[] array) {
		if(!mod){
			System.out.println("line of bubble sort");
			for(int i = 0; i < array.length - 1; i++)
				for(int j = 0; j < array.length - i - 1; j++)
					if(array[j] > array[j + 1]){
						int tmp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = tmp;
					}
		} else reverseSort(array);
	}

	public void reverseSort(int[] array){
		System.out.println("revers of bubble sort");
		for(int i = array.length - 1; i > 0; i--)
			for(int j = array.length-1; j > 0; j--)
				if(array[j] < array[j - 1]){
					int tmp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = tmp;
				}
	}



}
