/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.grade.tracker.student_grade_tracker;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Andrew
 */
public class SQLconnection {
    static Connection con;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_tracker_db", "root","");
        }catch(Exception ex){
            System.out.println("" +ex);
        }
        return con;
    }
}
