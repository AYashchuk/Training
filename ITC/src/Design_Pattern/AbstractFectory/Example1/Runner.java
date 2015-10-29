package Design_Pattern.AbstractFectory.Example1;


public class Runner {
    public static void main(String[] args) {
        Client client = new Client();
        client.setAbstractFactory(new ConcreteFactory());
        client.action();
    }
}
