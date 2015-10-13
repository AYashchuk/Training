package Design_Pattern.AbstractFectory.Example1;

public class ConcreteFactory implements AbstractFactory {
    public AbstractProduct createProduct() {
        System.out.println("Creating concrete product");
        AbstractProduct product = new ConcreteProduct();
        return product;
    }
}
