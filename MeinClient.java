import java.util.Scanner;
public class MeinClient extends Client{

    public MeinClient(String pServerIP, int pServerPort) {
        super(pServerIP, pServerPort);
        System.out.println("Client Initialized");
    }

    @Override
    public void processMessage(String pMessage) {
        System.out.println("From Server: " + pMessage);
    }

    public void sendMessage(String Message){
        send(Message);
    }
}
