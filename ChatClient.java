import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatClient extends Client {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 8888;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public ChatClient() {
        super(SERVER_IP, SERVER_PORT);
    }


    @Override
    public void processMessage(String pMessage) {
        System.out.println(pMessage);
    }


    public static void main(String[] args) {
        ChatClient client = new ChatClient();

        if (client.isConnected()) {
            System.out.println("Connected to server");

            String command;
            try {
                while ((command = reader.readLine()) != null) {
                    if (command.equalsIgnoreCase("exit")) {
                        client.close();
                        break;
                    } else if (command.startsWith("SEND ")) {
                        client.send(command);
                    } else {
                        client.send(command);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to connect to server");
        }
    }
}