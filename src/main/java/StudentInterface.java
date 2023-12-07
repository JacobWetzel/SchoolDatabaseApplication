import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentInterface extends JFrame implements ActionListener {
    String studentId;

    boolean isViewing;
    JPanel master;// = new JPanel();
    JPanel mainPanel;// = mainMenu();
    JPanel addClass;// = addClass();
    JPanel viewAdvisor;
    JPanel viewClasses;// = viewClass();

    JPanel infoScreen, studentPanel;
    JLabel classHeading, classSubject, profName, gened;

    RetrieveFunctions retrieveFunctions;

    JComboBox classIdCb;

    JPanel SelectingClass;

    String selectedClassID;

    QueryFunctions queryFunctions;

    String[] classIdList;

    JPanel ViewClass;

    public StudentInterface(String studentID){
        retrieveFunctions = new RetrieveFunctions();
        queryFunctions = new QueryFunctions();
        studentId = studentID;
        setTitle("Student View");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        master = new JPanel();
        mainPanel = mainMenu();
        addClass = addClass();
        viewAdvisor = viewAdvisor();
        viewClasses = viewClasses();
        ViewClass = ViewClass();
        SelectingClass = SelectingClass();

        master.add(addClass);
        master.add(SelectingClass);
        master.add(mainPanel);
        master.add(viewClasses);
        master.add(viewAdvisor);
        master.add(ViewClass);

        addClass.setVisible(false);
        mainPanel.setVisible(true);
        viewClasses.setVisible(false);
        viewAdvisor.setVisible(false);
        SelectingClass.setVisible(false);
        ViewClass.setVisible(false);

        add(master);
        master.updateUI();
    }



    //LANDING PAGE
    private JPanel mainMenu(){
        GridLayout layout = new GridLayout(3,1);
        layout.setHgap(50);
        layout.setVgap(20);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(15,20,15,20));
        JPanel superPanel = new JPanel();
        superPanel.setLayout(layout);

        JButton addClass = new JButton("Add Class");
        JButton searchClass = new JButton("Search for a Class");
        JButton viewAdvisor = new JButton("View Advisor");
        JButton viewClassBtn = new JButton("View A Class");

        addClass.addActionListener(this);
        searchClass.addActionListener(this);
        viewClassBtn.addActionListener(this);
        viewAdvisor.addActionListener(this);

        superPanel.add(addClass);
        superPanel.add(searchClass);
        superPanel.add(viewClassBtn);
        superPanel.add(viewAdvisor);

        mainPanel.add(superPanel, BorderLayout.CENTER);

        return mainPanel;
    }



    // VIEW ALL META DATA ABOUT A CLASS
    ArrayList<ArrayList<String>> classMetaData = new ArrayList<>();


    //String[] studentNameList;

    private JPanel ViewClass(){
        infoScreen = new JPanel(new BorderLayout());
        infoScreen.setSize(600,800);
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


    private void ViewClassUpdate(){

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






    JTextField classNumTxt;
    //ADD CLASS TO CART
    private JPanel addClass(){

        // create needed Panel Containers
        JPanel infoScreen = new JPanel();
        infoScreen.setLayout(new BorderLayout());

        JLabel title = new JLabel("Add a Class");           // create heading for current panel
        infoScreen.add(title, BorderLayout.NORTH);              // add it to top of page

        JButton backBtn = new JButton("Back");              // create a back button
        backBtn.addActionListener(this);
        infoScreen.add(backBtn, BorderLayout.SOUTH);            // add it to the bottom of the page


        JPanel panel = new JPanel();                            // this will house everything else
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));    // we want it to be vertically aligned

        JPanel majorPanel = new JPanel();           // contains dept selection info
        majorPanel.setLayout(new FlowLayout());     // we want it to be inline horizontal

        JPanel classNumPanel = new JPanel();        // contains class num info
        classNumPanel.setLayout(new FlowLayout());  // we want it to be inline horizontal

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new BoxLayout(submitPanel, BoxLayout.Y_AXIS));
        submitPanel.setBorder(new EmptyBorder(3,3,3,3));

        // Create needed displaying objects
        //JLabel majorLabel = new JLabel("Department");       // subject field in the class table
        JLabel classNumLabel = new JLabel("Course Number");  // classNum field in the class table

        //String majorsList[]={"CMPSC", "MATH", "ENGR", "HIST", "ART", "PHYS"};
        //JComboBox majorsCb = new JComboBox(majorsList);

        classNumTxt = new JTextField();          // user enters the course number for CMPSC-465 they enter 465
        classNumTxt.setColumns(5);

        JButton submit = new JButton("Submit");
        submit.addActionListener(this);


        // add objects to containers
        //majorPanel.add(majorLabel);
        //majorPanel.add(majorsCb);

        classNumPanel.add(classNumLabel);
        classNumPanel.add(classNumTxt);

        submitPanel.add(submit);

        panel.add(majorPanel);
        panel.add(classNumPanel);
        panel.add(submitPanel);
        panel.setBorder(new EmptyBorder(10,10,10,10));

        infoScreen.add(panel);

        return infoScreen;

    }


    private JPanel SelectingClass(){
        JPanel infoScreen = new JPanel(new BorderLayout());

        JPanel upper = new JPanel();
        upper.setLayout(new BoxLayout(upper, BoxLayout.Y_AXIS));

        JButton viewingBtn = new JButton("View");
        viewingBtn.addActionListener(this);
        classIdList = retrieveFunctions.getClassIDList();
        classIdCb = new JComboBox(classIdList);
        JLabel title = new JLabel("Class Detail View");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        upper.add(title);
        upper.add(classIdCb);
        upper.add(viewingBtn);
        infoScreen.add(upper, BorderLayout.NORTH);
        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        infoScreen.add(backBtn, BorderLayout.SOUTH);

        JPanel outerPan = new JPanel(new FlowLayout(FlowLayout.LEADING));

        return infoScreen;
    }




    //VIEW ALL CLASSES AVAILABLE
    private JPanel viewClasses(){

        JPanel infoScreen = new JPanel();
        infoScreen.setLayout(new BorderLayout());


        // create the title of the panel

        JLabel title = new JLabel("All Classes");
        infoScreen.add(title, BorderLayout.NORTH);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        infoScreen.add(backBtn, BorderLayout.SOUTH);


        // JPanel to hold the information
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        String[] classArray = retrieveFunctions.getClassList();
        JTextArea classInfoTextArea = new JTextArea(50, 40);
        classInfoTextArea.setText("");
        classInfoTextArea.setLineWrap(true);
        classInfoTextArea.setEditable(false);
        for(int i = 0; i < classArray.length; i+=10){
            classInfoTextArea.append(classArray[i]);
            classInfoTextArea.append("\n");
            classInfoTextArea.append("\n");
        }

        JScrollPane scrollPane = new JScrollPane(classInfoTextArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPane);


        infoScreen.add(panel, BorderLayout.CENTER); // fill the screen with class data
        return infoScreen;
    }


    //VIEW ADVISOR
    private JPanel viewAdvisor(){
        JPanel infoScreen = new JPanel();
        infoScreen.setLayout(new BorderLayout());

        // add title
        JLabel title = new JLabel("Your Advisor: ");
        infoScreen.add(title, BorderLayout.NORTH);

        // add back button
        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        infoScreen.add(backBtn, BorderLayout.SOUTH);

        // retrieve the advisor from table as a usable string
        String advisorInfo = retrieveFunctions.getAdvisor(studentId);
        // make a jlabel with the advisors info
        JLabel advisorName = new JLabel(advisorInfo);
        infoScreen.add(advisorName,BorderLayout.CENTER);

        return infoScreen;
    }

    private static void addButtonWithPadding(JPanel panel, String btnText){
        JButton button = new JButton(btnText);

        button.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        panel.add(button);
    }

    private JPanel getActivePanel(){
        if (mainPanel.isVisible()){return mainPanel;}
        else if (addClass.isVisible()){return addClass;}
        else if (viewClasses.isVisible()){return viewClasses;}
        else if (viewAdvisor.isVisible()){return viewAdvisor;}
        else if (SelectingClass.isVisible()){return SelectingClass;}
        else if (infoScreen.isVisible()){return infoScreen;}
        else{ return mainPanel;}
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Add Class")){
                // this is where we go to new panel
                mainPanel.setVisible(false);
                addClass.setVisible(true);
                master.updateUI();

        }
        else if (actionEvent.getActionCommand().equals("Submit")){
                // this is where we call the sql to see if they can add it
                queryFunctions.atToCart(classNumTxt.getText(), studentId);
                addClass.setVisible(false);
                mainPanel.setVisible(true);
                master.updateUI();
        }
        else if (actionEvent.getActionCommand().equals("Search for a Class")){
                // this is where we go to new panel
                mainPanel.setVisible(false);
                viewClasses.setVisible(true);
                master.updateUI();
        }
        else if (actionEvent.getActionCommand().equals("View Advisor")){
                // this is where we go to new panel
                mainPanel.setVisible(false);
                viewAdvisor.setVisible(true);
                master.updateUI();
        }
        else if (actionEvent.getActionCommand().equals("Back")){
            JPanel curPanel = getActivePanel();
            curPanel.setVisible(false);
            /*if(curPanel != infoScreen){
                mainPanel.setVisible(true);
            }
            else{
                SelectingClass.setVisible(true);
            }*/
            mainPanel.setVisible(true);
            //mainPanel.setVisible(true);
            master.updateUI();
        }
        else if (actionEvent.getActionCommand().equals("View")){
            isViewing = true;
            int idx = classIdCb.getSelectedIndex();
            String temp = classIdList[idx];
            selectedClassID = temp;
            classMetaData = queryFunctions.viewClassMetadata(selectedClassID);
            ViewClassUpdate();
            System.out.println(selectedClassID + "end of button action");
            SelectingClass.setVisible(false);
            ViewClass.setVisible(true);
            master.updateUI();

        }
        else if (actionEvent.getActionCommand().equals("View A Class")){
            mainPanel.setVisible(false);
            SelectingClass.setVisible(true);
            master.updateUI();
        }
    }
}