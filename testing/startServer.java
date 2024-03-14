package testing;

public class startServer {    
    public static final int SERVER_PORT = 8888;
    public static void main(String[] args) {
        MeinServer server = new MeinServer(SERVER_PORT);
        System.out.println("Server started. Listening on port " + SERVER_PORT);
    }
}
