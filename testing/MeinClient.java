package testing;

import java.util.Scanner;

public class MeinClient extends Client{

    public MeinClient(String pServerIP, int pServerPort) {
        super(pServerIP, pServerPort);
        System.out.println("Client Initialized");
        
    }

    public void chat(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        send(input);
    }

    @Override
    public void processMessage(String pMessage) {
        System.out.println("From Server: " + pMessage);
    }

    public void sendMessage(String Message){
        send(Message);
    }
}