import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInterface extends JFrame implements ActionListener {
    int studentId;
    RetrieveFunctions retFun = new RetrieveFunctions();
    JPanel master = new JPanel();
    JPanel mainPanel = mainMenu();
    JPanel addClass = addClass();
    JPanel viewAdvisor = viewAdvisor();
    JPanel viewClass = viewClass();
    public StudentInterface(String studentID){
        studentId = Integer.parseInt(studentID);

        setTitle("Student View");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        master.add(addClass);
        master.add(mainPanel);
        master.add(viewClass);
        master.add(viewAdvisor);

        addClass.setVisible(false);
        mainPanel.setVisible(true);
        viewClass.setVisible(false);
        viewAdvisor.setVisible(false);

        add(master);
        master.updateUI();
    }



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

        addClass.addActionListener(this);
        searchClass.addActionListener(this);
        viewAdvisor.addActionListener(this);

        superPanel.add(addClass);
        superPanel.add(searchClass);
        superPanel.add(viewAdvisor);

        mainPanel.add(superPanel, BorderLayout.CENTER);

        return mainPanel;
    }

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
        JLabel majorLabel = new JLabel("Department");       // subject field in the class table
        JLabel classNumLabel = new JLabel("Course Number");  // classNum field in the class table

        String majorsList[]={"CMPSC", "MATH", "ENGR", "HIST", "ART", "PHYS"};
        JComboBox majorsCb = new JComboBox(majorsList);

        JTextField classNumTxt = new JTextField();          // user enters the course number for CMPSC-465 they enter 465
        classNumTxt.setColumns(5);

        JButton submit = new JButton("Submit");
        submit.addActionListener(this);


        // add objects to containers
        majorPanel.add(majorLabel);
        majorPanel.add(majorsCb);

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
    private JPanel viewClass(){
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

        // create an array
        String[] classArray = RetrieveFunctions.getClassList(); // retrieve students classes from db and populate the array

        // create a for loop iterating through the array
        for (String s : classArray) {
            JLabel classLbl = new JLabel(s);
            panel.add(classLbl);
        }

        infoScreen.add(panel, BorderLayout.CENTER); // fill the screen with class data
        return infoScreen;
    }

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
        String advisorInfo = RetrieveFunctions.getAdvisor(studentId);
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
        else if (viewClass.isVisible()){return viewClass;}
        else if (viewAdvisor.isVisible()){return viewAdvisor;}
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
                addClass.setVisible(false);
                mainPanel.setVisible(true);
                master.updateUI();
        }
        else if (actionEvent.getActionCommand().equals("Search for a Class")){
                // this is where we go to new panel
                mainPanel.setVisible(false);
                viewClass.setVisible(true);
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
            mainPanel.setVisible(true);
            master.updateUI();
        }
    }
}