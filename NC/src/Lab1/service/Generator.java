package Lab1.service;

public class Generator {

	private int depth;

	public Generator(int depth) {
		this.depth = depth;
	}

	public Generator(){
		this(10);
	}

    public void generate(int array[]){
		for(int i=0;i<array.length;i++){
			array[i] = (int)(Math.random()*depth);
		}
	}

	public void generate(double array[]){
		for(int i=0;i<array.length;i++){
			array[i] = Math.random()*depth;
		}
	}

	public void generate(float array[]){
		for(int i=0;i<array.length;i++){
			array[i] = (float) (Math.random()*depth);
		}
	}

	public void generate(byte array[]){
		for(int i=0;i<array.length;i++){
			array[i] = (byte) (Math.random()*depth);
		}
	}

	public void generate(char array[]){
		for(int i=0;i<array.length;i++){
			if(depth == 10){
				array[i] = (char) (Math.random()*depth*10);
			} else array[i] = (char) (Math.random()*depth);

		}
	}
}
