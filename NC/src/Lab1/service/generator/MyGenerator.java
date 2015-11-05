package Lab1.service.generator;

public class MyGenerator extends Generator{
	//Overview:
	// this is class realisation of abstract class Generator

	public MyGenerator(GenerateBehavior generateBehavior) {
		super(generateBehavior, "Current behavior: " + generateBehavior.toString());
	}

	@Override
	public String toString(){
		return getGeneratorName();
	}
}
