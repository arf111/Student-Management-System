package sd.ii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.swing.JOptionPane;

public class DatabaseTest {

    public static Connection c = null;
    //private static boolean hasData = false;

    
    public DatabaseTest() throws SQLException, ClassNotFoundException{
        if(c==null || c.isClosed())
            c = getConnection();
        createTable();
    }
    
    /*public ResultSet displayAll() throws SQLException, ClassNotFoundException {
        if (c.isClosed()) {
            getConnection();
        }

        Statement state = c.createStatement();
        ResultSet rs = state.executeQuery("SELECT firstName, lastName, Roll, Date-of-Birth, Email FROM student");
        return rs;
    }*/

    public final Connection getConnection() throws SQLException, ClassNotFoundException {                   //Main Connection To Database
        Class.forName("org.sqlite.JDBC");
        //if(c != null && c.isClosed())
        c = DriverManager.getConnection("jdbc:sqlite:SQLITE.db");
        //else c = DriverManager.getConnection("jdbc:sqlite:SQLITE.db");
        
        return c;
    }
    //Create the database tables
    private void createTable() throws SQLException, ClassNotFoundException {
        
        Statement state1 = c.createStatement();
        ResultSet rs1 = state1.executeQuery("SELECT name FROM sqlite_master WHERE type = 'table' AND name = 'student'");
        Statement state2 = c.createStatement();
        ResultSet rs2 = state2.executeQuery("SELECT name FROM sqlite_master WHERE type = 'table' AND name = 'result'");
        
        if (!rs1.next()) {
            System.out.println("Buliding the Student table.....");

            //Statement state2 = c.createStatement();
            state1.execute("CREATE TABLE student(ID Integer," + "Roll varchar(20)," + "firstName varchar(30),"
                    + "lastName varchar(30)," + "Sex varchar(10)," + "DateofBirth varchar(20)," + 
                    "Department varchar(10)," + "Year varchar(5)," + "Semester varchar(5)," + 
                    "Email varchar(50)," + "Password varchar(10)," + "Image BLOB," + "primary key (ID));");
        }
        
        if (!rs2.next()) {
            System.out.println("Buliding the Result table.....");

            //Statement state2 = c.createStatement();
            state2.execute("CREATE TABLE result(Roll varchar(20)," + "MATH2101 varchar(10)," + "CSE2103 varchar(10),"
                    + "CSE2105 varchar(10)," + "EEE2141 varchar(10)," + "HUM2109 varchar(20)," + 
                    "CSE2106 varchar(10)," + "CSE2104 varchar(10)," + "EEE2142 varchar(10)," + 
                    "CSE2100 varchar(10)," + "CGPA varchar(10)," + "primary key (Roll)," +
                    "foreign key (Roll) REFERENCES student (Roll) ON DELETE CASCADE);");
        }
    }

    public void addStudent(String fname, String lname, String roll, String sex, String dateofbirth, String dept, String year, String sem, String email) throws SQLException, ClassNotFoundException {
        if (c.isClosed()) {
           getConnection();
        }
       
        PreparedStatement pre = c.prepareStatement("INSERT INTO student values (?,?,?,?,?,?,?,?,?,?,?,?);");
        pre.setString(2, roll);
        pre.setString(3, fname);
        pre.setString(4, lname);
        pre.setString(5, sex);
        pre.setString(6, dateofbirth);
        pre.setString(7, dept);
        pre.setString(8, year);
        pre.setString(9, sem);
        pre.setString(10, email);
        String str = UUID.randomUUID().toString().replaceAll("-", "");
        pre.setString(11, str.substring(1, 10));
        pre.setString(12, null);
        pre.executeUpdate();
       // pre.execute();

        JOptionPane.showMessageDialog(null, "Inserted to Database: Student Table!");
    }
    
    public void addStudent(String roll, String math, String ds, String dld, String eee, String hum, String dslab, String dldlab, String eeelab, String sdlab, String cgpa) throws SQLException, ClassNotFoundException {
        if (c.isClosed()) {
           getConnection();
        }
       
        PreparedStatement pre = c.prepareStatement("INSERT INTO result values (?,?,?,?,?,?,?,?,?,?,?);");
        pre.setString(1, roll);
        pre.setString(2, math);
        pre.setString(3, ds);
        pre.setString(4, dld);
        pre.setString(5, eee);
        pre.setString(6, hum);
        pre.setString(7, dslab);
        pre.setString(8, dldlab);
        pre.setString(9, eeelab);
        pre.setString(10, sdlab);
        pre.setString(11, cgpa);
        pre.executeUpdate();
       // pre.execute();

        JOptionPane.showMessageDialog(null, "Inserted to Database: Result Table!");
    }

    public void deleteStudent(String roll) throws SQLException, ClassNotFoundException {
        if (c.isClosed()) {
            getConnection();
        }
        
        PreparedStatement pre1 = c.prepareStatement("DELETE FROM result WHERE Roll = ?");
        pre1.setString(1, roll);
        pre1.execute();
        PreparedStatement pre2 = c.prepareStatement("DELETE FROM student WHERE Roll = ?");
        pre2.setString(1, roll);
        /*pre.setString(1, fname);
        pre.setString(2, lname);
        pre.setString(3, roll);
        pre.setString(4, sex);
        pre.setString(5, dateofbirth);
        pre.setString(6, dept);
        pre.setString(7, year);
        pre.setString(8, sem);
        pre.setString(9, email);*/
        pre2.execute();
        
        JOptionPane.showMessageDialog(null, "Deleted from Database: Student Table!");
    }
    
    public void deleteResult(String roll) throws SQLException, ClassNotFoundException {
        if (c.isClosed()) {
            getConnection();
        }
        
        PreparedStatement pre = c.prepareStatement("DELETE FROM result WHERE Roll = ?");
        pre.setString(1, roll);
        pre.execute();
        
        JOptionPane.showMessageDialog(null, "Deleted from Database: Result Table!");
    }
    
    public void updateStudent(String id, String fname, String lname, String roll, String sex, String dateofbirth, String dept, String year, String sem, String email) throws SQLException, ClassNotFoundException
    {
        if (c.isClosed()) {
            getConnection();
        }
        
        PreparedStatement pre = c.prepareStatement("update student SET firstName = '" + fname + "', lastName = '" + lname + "', Roll = '" + roll + "', Sex = '" + sex +"', DateofBirth = '" + dateofbirth + "', Department = '"+ dept +"', Year = '"+ year +"', Semester = '" + sem +"', Email = '" + email + "' WHERE ID = '" + id +"'");
        
        pre.execute();
        
        JOptionPane.showMessageDialog(null, "Updated");
    }
    public void updateStudentResult(String roll,String math, String ds, String dld, String eee, String hum, String dslab, String dldlab, String eeelab, String sdlab, String cgpa) throws SQLException, ClassNotFoundException
    {
        if (c.isClosed()) {
            getConnection();
        }
        
        PreparedStatement pre = c.prepareStatement("update result SET MATH2101 = '" + math + "', CSE2103 = '" + ds + "', CSE2105 = '" + dld + "', EEE2141 = '" + eee +"', HUM2109 = '" + hum + "', CSE2106 = '"+ dldlab +"', CSE2104 = '"+ dslab +"', EEE2142 = '" + eeelab +"', CSE2100 = '" + sdlab +"', CGPA = '"+ cgpa + "' WHERE Roll = '" + roll + "'");
        
        pre.execute();
        
        JOptionPane.showMessageDialog(null, "Updated");
    }
}