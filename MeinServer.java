
public class MeinServer extends Server{
    public MeinServer(int pPort) {
        super(pPort);
        System.out.println("Server Initialized");
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {
        System.out.println("neue connection: " + pClientIP + ":" + pClientPort);
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