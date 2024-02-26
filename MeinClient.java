import java.util.Scanner;
public class MeinClient extends Client{

    public MeinClient(String pServerIP, int pServerPort) {
        super(pServerIP, pServerPort);
        System.out.println("Client Initialized");

        while (true) {
            sendMessage();
        }
    }

    @Override
    public void processMessage(String pMessage) {
        System.out.println("From Server: " + pMessage);
    }

    public void sendMessage(){
        Scanner message = new Scanner(System.in);
        System.out.println("Gebe Nachricht ein: ");
        send(message.nextLine());
    }
}
