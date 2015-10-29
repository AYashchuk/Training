package Design_Pattern.AbstractFectory.Example2;

public class Client {
    private UDPMediaContent contentUDP;
    private TCPMediaContent contentTCP;
    public void makeMediaFactoryWork(AbstractMediaFactory factory){
        contentUDP = factory.createUDPObject();
        contentTCP = factory.createTCPObject();
// использование созданных объектов
    }
}