package Lab1.service;

public class Printer {
    public void print(String array[]){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public void print(byte array[]){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public void print(int array[]){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public void print(double array[]){
        for(int i=0;i<array.length;i++){
            System.out.print(String.format("%.2f", array[i]) + " ");
        }
    }

    public void print(char array[]){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

	public void print(float array[]){
		for(int i=0;i<array.length;i++){
			System.out.print(String.format("%.2f", array[i])+" ");
		}
	}


}
