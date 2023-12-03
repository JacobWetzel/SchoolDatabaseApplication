
import java.sql.*;

public class RetrieveFunctions {
    private static String url;
    public RetrieveFunctions(){url = "jdbc:sqlite:./src/main/jav/Databases/SchoolDB.SQLite";}

    public static String getAdvisor(int StudentID){
        try (Connection conn = DriverManager.getConnection(url)){
            String sql  = "Select * FROM Faculty WHERE "; // this is the retrieve statement
            try (PreparedStatement statement = conn.prepareStatement(sql)){ // we want the function to return value in faculty table
                ResultSet rs = statement.executeQuery(sql);
                String full = "";
                while (rs.next()){
                    String fname = rs.getString(2);
                    String lname = rs.getString(3);
                    full = "Advisor Name: " + fname + " " + lname;

                }
                return full;
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return "Failed to retrieve data";
        }
    }
    public static String[] getClassList(){
        try (Connection conn = DriverManager.getConnection(url)){

            String sql = "SELECT * FROM Class";
            try (PreparedStatement statement = conn.prepareStatement(sql)){
                ResultSet rs = statement.executeQuery(sql);

                rs.last();                  // move to the last row in table
                int counter = rs.getRow();  // assign the counter value
                rs.first();                 // move back to the first row
                String[] ClassesArray = new String[counter];

                counter = 0;

                while (rs.next()){
                    String subject = rs.getString(2);   // retrieves the subject
                    int Num = rs.getInt(3);     // gets the class number
                    String classNum = Integer.toString(Num);
                    int Credits = rs.getInt(4);
                    String credits = Integer.toString(Credits);

                    String classDetails = "Subject: " + subject + "\nCourse Number: " + classNum + "\n Credits: " + credits;
                    ClassesArray[counter] = classDetails;
                    counter ++;
                }
                return ClassesArray;
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
            String[] arr = new String[1];
            arr[0] = "Failed to retrieve Data";
            return arr;
        }
    }
    // RETRIEVE STUDENT INFORMATION
    public static void retrieveStudentInfo(){}

    // RETRIEVE A LIST OF STUDENTS IN A MAJOR SORTED BY GPA
    public static void StudentsInMajorSortedGPA(){}

    // RETRIEVE A LIST OF STUDENTS IN A MAJOR SORTED BY LAST NAME
    public static void studentsInMajorSortedLname(){}
}
