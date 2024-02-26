import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Client oder Server: ");
        String input = scanner.next();
        System.out.println("*" + input + "*");
        if (Objects.equals(input, "Client")){
            MeinClient Client = new MeinClient("127.0.0.1", 69);
        }
        if (Objects.equals(input, "Server")){
            MeinServer Server = new MeinServer(69);
        }
    }
}