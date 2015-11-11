package Lab1.service.generator;


/**
 * Overview:
 * This is realisation Behavior when generator generate sorted array, but last element is random
 * @author Yashchuk A. F.
 * @version 1.0
 *
 */
public class GenSoertArrayWithoutLastElement implements GenerateBehavior {
	/**
	 * Method Override parent, and using generator:
	 * This generator generate sorted array, but last element is random
	 * @author Yashchuk A. F.
	 * @param array - it is input array which we will be fill
	 */
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
