package Lab1.service.generator;

public class GenSoertArrayWithoutLastElement implements GenerateBehavior {
	@Override
	public void generate(int[] array) {
		for(int i=0;i<array.length;i++){
				if(i != array.length - 1) array[i] = i;
				else array[i] = (int)(Math.random()*100);
			}
	}

	@Override
	public String toString(){
		return "This generator generate sorted array, but last element is random";
	}
}
