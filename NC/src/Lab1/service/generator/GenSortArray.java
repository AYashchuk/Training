package Lab1.service.generator;


/**
 * Overview:
 * This is realisation Behavior when generator generate sorted array
 * @author Yashchuk A. F.
 * @version 1.0
 *
 */
public class GenSortArray implements GenerateBehavior {
	/**
	 * Method Override parent, and using generator:
	 * This generator generate sorted array
	 * @author Yashchuk A. F.
	 * @param array - it is input array which we will be fill
	 */
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
