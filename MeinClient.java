import java.util.Scanner;
public class MeinClient extends Client{

    public MeinClient(String pServerIP, int pServerPort) {
        super(pServerIP, pServerPort);
        System.out.println("Client Initialized");
        sendMessage();
    }

    @Override
    public void processMessage(String pMessage) {
        System.out.println(pMessage);
    }

    public void sendMessage(){
        Scanner message = new Scanner(System.in);
        System.out.println("Input Message:");
        send(message.nextLine());
        sendMessage();
    }
}
