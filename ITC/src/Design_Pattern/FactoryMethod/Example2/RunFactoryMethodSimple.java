package Design_Pattern.FactoryMethod.Example2;

public class RunFactoryMethodSimple {
    public static void main(String args[]) {
        AbstractOrder ob1 = OrderFactory.getOrderFromFactory("simple");
        AbstractOrder ob2 = OrderFactory.getOrderFromFactory("extended");
        ob1.perform();
        ob2.perform();
    }
}
