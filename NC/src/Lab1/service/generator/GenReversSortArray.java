package Lab1.service.generator;


/**
 * Overview:
 * This is realisation Behavior when generator generate revers sorted array
 * @author Yashchuk A. F.
 *
 */
public class GenReversSortArray implements GenerateBehavior {

	/**
	 * Method Override parent, and using generator:
	 * this generator  generate revers sorted array
	 * @author Yashchuk A. F.
	 * @param array - it is input array which we will be fill
	 */
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
