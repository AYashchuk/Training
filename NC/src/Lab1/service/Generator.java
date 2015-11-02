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
}
