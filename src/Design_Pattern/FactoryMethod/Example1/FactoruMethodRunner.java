package Design_Pattern.FactoryMethod.Example1;

public class FactoruMethodRunner {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        Product product = creator.factoryMethod();
        product.check();
    }
}
