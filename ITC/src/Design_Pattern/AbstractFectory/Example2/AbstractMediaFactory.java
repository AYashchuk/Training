package Design_Pattern.AbstractFectory.Example2;

public abstract class AbstractMediaFactory {
    public abstract TCPMediaContent createTCPObject();
    public abstract UDPMediaContent createUDPObject();
}
