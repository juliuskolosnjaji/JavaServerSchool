import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Gui {
    boolean ServerStarted = false;
    static JLabel LogLabel;
    static JTextArea LogText;
    static JLabel ChatLabel;
    static List<String> meinList;
    static String LogString;

    ServerThread serverThread;
    static ClientThread clientThread;
    public static void main(String[] args){
        createGui();
    }
    public static void startServer(){
        ServerThread serverThread = new ServerThread();
        serverThread.start();
    }

    public static void startClient(){
        Gui.clientThread = new ClientThread();
        clientThread.start();
    }

    public static void createGui(){
        //Window
        JFrame Gui = new JFrame();
        Gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel ServerLog = new JPanel();
        JPanel Chat = new JPanel();

        ServerLog.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Chat.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        ServerLog.setBounds(740, 100, 250, 450);
        Chat.setBounds(20, 30, 700, 440);

        LogLabel = new JLabel();
        ChatLabel = new JLabel();

        LogText = new JTextArea();
        LogText.setEditable(false);
        LogText.setLineWrap(true);
        ServerLog.add(LogText);
        LogText.setBounds(740, 50, 248, 450);

        JButton startClient = new JButton("Client");
        startClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startClient();
                LogText.append("Added Client\n");
            }
        });

        JButton startServer = new JButton("Server");
        startServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startServer();
                LogText.append("Started Server\n");
            }
        });

        startClient.setBounds(870, 30, 100, 40);
        startServer.setBounds(750, 30, 100, 40);

        JTextField ChatText = new JTextField(20);
        ChatText.setOpaque(true);
        ChatText.setBounds(20, 500, 700, 50);
        ChatText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChatLabel.setText(ChatText.getText());
                clientThread.sendMessage(ChatText.getText());
                System.out.println("Message Sent:" + ChatText.getText());
                ChatText.setText("");
            }
        });

        Gui.add(ServerLog);
        Gui.add(Chat);

        Gui.add(startServer);
        Gui.add(startClient);
        Chat.add(ChatLabel);
        Gui.add(ChatText);

        Gui.setSize(1000, 600);
        Gui.setLayout(null);
        Gui.setVisible(true);
    }
}

