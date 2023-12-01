import javax.swing.*;
import java.awt.event.*;
public class LoginWindow extends JFrame implements ActionListener{

    public LoginWindow(String frameTitle) {
        super(frameTitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }

}
