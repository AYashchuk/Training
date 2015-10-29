package Design_Pattern.FactoryMethod.Example1;

public abstract class Creator {
    public abstract Product factoryMethod();
    public void anOperation(){
        System.out.println("operation");
    }
}
