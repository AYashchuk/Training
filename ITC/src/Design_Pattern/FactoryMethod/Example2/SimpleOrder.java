package Design_Pattern.FactoryMethod.Example2;

public class SimpleOrder extends AbstractOrder {
    @Override
    public void perform() {
        System.out.println("SimpleOrder");
    }
}
