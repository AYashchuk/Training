package Lab1.service.generator;

public abstract class Generator{
	// Overview:
	// this class using for creating other class generators
	// for generators behavior using pattern Strategy

	protected String generatorName;               // generators name
	private GenerateBehavior generateBehavior;    // generators behavior (using interface)


	public Generator(GenerateBehavior generateBehavior,String generatorName) {
		this.generateBehavior = generateBehavior;
		this.generatorName = generatorName;
	}

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
