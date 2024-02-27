public class ServerThread extends Thread{
    MeinServer Server;
    public void run(){
        System.out.println("Starting Serverthread...");
        Server = new MeinServer(69);
        System.out.println("Server started");
    }
    public void processNewConnection(String pClientIP, int pClientPort){
        Server.processNewConnection(pClientIP,pClientPort);
    }

    public void processMessage(String pClientIP, int pClientPort, String pMessage){
        Server.processMessage(pClientIP, pClientPort, pMessage);
    }

    public void processClosingConnection(String pClientIP, int pClientPort){
        Server.processClosingConnection(pClientIP,pClientPort);
    }
}
