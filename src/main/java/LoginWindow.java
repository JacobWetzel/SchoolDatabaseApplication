import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginWindow extends JFrame implements ActionListener{

    public LoginWindow(String frameTitle) {
        super(frameTitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public void createDB(){
        String url = "jdbc:sqlite:./src/main/java/Databases/Faculty.SQLite";
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connection made");
                try (Statement stmt = conn.createStatement()) {
                    ResultSet testSet = stmt.executeQuery("SELECT * FROM Faculty");

                    while(testSet.next() == true){
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

    }

}
