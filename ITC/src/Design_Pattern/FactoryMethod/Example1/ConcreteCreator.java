package Design_Pattern.FactoryMethod.Example1;

public class ConcreteCreator extends Creator {
    @Override
    public Product factoryMethod() {
        this.anOperation();
        return new ConcretProduct();
    }
}
