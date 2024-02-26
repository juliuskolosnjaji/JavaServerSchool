public class MeinClient extends Client{

    public MeinClient(String pServerIP, int pServerPort) {
        super(pServerIP, pServerPort);
    }

    @Override
    public void processMessage(String pMessage) {
        System.out.println(pMessage);
    }

    public void sendMessage(){
        send("Test");
    }
}
