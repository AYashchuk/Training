package Lab1.service.generator;

/**
 * Overview:
 * This class using for creating other class generators,
 * for generators behavior using pattern Strategy;
 * @author Yashchuk A. F.
 *
 */
public abstract class Generator{
	/** generators name   */
	protected String generatorName;
	/** generators behavior (using interface)  */
	private GenerateBehavior generateBehavior;


	public Generator(GenerateBehavior generateBehavior,String generatorName) {
		this.generateBehavior = generateBehavior;
		this.generatorName = generatorName;
	}

	/**
	 * Overview:
	 * Method delegates calling generation class behavior
	 * @author Yashchuk A. F.
	 * @param array - it is input array which we will be fill
	 */
	public  void generate(int[] array) {
		generateBehavior.generate(array);
	}

	public void setGenerateBehavior(GenerateBehavior generateBehavior) {
		this.generateBehavior = generateBehavior;
	}

	public String getGeneratorName() {
		return generatorName;
	}

	public void setGeneratorName(String generatorName) {
		this.generatorName = generatorName;
	}
}
