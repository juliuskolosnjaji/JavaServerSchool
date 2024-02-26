public class Main {

    public static void main(String[] args) {
        String ip = "192.168.14.229";
        int port = 255;
        Connection con = new Connection(ip, port);
        con.send("jo");
        con.receive();

        System.out.println(con.receive());
        con.close();
        
    }
    
}