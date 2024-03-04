import javax.swing.*;
import java.awt.*;

public class ServerGui {
    String log;

    public MeinServer startServer(){
        MeinServer server = new MeinServer(69){
            @Override
            public void processNewConnection(String pClientIP, int pClientPort) {
                log = log + "neue connection: " + pClientIP + ":" + pClientPort + "\n";
            }

            @Override
            public void processMessage(String pClientIP, int pClientPort, String pMessage) {
                sendToAll(pMessage);
                log = log + "[MSG] " + pClientIP + ": " + pMessage + "\n";
            }

            @Override
            public void processClosingConnection(String pClientIP, int pClientPort) {
                sendToAll("Client"+ pClientIP + "left");
                log = log + "[INFO] " + pClientIP + " left" + "\n";
            }

        };
        MeinServer MeinServer = null;
        return MeinServer;
    }
    Font font = new Font("serif", Font.BOLD, 20);
    public static void main(String[] args) {
        createGui();
    }

    public static void createGui(){
        JFrame Gui = new JFrame();
        Gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Gui.setSize(1000, 600);

        JPanel serverLog = new JPanel();
        serverLog.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        serverLog.setBounds(25, 50, 950, 500);

        JLabel Log = new JLabel("Log");
        Log.setBounds(500, 10, 100, 30);
        Log.setFont(new Font("serif", Font.BOLD, 20));
        JScrollPane logScroll = new JScrollPane(serverLog);
        Log.setAutoscrolls(true);

        JTextArea logText = new JTextArea();


        Gui.add(serverLog);
        Gui.add(Log);
        serverLog.add(logScroll);
        Gui.setLayout(null);
        Gui.setVisible(true);
    }
}
