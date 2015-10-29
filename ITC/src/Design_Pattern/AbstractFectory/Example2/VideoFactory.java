package Design_Pattern.AbstractFectory.Example2;

public class VideoFactory extends AbstractMediaFactory {
    public TCPMediaContent createTCPObject() {
        return new TCPVideoContent();
    }
    public UDPMediaContent createUDPObject() {
        return new UDPVideoContent();
    }
}
