package Lab1.service.generator;


/**
 * Overview:
 * This is realisation Behavior when generator generate random array
 * @author Yashchuk A. F.
 *
 */
public class GenRandomArrat implements GenerateBehavior {
	/**
	 * Method Override parent, and using generator:
	 * this generator generate random array
	 * @author Yashchuk A. F.
	 * @param array - it is input array which we will be fill
	 */
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
