package testing;
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
        String[] parts = pMessage.split(" ", 2);
        String command = parts[0];

        switch (command) {
            case "HELO":
                sendToAll("User " + parts[1] + "joined.");
                break;
            case "MSG":
            default:
                break;
        }
    }

    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {
        sendToAll("Client"+ pClientIP + "left");
    }
}