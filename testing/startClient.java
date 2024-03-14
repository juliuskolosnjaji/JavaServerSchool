package testing;
import java.util.Scanner;

public class startClient {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8888;
    public static void main(String[] args) {
        MeinClient client = new MeinClient(SERVER_IP, SERVER_PORT);
    }
}
