package Lab1.service.printer;

import java.util.Arrays;

public class Printer implements Printable{
	// Overview:
	// realisation my printer

	private boolean mode; // mod of print (standard/ or my)
	public Printer() {
	}

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
