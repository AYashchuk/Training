package Design_Pattern.FactoryMethod.Example2;

public class OrderFactory {
    public static AbstractOrder getOrderFromFactory(String type) {
        TypeOrder sign = TypeOrder.valueOf(type.toUpperCase());
        switch(sign) {
            case SIMPLE: return new SimpleOrder();
            case EXTENDED: return new ExtendedOrder();
            default : throw new EnumConstantNotPresentException(TypeOrder.class, sign.name());
        }
    }
    public void anOperation() {
        System.out.println("operation");
    }
}
