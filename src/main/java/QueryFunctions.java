/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QueryFunctions {


    public static void addStudentUG(int studentID, String fname, String lname, String bday, float gpa, int year, String major, String researchArea, String Type, int ProfessorID,  int isGrad){
        try (Connection connection = DatabaseConnection.getConnection()){
            String sql = "INSERT INTO Student(studentID, fName, lName, bday, gpa);";     // add student to Student table
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
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

}
*/