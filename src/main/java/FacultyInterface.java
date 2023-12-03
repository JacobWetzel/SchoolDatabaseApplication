import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacultyInterface extends JFrame implements ActionListener {
    JPanel master = new JPanel();
    JPanel mainMenu = mainMenu();
    JPanel addStudent = addStudent();
    public FacultyInterface(){
        setTitle("Faculty Login");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        master.add(mainMenu);
        master.add(addStudent);

        addStudent.setVisible(false);

        add(master);

        master.updateUI();
    }
    public JPanel mainMenu(){
        GridLayout layout = new GridLayout(3,1);
        layout.setHgap(50);
        layout.setVgap(20);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(15,20,15,20));

        JPanel superPanel = new JPanel();
        superPanel.setLayout(layout);

        JButton addStudentBtn = new JButton("Add Student");

        addStudentBtn.addActionListener(this);

        superPanel.add(addStudentBtn);

        mainPanel.add(superPanel, BorderLayout.CENTER);

        return mainPanel;

    }
    public JPanel addStudent(){
        JPanel infoScreen = new JPanel();
        infoScreen.setLayout(new BorderLayout());

        JLabel title = new JLabel("New Student");
        infoScreen.add(title, BorderLayout.NORTH);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        infoScreen.add(backBtn, BorderLayout.SOUTH);

        // create needed panel containers
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel studentID = new JPanel();
        studentID.setLayout(new FlowLayout());

        JPanel studentName = new JPanel();
        studentName.setLayout(new FlowLayout());

        JPanel dobPanel = new JPanel();
        dobPanel.setLayout(new FlowLayout());

        JPanel gpaPanel = new JPanel();
        gpaPanel.setLayout(new FlowLayout());

        JLabel studentIdLabel = new JLabel("Student ID: ");
        JTextField studentIdText = new JTextField("12345",15);
        JLabel studentPassLabel = new JLabel("Password: ");
        JTextField studentPassText = new JTextField("123456789",15);
        studentIdText.setBorder(new EmptyBorder(0,0,0,5));

        JLabel studentFNameLabel = new JLabel("First Name: ");
        JLabel studentLNameLabel = new JLabel("Last Name: ");
        JTextField studentFNameText = new JTextField(15);
        studentFNameText.setBorder(new EmptyBorder(0,0,0,5));
        //studentFNameText.setColumns(15);
        JTextField studentLNameText = new JTextField(15);

        JLabel dobLabel = new JLabel("Date of Birth: ");
        JTextField dobText = new JTextField("dd/mm/yyyy",10);

        JLabel gpaLabel = new JLabel("GPA: ");
        JTextField gpaText = new JTextField(5);

        studentID.add(studentIdLabel);
        studentID.add(studentIdText);

        studentName.add(studentFNameLabel);
        studentName.add(studentFNameText);
        studentName.add(studentLNameLabel);
        studentName.add(studentLNameText);

        dobPanel.add(dobLabel);
        dobPanel.add(dobText);

        gpaPanel.add(gpaLabel);
        gpaPanel.add(gpaText);

        panel.add(studentID);
        panel.add(studentName);
        panel.add(dobPanel);
        panel.add(gpaPanel);

        infoScreen.add(panel);

        return infoScreen;
    }
    private JPanel getActivePanel(){
        if (mainMenu.isVisible()){return mainMenu;}
        else if (addStudent.isVisible()){return addStudent;}
        //else if (viewClass.isVisible()){return viewClass;}
        //else if (viewAdvisor.isVisible()){return viewAdvisor;}
        else{ return mainMenu;}
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Add Student")){
            mainMenu.setVisible(false);
            addStudent.setVisible(true);
            master.updateUI();
        }
        else if (actionEvent.getActionCommand().equals("Back")){
            JPanel curPanel = getActivePanel();

            curPanel.setVisible(false);
            mainMenu.setVisible(true);
            master.updateUI();
        }
    }
}
