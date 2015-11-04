package Lab1.service.generator;

public class GenSortArray implements GenerateBehavior {
	@Override
	public void generate(int[] array) {
		for(int i=0;i<array.length;i++){
			array[i] = i;
		}
	}

	@Override
	public String toString(){
		return "This generator generate sorted array";
	}
}
