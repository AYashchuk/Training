package Lab1.service.printer;

import java.util.Arrays;

public class Printer {
	public Printer() {
	}

	public void print(int array[]){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

	public void toStringArray(int array[]){
		Arrays.toString(array);
	}
}
