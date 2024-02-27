import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    public static void main(String[] args){
        JFrame Gui = new JFrame();
        Gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel Log = new JPanel();
        Log.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Gui.add(Log);
        Log.setBounds(500, 500, 100, 100);

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

        JTextField ChatText = new JTextField(20);
        ChatText.setOpaque(true);
        ChatText.setBounds(30, 500, 700, 50);


        Gui.add(Button);
        Gui.add(ChatText);
        Gui.add(ServerStart);
        Gui.setSize(1000, 600);
        Gui.setLayout(null);
        Gui.setVisible(true);
    }
}
