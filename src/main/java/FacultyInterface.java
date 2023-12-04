import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacultyInterface extends JFrame implements ActionListener {
    JPanel master;
    JPanel mainMenu;
    JPanel addStudent;
    JPanel modifyStudent;
    JPanel editStudent;
    JPanel addClass;
    JPanel modifyClass;
    JPanel editClass;

    JTextField studentIdText;
    JTextField studentPassText;
    JTextField studentFNameText;
    JTextField studentLNameText;
    JTextField dobText;
    JTextField gpaText;

    QueryFunctions queryFunctions;

    public FacultyInterface(){
        setTitle("Faculty Login");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        queryFunctions = new QueryFunctions();
        master = new JPanel();
        mainMenu = mainMenu();
        addStudent = addStudent();
        modifyStudent = modifyStudent();
        editStudent = editStudent();
        addClass = addClass();
        modifyClass = modifyClass();
        editClass = editClass();

        master.add(modifyClass);
        master.add(mainMenu);
        master.add(addStudent);
        master.add(modifyStudent);
        master.add(editStudent);
        master.add(addClass);
        master.add(editClass);

        modifyClass.setVisible(false);
        addClass.setVisible(false);
        editStudent.setVisible(false);
        addStudent.setVisible(false);
        modifyStudent.setVisible(false);
        editClass.setVisible(false);

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

        JButton addStudentBtn = new JButton("Add New Student");
        JButton removeStudentBtn = new JButton("Modify A Student");
        JButton addClassBtn = new JButton("Add a New Class");
        JButton modClassBtn = new JButton("Modify A Class");
        //JButton editStudentBtn = new JButton("Edit A Student");

        addClassBtn.addActionListener(this);
        removeStudentBtn.addActionListener(this);
        addStudentBtn.addActionListener(this);
        modClassBtn.addActionListener(this);
        //editStudentBtn.addActionListener(this);

        superPanel.add(addStudentBtn);
        superPanel.add(removeStudentBtn);
        superPanel.add(addClassBtn);
        superPanel.add(modClassBtn);
        //superPanel.add(editStudentBtn);

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
        studentIdText = new JTextField("12345",15);
        JLabel studentPassLabel = new JLabel("Password: ");


        studentPassText = new JTextField("123456789",15);
        studentIdText.setBorder(new EmptyBorder(0,0,0,5));

        JLabel studentFNameLabel = new JLabel("First Name: ");
        JLabel studentLNameLabel = new JLabel("Last Name: ");
        studentFNameText = new JTextField(15);
        studentFNameText.setBorder(new EmptyBorder(0,0,0,5));

        studentLNameText = new JTextField(15);

        JLabel dobLabel = new JLabel("Date of Birth: ");
        dobText = new JTextField("dd/mm/yyyy",10);

        JLabel gpaLabel = new JLabel("GPA: ");
        gpaText = new JTextField(5);

        JButton submitBtn = new JButton("Add Student");
        submitBtn.addActionListener(this);


        studentID.add(studentIdLabel);
        studentID.add(studentIdText);
        studentID.add(studentPassLabel);
        studentID.add(studentPassText);

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
        panel.add(submitBtn);

        infoScreen.add(panel);

        return infoScreen;
    }
    public JPanel modifyStudent(){
        JPanel infoScreen = new JPanel();
        infoScreen.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel options = new JPanel(new FlowLayout());

        JLabel title = new JLabel("Remove Student");
        infoScreen.add(title, BorderLayout.NORTH);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        infoScreen.add(backBtn, BorderLayout.SOUTH);

        JPanel student = new JPanel(new FlowLayout());

        JLabel StudentIdLabel = new JLabel("Student ID: ");
        JTextField StudentIdText = new JTextField("12345", 10);

        JButton removeBtn = new JButton("Remove Student");
        removeBtn.addActionListener(this);

        JButton editBtn = new JButton("Edit Student");
        editBtn.addActionListener(this);

        student.add(StudentIdLabel);
        student.add(StudentIdText);

        options.add(removeBtn);
        options.add(editBtn);

        panel.add(student);
        panel.add(options);

        infoScreen.add(panel,BorderLayout.CENTER);
        return infoScreen;
    }

    private JPanel editStudent(){
        boolean isUGrad = true;

        JPanel infoScreen = new JPanel();
        infoScreen.setLayout(new BorderLayout());

        JLabel title = new JLabel("Modifying Student");
        infoScreen.add(title, BorderLayout.NORTH);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        infoScreen.add(backBtn, BorderLayout.SOUTH);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel namePanel = new JPanel(new FlowLayout());
        JPanel dobPanel = new JPanel(new FlowLayout());
        JPanel gpaPanel = new JPanel(new FlowLayout());

        JLabel firstLabel = new JLabel("First Name: ");
        JLabel lastLabel = new JLabel("Last Name: ");
        JLabel dobLabel = new JLabel("Date of Birth: ");
        JLabel gpaLabel = new JLabel("GPA: ");


        //String FName = *some query to fetch first name from student ID*
        // create text field with this

        //String LName = *some query to fetch last name from student ID*
        // create text field with this

        //String DOB = * some query to fetch dob from student ID*
        // create text field with this

        //float GPA = * some query to fetch gpa from student ID*
        // create text field with this

        namePanel.add(firstLabel);
        // add textfield
        namePanel.add(lastLabel);
        // add textfield

        dobPanel.add(dobLabel);
        // add textfield

        gpaPanel.add(gpaLabel);
        // add textfield

        panel.add(namePanel);
        panel.add(dobPanel);
        panel.add(gpaPanel);
        //isUGrad = *some query to fetch*

        if (isUGrad){
            JPanel data = new JPanel(new FlowLayout());
            JLabel yearLabel = new JLabel("Year: ");
            JLabel majorLabel = new JLabel("Major: ");
            // String year = *some query*
            // String major = *some query*

            data.add(yearLabel);
            // textfield
            data.add(majorLabel);
            // textfield
            panel.add(data);

        }
        else{
            JPanel researchAreaPanel = new JPanel(new FlowLayout());
            JPanel typePanel = new JPanel(new FlowLayout());
            JPanel profIDPanel = new JPanel(new FlowLayout());

            JLabel researchAreaLabel = new JLabel("Research Area: ");
            JLabel typeLabel = new JLabel("Type: ");
            JLabel profIDLabel = new JLabel("Professor ID: ");

            // String researchArea = *some query*
            // create text field with this

            // String type = *some query*
            // create text field with this

            // String profID = *some query*
            // create text field with this

            researchAreaPanel.add(researchAreaLabel);
            // add text
            typePanel.add(typeLabel);
            //add text
            profIDPanel.add(profIDLabel);
            //add text

            panel.add(researchAreaPanel);
            panel.add(typePanel);
            panel.add(profIDPanel);

        }

        infoScreen.add(panel, BorderLayout.CENTER);
        return infoScreen;
    }



    private JPanel addClass(){
        JPanel infoScreen = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Adding Class");
        infoScreen.add(title, BorderLayout.NORTH);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        infoScreen.add(backBtn, BorderLayout.SOUTH);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        JPanel classIDPanel = new JPanel(new FlowLayout());
        JPanel infoPanel = new JPanel(new FlowLayout());    //class num, subject, credits

        JLabel classIDLabel = new JLabel("Class ID: ");
        JLabel subjectLabel = new JLabel("Subject: ");
        JLabel classNumLabel = new JLabel("Class Number: ");
        JLabel creditLabel = new JLabel("Credits: ");

        JTextField classIdText = new JTextField(5);
        JTextField subjectText = new JTextField(15);
        JTextField classNumText = new JTextField(5);
        JTextField creditText = new JTextField(5);

        JButton addClassBtn = new JButton("Add Class");
        addClassBtn.addActionListener(this);

        classIDPanel.add(classIDLabel);
        classIDPanel.add(classIdText);

        infoPanel.add(subjectLabel);
        infoPanel.add(subjectText);
        infoPanel.add(classNumLabel);
        infoPanel.add(classNumText);
        infoPanel.add(creditLabel);
        infoPanel.add(creditText);

        panel.add(classIDPanel);
        panel.add(infoPanel);
        panel.add(addClassBtn);

        infoScreen.add(panel);

        return infoScreen;
    }
    private JPanel modifyClass(){
        JPanel infoScreen = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Modifying A Class");
        infoScreen.add(title, BorderLayout.NORTH);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        infoScreen.add(backBtn, BorderLayout.SOUTH);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel coursePanel = new JPanel(new FlowLayout());

        JLabel courseIdLabel = new JLabel("Course ID: ");
        JTextField courseIdText = new JTextField(10);

        coursePanel.add(courseIdLabel);
        coursePanel.add(courseIdText);

        JPanel btnPanel = new JPanel(new FlowLayout());

        JButton delClassBtn = new JButton("Remove Class");
        JButton editClassBtn = new JButton("Edit Class");

        delClassBtn.addActionListener(this);
        editClassBtn.addActionListener(this);

        btnPanel.add(delClassBtn);
        btnPanel.add(editClassBtn);

        panel.add(coursePanel);
        panel.add(btnPanel);

        infoScreen.add(panel, BorderLayout.CENTER);

        return infoScreen;

    }
   private JPanel editClass(){
       JPanel infoScreen = new JPanel();
       infoScreen.setLayout(new BorderLayout());

       JLabel title = new JLabel("Modifying Class");
       infoScreen.add(title, BorderLayout.NORTH);

       JButton backBtn = new JButton("Back");
       backBtn.addActionListener(this);
       infoScreen.add(backBtn, BorderLayout.SOUTH);

       JPanel panel = new JPanel();
       panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

       JPanel classIdPanel = new JPanel(new FlowLayout());
       JPanel subjectPanel = new JPanel(new FlowLayout());
       JPanel infoPanel = new JPanel(new FlowLayout());

       JLabel classIdLabel = new JLabel("Class ID: ");
       JLabel subjectLabel = new JLabel("Subject: ");
       JLabel classNumLabel = new JLabel("Class Number: ");
       JLabel creditLabel = new JLabel("Credits: ");
       //String FName = *some query to fetch first name from student ID*
       // create text field with this

       //String LName = *some query to fetch last name from student ID*
       // create text field with this

       //String DOB = * some query to fetch dob from student ID*
       // create text field with this

       //float GPA = * some query to fetch gpa from student ID*
       // create text field with this

       classIdPanel.add(classIdLabel);
       // add textfield
       subjectPanel.add(subjectLabel);
       // add textfield

       infoPanel.add(classNumLabel);
       // add textfield

       infoPanel.add(creditLabel);
       // add textfield

       panel.add(classIdPanel);
       panel.add(subjectPanel);
       panel.add(infoPanel);
       //isUGrad = *some query to fetch*

       infoScreen.add(panel);
       return infoScreen;
   }



    private JPanel getActivePanel(){
        if (mainMenu.isVisible()){return mainMenu;}
        else if (addStudent.isVisible()){return addStudent;}
        else if (modifyStudent.isVisible()){return modifyStudent;}
        else if (editStudent.isVisible()){return editStudent;}
        else if (addClass.isVisible()){return addClass;}
        else if (modifyClass.isVisible()){return modifyClass;}
        else if (editClass.isVisible()){return editClass;}
        else{ return mainMenu;}
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Add New Student")){
            mainMenu.setVisible(false);
            addStudent.setVisible(true);
            master.updateUI();
        }
        if (actionEvent.getActionCommand().equals("Add a New Class")){
            mainMenu.setVisible(false);
            addClass.setVisible(true);
            master.updateUI();
        }
        else if (actionEvent.getActionCommand().equals("Modify A Student")){
            mainMenu.setVisible(false);
            modifyStudent.setVisible(true);
            master.updateUI();
        }
        else if (actionEvent.getActionCommand().equals("Modify A Class")){
            mainMenu.setVisible(false);
            modifyClass.setVisible(true);
            master.updateUI();
        }
        else if (actionEvent.getActionCommand().equals("Edit A Student")){
            mainMenu.setVisible(false);
            editStudent.setVisible(true);
            master.updateUI();
        }
        else if (actionEvent.getActionCommand().equals("Back")){
            JPanel curPanel = getActivePanel();
            if (curPanel == editStudent){
                curPanel.setVisible(false);
                modifyStudent.setVisible(true);
            }
            else if (curPanel == editClass){
                curPanel.setVisible(false);
                modifyClass.setVisible(true);
            }
            else {
                curPanel.setVisible(false);
                mainMenu.setVisible(true);
            }
            master.updateUI();
        }
        else if (actionEvent.getActionCommand().equals("Add Student")){
            String studentId = studentIdText.getText();
            String FName = studentFNameText.getText();
            String LName = studentLNameText.getText();
            String password = studentPassText.getText();
            String dob = dobText.getText();
            Double gpa = Double.parseDouble(gpaText.getText());

            Boolean inserted = queryFunctions.addStudentToStudentAndUG(studentId, FName, LName, dob, password, "Freshman", "Math", gpa, "Albert", "Einstein");
            if(inserted){
                //TODO display that student was added
            }
            else{
                //TODO display student wasn't added
            }

        }
        else if (actionEvent.getActionCommand().equals("Add Class")){
            // call sql command to add the student to the database
        }
        else if (actionEvent.getActionCommand().equals("Remove Student")){
            // call sql command to remove the student from the database
        }
        else if (actionEvent.getActionCommand().equals("Remove Class")){
            // call sql command to remove the student from the database
        }
        else if (actionEvent.getActionCommand().equals("Edit Student")){
            modifyStudent.setVisible(false);
            editStudent.setVisible(true);
            master.updateUI();
        }
        else if (actionEvent.getActionCommand().equals("Edit Class")){
            modifyClass.setVisible(false);
            editClass.setVisible(true);
            master.updateUI();
        }
    }
}
