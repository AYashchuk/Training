package Lab1.domain;


import Lab1.TypeOfSort;

/**
 * This class using method Bubble sort (line and revers);
 * @author Yashchuk A. F.
 *
 */
@MySorter(type = TypeOfSort.BUBBLE)
public class BubbleSort extends Sort {
	public BubbleSort() {
		this.nameOfSort = "Using method Bubble sort (line and revers) ";
	}

	/**
	 * Method sorting array (using first method)
	 * @param array - it is input array
	 */
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

	/**
	 * Method sorting array (using recursive method)
	 * @param array - it is input array
	 */
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
