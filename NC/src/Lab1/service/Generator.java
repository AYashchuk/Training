package Lab1.service;

public class Generator {
	private int depth;

	public Generator(int depth) {
		this.depth = depth;
	}

	public Generator(){
		this(10);
	}

	public void generate(int array[], int mode){
		for(int i=0;i<array.length;i++){
			switch (mode){
				case 0:{
					array[i] = i;
					break;}
				case 1:{
					if(i != array.length - 1) array[i] = i;
					else array[i] = (int)(Math.random()*depth);
					break;}
				case 2:{
					array[i] = array.length - i;
					break;}
				default: array[i] = (int)(Math.random()*depth);
			}


		}
	}
}
