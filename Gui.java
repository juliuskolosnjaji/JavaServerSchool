import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    public static void main(String[] args){
        JFrame Gui = new JFrame();
        Gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton Button = new JButton("click");
        Button.setBounds(130, 100, 100, 40);
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked");
            }
        });

        Gui.add(Button);
        Gui.setSize(400, 500);
        Gui.setLayout(null);
        Gui.setVisible(true);
    }
}
