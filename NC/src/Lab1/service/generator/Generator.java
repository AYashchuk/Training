package Lab1.service.generator;

public abstract class Generator{
	protected String generatorName;
	private GenerateBehavior generateBehavior;


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
