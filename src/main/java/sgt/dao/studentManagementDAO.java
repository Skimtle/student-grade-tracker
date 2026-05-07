/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.dao;
import java.sql.Connection;
import sgt.session.SQLconnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sgt.model.Student;

/**
 *
 * @author Skimtle
 */
public class studentManagementDAO {
    public boolean addStudent(Student s){
        String sql = "INSERT INTO tbl_students (student_number, first_name, last_name, year_level, program_id, faculty_id, admin_id) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = SQLconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)){
            pst.setString(1, s.getStudentNum());
            pst.setString(2, s.getFirstName());
            pst.setString(3, s.getlastName());
            pst.setInt(4, s.getYearLevel());
            pst.setInt(5, s.getProgramId());
            
            if (s.getFacultyId() != null) {
                pst.setInt(6, s.getFacultyId());
            } else {
                pst.setNull(6, java.sql.Types.INTEGER);
            }
            
            if (s.getAdminId() != null) {
                pst.setInt(7, s.getAdminId());
            } else {
                pst.setNull(7, java.sql.Types.INTEGER);
            }
            
            int result = pst.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
            
}
