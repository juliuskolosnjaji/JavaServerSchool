
public class MeinServer extends Server{
    public MeinServer(int pPort) {
        super(pPort);

    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {
        sendToAll("New Client:" + pClientIP);
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        sendToAll(pMessage);
    }

    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {
        sendToAll("Client"+ pClientIP + "left");
    }
}
