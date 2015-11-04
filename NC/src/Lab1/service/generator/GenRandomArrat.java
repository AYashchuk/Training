package Lab1.service.generator;

public class GenRandomArrat implements GenerateBehavior {

	@Override
	public void generate(int[] array) {
		for(int i=0;i<array.length;i++){
				array[i] = (int)(Math.random()*100);
		}
	}

	@Override
	public String toString(){
		return "This generator generate random array";
	}

}
