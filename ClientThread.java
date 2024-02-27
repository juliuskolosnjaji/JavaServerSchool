public class ClientThread extends Thread{
    MeinClient Client;
    public void run(){
        System.out.println("Starting Client");
        Client = new MeinClient("127.0.0.1", 69);
        System.out.println("Client Initialized");
    }

    public void processMessage(String pMessage){
        Client.processMessage(pMessage);
    }
    public void sendMessage(String Message){
        Client.sendMessage(Message);
    }
}
