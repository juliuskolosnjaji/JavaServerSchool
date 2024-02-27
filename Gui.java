import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Gui {
    boolean ServerStarted = false;
    static MeinServer ChatServer;
    static JLabel LogLabel;
    static JTextArea LogText;
    static MeinClient ChatClient;
    static JLabel ChatLabel;
    static List<String> meinList;
    static String LogString;
    public static void main(String[] args){
        JFrame Gui = new JFrame();
        Gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel LogPanel = new JPanel();
        LogPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Gui.add(LogPanel);
        LogPanel.setBounds(740, 100, 250, 450);

        JPanel Chat = new JPanel();
        Chat.setBorder(BorderFactory.createLineBorder(Color.black));
        Gui.add(Chat);
        Chat.setBounds(20, 30, 700, 440);

        LogLabel = new JLabel();
        ChatLabel = new JLabel();
        meinList = new ArrayList<String>();
        LogString = new String();

        LogText = new JTextArea();
        LogText.setEditable(false);
        LogText.setLineWrap(true);
        LogPanel.add(LogText);
        LogText.setBounds(740, 50, 248, 450);

        JButton Button = new JButton("Client");
        JButton ServerStart = new JButton("Server");
        Button.setBounds(870, 30, 100, 40);
        ServerStart.setBounds(750, 30, 100, 40);
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Added Client");
                LogText.append("Added Client\n");
                ChatClient = new MeinClient("127.0.0.1", 69);
            }
        });

        ServerStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChatServer = new MeinServer(69);
                LogText.append("Started Server\n");
                System.out.println("Server Started GUi");
            }
        });

        JTextField ChatText = new JTextField(20);
        ChatText.setOpaque(true);
        ChatText.setBounds(20, 500, 700, 50);

        ChatText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChatClient.sendMessage(ChatText.getText());
                ChatLabel.setText(ChatText.getText());
                System.out.println("Message Sent:" + ChatText.getText());
                ChatText.setText("");
            }
        });

        //LogPanel.add(LogLabel);
        Chat.add(ChatLabel);
        //Gui.add(LogLabel);
        Gui.add(Button);
        Gui.add(ChatText);
        Gui.add(ServerStart);
        Gui.setSize(1000, 600);
        Gui.setLayout(null);
        Gui.setVisible(true);
    }
}
