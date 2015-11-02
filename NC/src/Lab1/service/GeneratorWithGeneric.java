package Lab1.service;

public class GeneratorWithGeneric<Type>{
	private int depth;

	public GeneratorWithGeneric(int depth) {
		this.depth = depth;
	}

	public GeneratorWithGeneric(){
		this(10);
	}

	public void generate(Type t[]){
		for(int i=0;i<t.length;i++){
			if(t[i] instanceof Integer){
				Integer currentArray [] = (Integer[]) t[i];
				currentArray[i] = (int)(Math.random()*depth);
			}if(t[i] instanceof Double){
				Double currentArray[] = (Double[]) t[i];
				currentArray[i] = Math.random()*depth;
			}if(t[i] instanceof Float){
				Float currentArray[] = (Float[]) t[i];
				currentArray[i] = (float) Math.random()*depth;
			}if(t[i] instanceof Byte){
				Byte currentArray[] = (Byte[]) t[i];
				currentArray[i] = (byte) (Math.random()*depth);
			}if(t[i] instanceof Byte){
				Byte currentArray[] = (Byte[]) t[i];
				currentArray[i] = (byte) (Math.random()*depth);
			}if(t[i] instanceof Character){
				Character currentArray[] = (Character[]) t[i];
				currentArray[i] = (char) (Math.random()*depth);
			}

		}
	}
}
