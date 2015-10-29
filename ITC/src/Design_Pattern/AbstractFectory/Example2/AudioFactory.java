package Design_Pattern.AbstractFectory.Example2;

public class AudioFactory extends AbstractMediaFactory {
    public TCPMediaContent createTCPObject() {
        return new TCPAudioContent();
    }
    public UDPMediaContent createUDPObject() {
        return new UDPAudioContent();
    }
}
