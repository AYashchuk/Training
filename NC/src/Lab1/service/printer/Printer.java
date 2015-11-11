package Lab1.service.printer;

import java.util.Arrays;


/**
 * Overview:
 * This class it is realisation my printer;
 * @author Yashchuk A. F.
 *
 */
public class Printer implements Printable {

	private boolean mode; // mod of print (standard/ or my)
	public Printer() {
	}

	/**
	 * Ovewrview:
	 * This method testing different type of sort
	 * @param array - it is input array which we printing
	 * @return void
	 */
	@Override
	public void print(int array[]){
		if(!mode) toStringArray(array);
		else	for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}


	public void toStringArray(int array[]){
		System.out.println(Arrays.toString(array));
	}

	public void setMode(boolean mode) {
		this.mode = mode;
	}

	public boolean isMode() {
		return mode;
	}
}
