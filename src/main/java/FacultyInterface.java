import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FacultyInterface extends JFrame implements ActionListener {
    String[] yearList= {"Freshman", "Sophomore", "Junior", "Senior"};
    JPanel selectingClass;
    int classIdx;
    List<String> studentList;
    JTextField dobEdit;
    String dobS;
    JTextField gpaEdit;
    String gpaS;
    String selectedClassID;
    boolean isSorted = false;
    String[] classIdList;// = {"CMPSC 465","CMPSC 473", "ENG 202", "HIST 20"};
    JLabel isAdded;
    JTextField classIdEdit;
    JLabel failAdded;
    boolean isViewing;
    JComboBox classIdCb;
    String temp;
    String temp2;
    String temp3;
    String temp4;
    JTextField majorTextNS;
    JTextField advisorTextNS;
    JComboBox yearCb;
    String classIDName;        // TODO this is the "CMPSC 431"
    String classSubjectName;        // TODO this is the "Database Management Systems"
    String pName;               // TODO professors name
    String genEd;               // TODO genEds (if it needs to be an array lmk)
    String[] studentNameList;   // TODO list of students in the class
    JPanel master;
    JPanel mainMenu;
    JPanel addStudent;
    JPanel modifyStudent;
    JPanel editStudent;
    JPanel addClass;
    JPanel modifyClass;
    JTextField FNameEdit;
    JTextField LNameEdit;
    JPanel editClass;

    JTextField subjectEdit;
    JTextField classNumEdit;
    JTextField creditEdit;
    String fnameS;
    String lnameS;



    String facultyId;

    JTextField studentIdText;
    JTextField studentPassText;
    JTextField studentFNameText;
    JTextField studentLNameText;
    JTextField dobText;
    JTextField gpaText;
    JPanel mo;
    JPanel viewStudent;

    RetrieveFunctions retrieveFunctions;

    QueryFunctions queryFunctions;

    JPanel viewClass;

    public FacultyInterface(String facultyID){
        facultyId = facultyID;
        retrieveFunctions = new RetrieveFunctions();
        isViewing = false;
        mo = new JPanel(new FlowLayout());
        classIdList = retrieveFunctions.getClassIDList();
        isAdded = new JLabel("Success");
        failAdded = new JLabel("Failed");
        isAdded.setVisible(false);
        setTitle("Faculty Login");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        queryFunctions = new QueryFunctions();
        master = new JPanel();
        master.setLayout(new BoxLayout(master, BoxLayout.Y_AXIS));
        viewClass = viewClass();
        mainMenu = mainMenu();
        addStudent = addStudent();
        modifyStudent = modifyStudent();
        editStudent = editStudent();
        addClass = addClass();
        modifyClass = modifyClass();
        editClass = editClass();
        viewStudent = viewStudent();
        viewClass = viewClass();
        selectingClass = selectingClass();

        master.add(viewStudent);
        master.add(selectingClass);
        master.add(modifyClass);
        master.add(mainMenu);
        master.add(addStudent);
        master.add(modifyStudent);
        master.add(editStudent);
        master.add(addClass);
        master.add(editClass);
        master.add(viewClass);
        master.add(isAdded);
        master.add(failAdded);

        modifyClass.setVisible(false);
        addClass.setVisible(false);
        editStudent.setVisible(false);
        addStudent.setVisible(false);
        modifyStudent.setVisible(false);
        editClass.setVisible(false);
        viewClass.setVisible(false);
        isAdded.setVisible(false);
        failAdded.setVisible(false);
        selectingClass.setVisible(false);
        viewStudent.setVisible(false);
        mo.add(master);
        add(mo);

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
        JButton viewClassBtn = new JButton("View A Class");
        JButton viewStudents = new JButton("View Students");
        //JButton editStudentBtn = new JButton("Edit A Student");

        addClassBtn.addActionListener(this);
        removeStudentBtn.addActionListener(this);
        addStudentBtn.addActionListener(this);
        modClassBtn.addActionListener(this);
        viewClassBtn.addActionListener(this);
        viewStudents.addActionListener(this);
        //editStudentBtn.addActionListener(this);

        superPanel.add(addStudentBtn);
        superPanel.add(removeStudentBtn);
        superPanel.add(addClassBtn);
        superPanel.add(modClassBtn);
        superPanel.add(viewClassBtn);
        superPanel.add(viewStudents);
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

        JPanel yearPanel = new JPanel(new FlowLayout());
        JLabel yearLabel = new JLabel("Year: ");
        yearCb = new JComboBox(yearList);

        JPanel advisorPanel = new JPanel(new FlowLayout());
        JLabel advisorLabel = new JLabel("Advisor");
        advisorTextNS = new JTextField(15);

        JPanel majorPanel = new JPanel(new FlowLayout());
        JLabel majorLabel = new JLabel("Major: ");
        majorTextNS = new JTextField(15);

        yearPanel.add(yearLabel);
        yearPanel.add(yearCb);

        advisorPanel.add(advisorLabel);
        advisorPanel.add(advisorTextNS);

        majorPanel.add(advisorLabel);
        majorPanel.add(advisorTextNS);

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
        panel.add(yearPanel);
        panel.add(majorPanel);
        panel.add(advisorPanel);
        panel.add(submitBtn);
        panel.add(isAdded);
        panel.setBorder(new EmptyBorder(5,5,5,5));

        infoScreen.add(panel);

        return infoScreen;
    }

    JTextField StudentIdModifyText;
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
        StudentIdModifyText = new JTextField("12345", 10);

        JButton removeBtn = new JButton("Remove Student");
        removeBtn.addActionListener(this);

        JButton editBtn = new JButton("Edit Student");
        editBtn.addActionListener(this);

        student.add(StudentIdLabel);
        student.add(StudentIdModifyText);

        options.add(removeBtn);
        options.add(editBtn);

        panel.add(student);
        panel.add(options);

        infoScreen.add(panel,BorderLayout.CENTER);
        return infoScreen;
    }



    JTextField editFName;
    String editFNameString;
    JTextField editLName;
    String editLNameString;
    JTextField editSubject;
    String editSubjectString;
    JTextField editDOB;
    String editDOBString;
    JTextField editGPA;
    String editGPAString;




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
        
        editFNameString = "";

        editLNameString = "";
        editSubjectString = "";
        editDOBString = "";
        editGPAString = "";
        editFName = new JTextField(editFNameString, 15);
        editLName = new JTextField(editLNameString, 15);
        editSubject = new JTextField(editSubjectString, 15);
        editDOB = new JTextField(editDOBString, 15);
        editGPA = new JTextField(editGPAString, 15);




        //String FName = *some query to fetch first name from student ID*
        //TODO create text field with this
        fnameS = "John";   // replace with query
        FNameEdit = new JTextField(fnameS,12);

        //String LName = *some query to fetch last name from student ID*
        //TODO create text field with this
        lnameS = "Smith"; // replace with query
        LNameEdit = new JTextField(lnameS,15);
        //String DOB = * some query to fetch dob from student ID*
        //TODO create text field with this
        dobS = "03/12/2000";
        dobEdit = new JTextField(dobS, 5);
        //float GPA = * some query to fetch gpa from student ID*
        gpaS = "3.1";
        gpaEdit = new JTextField(gpaS, 5);
        //TODO create text field with this

        namePanel.add(firstLabel);

        namePanel.add(editFName);
        // add textfield
        namePanel.add(lastLabel);
        namePanel.add(editLName);
        // add textfield

        dobPanel.add(dobLabel);
        dobPanel.add(editDOB);
        // add textfield

        gpaPanel.add(gpaLabel);
        gpaPanel.add(editGPA);

        // add textfield

        panel.add(namePanel);
        panel.add(dobPanel);
        panel.add(gpaPanel);
        
        //isUGrad = *some query to fetch*

        /*if (isUGrad){
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

        }*/

        infoScreen.add(panel, BorderLayout.CENTER);
        return infoScreen;
    }

    JTextField classIdText;
    JTextField DeptIdText;
    JTextField subjectText;
    JTextField classNumText;
    JTextField creditText;


    private JPanel addClass(){
        JPanel infoScreen = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Adding Class");
        infoScreen.add(title, BorderLayout.NORTH);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        infoScreen.add(backBtn, BorderLayout.SOUTH);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        JPanel IDPanel = new JPanel(new FlowLayout());
        JPanel infoPanel = new JPanel(new FlowLayout());    //class num, subject, credits

        JLabel classIDLabel = new JLabel("Class ID: ");
        JLabel profIDLabel = new JLabel("Department: ");
        JLabel subjectLabel = new JLabel("Subject: ");
        JLabel classNumLabel = new JLabel("Class Number: ");
        JLabel creditLabel = new JLabel("Credits: ");

        classIdText = new JTextField(10);
        DeptIdText = new JTextField(10);
        subjectText = new JTextField(15);
        classNumText = new JTextField(5);
        creditText = new JTextField(5);

        JButton addClassBtn = new JButton("Add Class");
        addClassBtn.addActionListener(this);

        IDPanel.add(classIDLabel);
        IDPanel.add(classIdText);
        IDPanel.add(profIDLabel);
        IDPanel.add(DeptIdText);

        infoPanel.add(subjectLabel);
        infoPanel.add(subjectText);
        infoPanel.add(classNumLabel);
        infoPanel.add(classNumText);
        infoPanel.add(creditLabel);
        infoPanel.add(creditText);

        panel.add(IDPanel);
        panel.add(infoPanel);
        panel.add(addClassBtn);

        infoScreen.add(panel);

        return infoScreen;
    }

    JTextField courseIdText;

    public JPanel viewStudent(){
        JPanel infoScreen = new JPanel(new BorderLayout());
        JLabel title = new JLabel("All Students");
        infoScreen.add(title, BorderLayout.NORTH);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        infoScreen.add(backBtn, BorderLayout.SOUTH);

        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new BoxLayout(studentPanel,BoxLayout.Y_AXIS));
        if (!isSorted) {
            studentList = retrieveFunctions.AllStudents();
        }
        JButton sortBtn = new JButton("Sort by GPA");
        sortBtn.addActionListener(this);
        studentPanel.add(sortBtn);

        for (String s: studentList){
            JLabel student = new JLabel(s);
            studentPanel.add(student);
        }
        infoScreen.add(studentPanel);

        return infoScreen;
    }
    public JPanel modifyClass(){
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


        classIdList = retrieveFunctions.getClassIDList();
        classIdCb = new JComboBox(classIdList);


        courseIdText = new JTextField(10);
        coursePanel.add(courseIdLabel);
        coursePanel.add(classIdCb);

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
       //TODO get selected class ID
       String temp = classIdList[classIdx];
        classIdEdit = new JTextField(temp, 15);

       // TODO fetch class subject
       JTextField subjectEdit = new JTextField(temp2,30);

       //TODO fetch class number
       String temp3 = "1432";
        classNumEdit = new JTextField(temp3,7);

       //TODO fetch class credit req.
       String temp4 = "3.0";
       creditEdit = new JTextField(temp4,5);

       classIdPanel.add(classIdLabel);
       // add textfield
       classIdPanel.add(classIdEdit);

       subjectPanel.add(subjectLabel);
       subjectPanel.add(subjectEdit);


       infoPanel.add(classNumLabel);
       infoPanel.add(classNumEdit);


       infoPanel.add(creditLabel);
       infoPanel.add(creditEdit);


       panel.add(classIdPanel);
       panel.add(subjectPanel);
       panel.add(infoPanel);


       infoScreen.add(panel);
       return infoScreen;
   }



   //SELECT WHICH CLASS YOU WANT TO SEE METADATA FOR
    private JPanel selectingClass(){
        JPanel infoScreen = new JPanel(new BorderLayout());

        JPanel upper = new JPanel();
        upper.setLayout(new BoxLayout(upper, BoxLayout.Y_AXIS));

        JButton viewingBtn = new JButton("View");
        viewingBtn.addActionListener(this);
        classIdList = retrieveFunctions.getClassIDList();
        classIdCb = new JComboBox(classIdList);
        //int idx = classIdCb.getSelectedIndex();
        //selectedClassID = tempList[idx];
        JLabel title = new JLabel("Class Detail View");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        upper.add(title);
        upper.add(classIdCb);
        upper.add(viewingBtn);
        infoScreen.add(upper, BorderLayout.NORTH);
        //infoScreen.add(title, BorderLayout.NORTH);

        //infoScreen.add(classIdCb, BorderLayout.NORTH);
        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        infoScreen.add(backBtn, BorderLayout.SOUTH);

        JPanel outerPan = new JPanel(new FlowLayout(FlowLayout.LEADING));
        return infoScreen;
    }







    // VIEW ALL META DATA ABOUT A CLASS
    ArrayList<ArrayList<String>> classMetaData = new ArrayList<>();


    //String[] studentNameList;

    JPanel infoScreen, studentPanel;
    JLabel classHeading, classSubject, profName, gened;
    private JPanel viewClass(){
        infoScreen = new JPanel(new BorderLayout());

        JPanel upper = new JPanel();
        upper.setLayout(new BoxLayout(upper, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Class Detail View");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        upper.add(title);
        infoScreen.add(upper, BorderLayout.NORTH);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        infoScreen.add(backBtn, BorderLayout.SOUTH);

        JPanel outerPan = new JPanel(new FlowLayout(FlowLayout.LEADING));

        JPanel BoxPanel = new JPanel();
        BoxPanel.setLayout(new BoxLayout(BoxPanel, BoxLayout.Y_AXIS));

        JPanel BorderPanel = new JPanel(new BorderLayout());

        studentPanel = new JPanel();
        studentPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.Y_AXIS));

        JPanel classPanel = new JPanel(new FlowLayout());
         classHeading = new JLabel();
         classSubject = new JLabel();
        classPanel.add(classHeading);
        classPanel.add(classSubject);

        JPanel profPanel = new JPanel(new FlowLayout());
        JLabel profHeading = new JLabel("Professor: ");
        profName = new JLabel();
        profPanel.add(profHeading);
        profPanel.add(profName);

        JPanel genEdPanel = new JPanel(new FlowLayout());
        JLabel genEdHeading = new JLabel("GenEd Info: ");
        gened = new JLabel();
        genEdPanel.add(genEdHeading);
        genEdPanel.add(gened);

        BoxPanel.add(classPanel);
        BoxPanel.add(profPanel);
        BoxPanel.add(genEdPanel);

        JLabel studentTitle = new JLabel("Students: ");
        studentTitle.setFont(new Font("Arial", Font.BOLD, 16));

        BorderPanel.add(studentTitle, BorderLayout.NORTH);
        BorderPanel.add(studentPanel, BorderLayout.CENTER);
        BorderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        BoxPanel.add(BorderPanel);
        BoxPanel.setAlignmentX(0);
        outerPan.add(BoxPanel);
        infoScreen.add(outerPan, BorderLayout.CENTER);
        this.add(infoScreen);
        return infoScreen;
    }


    private void viewClassUpdate(){

        classHeading.setText(classMetaData.get(1).get(0));
        classSubject.setText(classMetaData.get(1).get(1));
        profName.setText(classMetaData.get(0).get(0));
        gened.setText(classMetaData.get(3).get(0));

        studentPanel.removeAll();
        for (String s : classMetaData.get(2)) {
            JLabel student = new JLabel(s);
            student.setBorder(new EmptyBorder(5, 5, 5, 5));
            studentPanel.add(student);
        }
        studentPanel.revalidate();
        studentPanel.repaint();
        return;
    }


    private JPanel getActivePanel(){
        if (mainMenu.isVisible()){return mainMenu;}
        else if (addStudent.isVisible()){return addStudent;}
        else if (modifyStudent.isVisible()){return modifyStudent;}
        else if (editStudent.isVisible()){return editStudent;}
        else if (addClass.isVisible()){return addClass;}
        else if (modifyClass.isVisible()){return modifyClass;}
        else if (editClass.isVisible()){return editClass;}
        else if (viewClass.isVisible()){return viewClass;}
        else if (selectingClass.isVisible()){return selectingClass;}
        else if (viewStudent.isVisible()){return viewStudent;}
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

            /* add new class into the repertoire  */


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
            isAdded.setVisible(false);
            failAdded.setVisible(false);
            isViewing = false;
            isSorted = false;
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
                isAdded.setVisible(true);
            }
            else{
                //TODO display student wasn't added
                failAdded.setVisible(true);
            }
            master.updateUI();

        }
        else if (actionEvent.getActionCommand().equals("Add Class")){


            // TODO call sql command to add the student to the database
        }
        else if (actionEvent.getActionCommand().equals("Remove Student")){
            // TODO call sql command to remove the student from the database


            if(queryFunctions.isAdvisor(StudentIdModifyText.getText())){
                if(queryFunctions.isStudentsAdvisor(facultyId, StudentIdModifyText.getText())){

                    Boolean studentDeleted = queryFunctions.deleteStudentUG(StudentIdModifyText.getText());
                    if(studentDeleted){
                        //TODO show that student was deleted
                    }
                    else{
                        //todo indicate student wasn't deleted
                    }
                    modifyStudent.setVisible(false);
                    editStudent.setVisible(true);
                    master.updateUI();
                }

        }
        }
        else if (actionEvent.getActionCommand().equals("Remove Class")){
            int idx = classIdCb.getSelectedIndex();
            selectedClassID = classIdList[idx];
            // TODO call sql command to remove the student from the database
        }
        else if (actionEvent.getActionCommand().equals("Edit Student")){
                System.out.println("here1");

            //if(queryFunctions.isAdvisor(facultyId)){
                    System.out.println("here2");

               // if(queryFunctions.isStudentsAdvisor(facultyId, StudentIdModifyText.getText())){
                    System.out.println("here3");

                    modifyStudent.setVisible(false);
                    editStudent.setVisible(true);
                    master.updateUI();
                //}
//}
            
        }

        else if(actionEvent.getActionCommand().equals("Submit Edit")){
            // TODO push update to database
        }

        else if (actionEvent.getActionCommand().equals("Edit Class")){
            classIdx = classIdCb.getSelectedIndex();
            selectedClassID = classIdList[classIdx];

            modifyClass.setVisible(false);
            editClass.setVisible(true);
            master.updateUI();
        }
        else if (actionEvent.getActionCommand().equals("View A Class")){
            mainMenu.setVisible(false);
            selectingClass.setVisible(true);
            master.updateUI();
        }
        else if (actionEvent.getActionCommand().equals("View")){
            isViewing = true;
            int idx = classIdCb.getSelectedIndex();
            selectedClassID = classIdList[idx];
            viewClassUpdate();
            selectingClass.setVisible(false);
            viewClass.setVisible(true);
            master.updateUI();
        }
        else if (actionEvent.getActionCommand().equals("View Students")){
            mainMenu.setVisible(false);
            viewStudent.setVisible(true);
            master.updateUI();
        }
        else if (actionEvent.getActionCommand().equals("Sort by GPA")){
            isSorted = true;
            studentList = retrieveFunctions.AllStudentsSorted();
            viewStudent.updateUI();
        }
    }
}
