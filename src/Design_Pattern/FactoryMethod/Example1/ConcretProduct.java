package Design_Pattern.FactoryMethod.Example1;

public class ConcretProduct implements Product {
    // some fields, constructors


    @Override
    public void check() {
        System.out.println("concrete product");
    }
}
