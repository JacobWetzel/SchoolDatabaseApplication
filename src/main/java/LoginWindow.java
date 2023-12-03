import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginWindow extends JFrame implements ActionListener{

    JTextField usernameField;
    JPasswordField passField;

    JPanel mainPanel;

    public LoginWindow(String frameTitle) {
        super(frameTitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);


        mainPanel = new JPanel();                // create main panel
       // mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));    // give it a vertical layout


        /* Create Username enter field */

        mainPanel.add(new JLabel("Username:"));
        usernameField = new JTextField(10);
        mainPanel.add(usernameField);

        /* End username enter field */


        /* Begin Password enter field */

        mainPanel.add(new JLabel("Password:"));
        passField = new JPasswordField(15);
        mainPanel.add(passField);

        /* End Password enter field */


        /* create button and button action listener */

        JButton submit = new JButton("Submit");
        mainPanel.add(submit);

        String username = "";
        String password = "";
        add(mainPanel);

        setVisible(true);
        submit.addActionListener(this::actionPerformed);

    }


    boolean invalidVisible = false;
    JLabel invalid = new JLabel("Invalid Input");

    @Override
    public void actionPerformed(ActionEvent e){
            String username = usernameField.getText();
            String password = new String(passField.getPassword());
            QueryFunctions db = new QueryFunctions();
            if (db.studentCredentialsValidation(username, password)) {
                System.out.println("Student LOGIN SUCCESSFUL");
                StudentInterface studentInterface = new StudentInterface();
                studentInterface.setVisible(true);
                dispose();
            }
            if (db.facultyCredentialsValidation(username, password)) {
                System.out.println("faculty LOGIN SUCCESSFUL");
                FacultyInterface facultyInterface = new FacultyInterface();
                facultyInterface.setVisible(true);
                dispose();
            }
            else {
                if (!invalidVisible) {
                    mainPanel.add(invalid);
                    setVisible(true);
                    invalidVisible = true;
                }
            }

        }

}
