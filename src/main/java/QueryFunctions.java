import java.awt.*;
import java.sql.*;

public class QueryFunctions {

    private static String url;

    public QueryFunctions(){
        url = "jdbc:sqlite:./src/main/java/Databases/SchoolDB.SQLite";
    }

    public static boolean studentCredentialsValidation(String username, String password){
        System.out.println("In queryfn");
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connection made");
                String findStudent = "SELECT * FROM Students WHERE StudentID = ? AND Password = ?";
                try (PreparedStatement getStudent = conn.prepareStatement(findStudent)) {

                    getStudent.setString(1, username);
                    getStudent.setString(2, password);
                    ResultSet students = getStudent.executeQuery();

                    if(students.next()){
                        return true;
                    }
                    else{
                        return false;
                    }

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    public static boolean facultyCredentialsValidation(String username, String password){

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connection made");
                String findStudent = "SELECT * FROM Faculty WHERE FacultyID = ? AND Password = ?";
                try (PreparedStatement getFaculty = conn.prepareStatement(findStudent)) {

                    getFaculty.setString(1, username);
                    getFaculty.setString(2, password);
                    ResultSet faculty = getFaculty.executeQuery();

                    if(faculty.next()){
                        return true;
                    }
                    else{
                        return false;
                    }

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Boolean addStudentToStudentAndUG(String studentId, String fName, String lName, String dob, String password, String year, String major, Double gpa, String advisorFName, String advisorLName) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url);

            //beginning transaction
            conn.setAutoCommit(false);


            String sqlGetAdvisorId = "SELECT A.AdvisorID FROM Faculty F INNER JOIN Advisors A ON F.FacultyID = A.AdvisorID WHERE F.FName = ? AND F.LName = ?";
            pstmt = conn.prepareStatement(sqlGetAdvisorId);
            pstmt.setString(1, advisorFName);
            pstmt.setString(2, advisorLName);
            rs = pstmt.executeQuery();

            String advisorId = null;
            if (rs.next()) {
                advisorId = rs.getString("AdvisorID");
            }

            if (advisorId != null) {
                // Insert into Students
                String sqlInsertStudent = "INSERT INTO Students (StudentID, FName, LName, DOB, Password) VALUES (?, ?, ?, ?, ?)";
                pstmt = conn.prepareStatement(sqlInsertStudent);
                pstmt.setString(1, studentId);
                pstmt.setString(2, fName);
                pstmt.setString(3, lName);
                pstmt.setString(4, dob);
                pstmt.setString(5, password);
                pstmt.executeUpdate();

                // Insert into Undergraduates
                String sqlInsertUndergraduate = "INSERT INTO Undergraduates (StudentID, Year, Major, GPA, Advisor) VALUES (?, ?, ?, ?, ?)";
                pstmt = conn.prepareStatement(sqlInsertUndergraduate);
                pstmt.setString(1, studentId);
                pstmt.setString(2, year);
                pstmt.setString(3, major);
                pstmt.setDouble(4, gpa);
                pstmt.setString(5, advisorId);
                pstmt.executeUpdate();
            }

            //finish transaction
            conn.commit();

            return true;

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    return false;
                }
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




/*
    public static void addStudentUG(int studentID, String fname, String lname, String bday, float gpa, int year, String major, String researchArea, String Type, int ProfessorID,  int isGrad){
        try (Connection conn = DriverManager.getConnection(url)){
            String sql = "INSERT INTO Student(studentID, fName, lName, bday, gpa);";     // add student to Student table
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                preparedStatement.setInt(1, studentID);
                preparedStatement.setString(2, fname);
                preparedStatement.setString(3, lname);          // not entirely sure how the prepared Statement works
                preparedStatement.setString(4, bday);
                preparedStatement.setFloat(5, gpa);
                preparedStatement.executeUpdate();
            }

            if (isGrad == 0){   // the student is an undergrad
                String sql1 = "INSERT INTO UnderGraduate(studentID, year, major);";     // add student to undergrad table
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql1)){
                    preparedStatement.setInt(1, studentID);
                    preparedStatement.setInt(2, year);         // not entirely sure how the prepared Statement works
                    preparedStatement.setString(3,major);
                    preparedStatement.executeUpdate();
                }
            }

            else if (isGrad == 1){  // the student is a graduate
                String sql2 = "INSERT INTO GradStudent(@studentID,@researchArea,@Type,@ProfessorID";    // add student to graduate table
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql2)){
                    preparedStatement.setInt(1,studentID);
                    preparedStatement.setString(2,researchArea);
                    preparedStatement.setString(3,Type);            // not entirely sure how the prepared Statement works
                    preparedStatement.setInt(4,ProfessorID);
                    preparedStatement.executeUpdate();
                }
            }


        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateRequiredClass(String RequiredClass, String oldClassID, String newClassID, String MajorID){ // used to update the required class table
        try (Connection connection = DatabaseConnection.getConnection()){
            String sql = "UPDATE RequiredClass SET ClassID = newClassID, MajorID = newMajorID WHERE ClassID = oldClassID";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, RequiredClass);
                preparedStatement.setString(2, newClassID);
                preparedStatement.setString(3, MajorID);
                preparedStatement.setString(4, oldClassID);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void addRequiredClass(String ClassID, String MajorID){        // adds a required class to the RequiredClass table
        try (Connection connection = DatabaseConnection.getConnection()){
            String sql = "INSERT INTO RequiredClass(ClassID, MajorID)";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, ClassID);
                preparedStatement.setString(2,MajorID);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public static void deleteRequiredClass(String ClassID){                                 // deletes a requiredClass from the RequiredClass table
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM RequireClass WHERE RequiredClass.ClassID = ClassID";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, ClassID);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addMajor(String MajorID, String MajorName, String College, float minGPA){    // adds a major to the Major table
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO Major(MajorID, MajorName, College, minGPA)";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1,MajorID);
                preparedStatement.setString(2,MajorName);
                preparedStatement.setString(3, College);
                preparedStatement.setFloat(4,minGPA);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateMajor(String oldClassID, String newClassID, String newSubject, int newClassNum, float newCredits, String newAttribute){
        try(Connection connection = DatabaseConnection.getConnection()){
            String sql = "UPDATE Class SET ClassID = newClassID, Subject = newSubject, ClassNum = newClassNum, Credits = newCredits, Attribute = newAttribute WHERE ClassID = oldClassID";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, newClassID);
                preparedStatement.setString(2,newSubject);
                preparedStatement.setInt(3, newClassNum);
                preparedStatement.setFloat(4,newCredits);
                preparedStatement.setString(5, newAttribute);
                preparedStatement.setString(6, oldClassID);
                preparedStatement.executeUpdate();
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void deleteMajor(String ClassID){                         // removes a major from the majors table
        try(Connection connection = DatabaseConnection.getConnected()){
            String sql = "DELETE FROM Class WHERE Class.ClassID = ClassID";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1,sql);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    // ADD CLASSES STUDENT HAS TAKEN


    // MODIFY CLASS DATA ABOUT A STUDENT

    // GIVE CLASS REQUIREMENTS FOR GRADUATION

    // ROLL BACK QUERY

    // CHECK TO SEE IF A STUDENT IS ELIGIBLE FOR A CLASS
*/
}
