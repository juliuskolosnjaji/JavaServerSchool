import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    boolean ServerStarted = false;
    static MeinServer ChatServer;
    static JLabel LogLabel;
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

        JButton Button = new JButton("Ligma");
        JButton ServerStart = new JButton("Server");
        Button.setBounds(870, 30, 100, 40);
        ServerStart.setBounds(750, 30, 100, 40);
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked");
            }
        });

        ServerStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChatServer = new MeinServer(69);
                LogLabel.setText("Server started");
                System.out.println("Server Started GUi");
            }
        });

        JTextField ChatText = new JTextField(20);
        ChatText.setOpaque(true);
        ChatText.setBounds(20, 500, 700, 50);

        LogPanel.add(LogLabel);
        //Gui.add(LogLabel);
        Gui.add(Button);
        Gui.add(ChatText);
        Gui.add(ServerStart);
        Gui.setSize(1000, 600);
        Gui.setLayout(null);
        Gui.setVisible(true);
    }
}
