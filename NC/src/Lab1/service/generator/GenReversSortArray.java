package Lab1.service.generator;

public class GenReversSortArray implements GenerateBehavior {
	@Override
	public void generate(int[] array) {
		for(int i=0;i<array.length;i++){
				array[i] = array.length - i;
		}
	}

	@Override
	public String toString(){
		return "This generator generate revers sorted array";
	}
}
