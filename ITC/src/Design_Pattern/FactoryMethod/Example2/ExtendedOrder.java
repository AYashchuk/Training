package Design_Pattern.FactoryMethod.Example2;

public class ExtendedOrder extends AbstractOrder {
    @Override
    public void perform() {
        System.out.println("ExtendedOrder");
    }
}
