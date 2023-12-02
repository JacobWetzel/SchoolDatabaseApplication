import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginWindow extends JFrame implements ActionListener{

    JTextField usernameField;
    JPasswordField passField;


    public LoginWindow(String frameTitle) {
        super(frameTitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);


        JPanel mainPanel = new JPanel();                // create main panel
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
        submit.addActionListener(this::actionPerformed);

    /*
        ////// BEGINNING OF CREATION FOR STUDENT BUTTONS ////////
        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new BorderLayout());
        studentPanel.setBorder(new EmptyBorder(10,10,10,10));

        JLabel studentLabel = new JLabel("Student:");
        studentLabel.setFont(new Font("Serif", Font.PLAIN, 20));

        JButton addStudentBtn = new JButton("Add Student"); // add student Button
        JButton delStudentBtn = new JButton("Delete Student");  // del student button
        JButton modStudentBtn = new JButton("Modify Student");  // modify student button

        addStudentBtn.addActionListener(this);
        delStudentBtn.addActionListener(this);
        modStudentBtn.addActionListener(this);

        studentPanel.add(studentLabel, BorderLayout.NORTH);
        studentPanel.add(addStudentBtn, BorderLayout.LINE_START);
        studentPanel.add(delStudentBtn, BorderLayout.CENTER);
        studentPanel.add(modStudentBtn, BorderLayout.LINE_END);

        mainPanel.add(studentPanel);

        ///////// END OF CREATION FOR STUDENT BUTTONS ///////

        //////// BEGINNING OF CREATION FOR REQUIRED CLASS BUTTONS //////
        JPanel reqClassPanel = new JPanel();
        reqClassPanel.setLayout(new BorderLayout());
        reqClassPanel.setBorder(new EmptyBorder(10,10,10,10));

        JLabel reqClasslbl = new JLabel("Required Classes:");
        reqClasslbl.setFont(new Font("Serif", Font.PLAIN, 20));
        JButton addReqClassBtn = new JButton("Add Class");
        JButton delReqClassBtn = new JButton("Remove Class");
        JButton modReqClassBtn = new JButton("Modify Class");

        addReqClassBtn.addActionListener(this);
        delReqClassBtn.addActionListener(this);
        modReqClassBtn.addActionListener(this);

        reqClassPanel.add(reqClasslbl, BorderLayout.NORTH);
        reqClassPanel.add(addReqClassBtn, BorderLayout.LINE_START);
        reqClassPanel.add(delReqClassBtn, BorderLayout.CENTER);
        reqClassPanel.add(modReqClassBtn, BorderLayout.LINE_END);

        mainPanel.add(reqClassPanel);

        ///////// END OF CREATION FOR REQUIRED CLASS BUTTONS /////////

        ///////// BEGINNING OF CREATION FOR MAJOR BUTTONS //////////
        JPanel majorPanel = new JPanel();
        majorPanel.setLayout(new BorderLayout());
        majorPanel.setBorder(new EmptyBorder(10,10,10,10));

        JLabel majorLabel = new JLabel("Majors: ");
        majorLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        JButton addMajor = new JButton("Add Major");
        JButton delMajor = new JButton("Remove Major");
        JButton modMajor = new JButton("Modify Major");

        addMajor.addActionListener(this);
        delMajor.addActionListener(this);
        modMajor.addActionListener(this);

        majorPanel.add(majorLabel, BorderLayout.NORTH);
        majorPanel.add(addMajor, BorderLayout.LINE_START);
        majorPanel.add(delMajor, BorderLayout.CENTER);
        majorPanel.add(modMajor, BorderLayout.LINE_END);

        mainPanel.add(majorPanel);

        ///////// END OF CREATION FOR MAJOR BUTTONS ///////////
    */




        add(mainPanel);

        setVisible(true);
    }

    public void createDB(){
        String url = "jdbc:sqlite:./src/main/java/Databases/Faculty.SQLite";
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connection made");
                try (Statement stmt = conn.createStatement()) {
                    ResultSet testSet = stmt.executeQuery("SELECT * FROM Faculty");

                    while(testSet.next()){
                        System.out.println("ID, fname, lname " + testSet.getInt("FacultyID") + " " + testSet.getString("Fname") + " "+ testSet.getString("Lname"));
                    }

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    @Override
    public void actionPerformed(ActionEvent e){
        String username = usernameField.getText();
        String password = new String(passField.getPassword());
        QueryFunctions db = new QueryFunctions();
        if(db.studentCredentialsValidation(username, password)){
            System.out.println("Student LOGIN SUCCESSFUL");
        }
        else{
            System.out.println("Student LOGIN FAILED");
        }
        if(db.facultyCredentialsValidation(username, password)){
            System.out.println("faculty LOGIN SUCCESSFUL");
        }
        else{
            System.out.println("faculty LOGIN FAILED");
        }

    }

}
