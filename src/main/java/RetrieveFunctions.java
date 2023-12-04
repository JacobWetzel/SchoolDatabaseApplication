
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class RetrieveFunctions {
    private static String url;
    public RetrieveFunctions(){
        System.out.println("Called");
        url = "jdbc:sqlite:./src/main/java/Databases/SchoolDB.SQLite";
    }

    public static String getAdvisor(String StudentID) {
        System.out.println("Getting here " + url);
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                String sql = "SELECT F.FName, F.LName FROM Faculty F " +
                        "INNER JOIN Advisors A ON F.FacultyID = A.AdvisorID " +
                        "INNER JOIN Undergraduates U ON A.AdvisorID = U.Advisor WHERE U.StudentID = ?"; // this is the retrieve statement
                try (PreparedStatement statement = conn.prepareStatement(sql)) { // we want the function to return value in faculty table
                    statement.setString(1, StudentID);
                    ResultSet rs = statement.executeQuery();
                    String full = "";
                    while (rs.next()) {
                        String fname = rs.getString(1);
                        String lname = rs.getString(2);
                        full = "Advisor Name: " + fname + " " + lname;

                    }
                    return full;

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    return "Failed to retrieve data";
                }
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return "Failed to connect";
    }
    public static String[] getClassList(){

        List<String> classList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url)){

            String sql = "SELECT * FROM Classes";
            try (PreparedStatement statement = conn.prepareStatement(sql)){
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {

                    String courseID = rs.getString(1);
                    String subject = rs.getString(3);   // retrieves the subject
                    Integer Num = rs.getInt(4);             // gets the class number
                    Integer Credits = rs.getInt(5);

                    String classDetails = "CourseID: " + courseID + "\n Subject: " + subject + "\n Course Number: " + Num + "\n Credits: " + Integer.toString(Credits);
                    classList.add(classDetails);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return new String[]{"Failed to retrieve Data"};
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new String[]{"Failed to connect to Database"};
        }

        return classList.toArray(new String[0]);
    }

    public static String[] getClassIDList(){

        List<String> classList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url)){

            String sql = "SELECT * FROM Classes";
            try (PreparedStatement statement = conn.prepareStatement(sql)){
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    classList.add(rs.getString(1));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return new String[]{"Failed to retrieve Data"};
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new String[]{"Failed to connect to Database"};
        }
        return classList.toArray(new String[0]);
    }

    // RETRIEVE STUDENT INFORMATION
    public static void retrieveStudentInfo(){}

    // RETRIEVE A LIST OF STUDENTS IN A MAJOR SORTED BY GPA
    public static void StudentsInMajorSortedGPA(){}

    // RETRIEVE A LIST OF STUDENTS IN A MAJOR SORTED BY LAST NAME
    public static void studentsInMajorSortedLname(){}
}
