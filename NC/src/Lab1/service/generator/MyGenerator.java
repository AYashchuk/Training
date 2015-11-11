package Lab1.service.generator;


/**
 * Overview:
 * This is class realisation of abstract class Generator;
 * @author Yashchuk A. F.
 * @version 1.0
 *
 */
public class MyGenerator extends Generator{
	public MyGenerator(GenerateBehavior generateBehavior) {
		super(generateBehavior, "Current behavior: " + generateBehavior.toString());
	}

	@Override
	public String toString(){
		return getGeneratorName();
	}
}
