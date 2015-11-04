package Lab1.service.generator;

public class MyGenerator extends Generator{

	public MyGenerator(GenerateBehavior generateBehavior) {
		super(generateBehavior, "Current behavior: " + generateBehavior.toString());
	}

	@Override
	public String toString(){
		return getGeneratorName();
	}
}
