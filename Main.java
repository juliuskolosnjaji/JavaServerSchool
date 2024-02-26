public class Main {
    public static void main(String[] args) {
        MeinServer Server = new MeinServer(69);
        MeinClient Client = new MeinClient("172.0.0.1", 69);
    }
}
