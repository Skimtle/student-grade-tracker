/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.dao;
import java.sql.Connection;
import sgt.session.SQLconnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    public boolean deleteStudent(String studentID) {
        String sql = "DELETE FROM tbl_students WHERE student_number = ?";
        try (Connection conn = SQLconnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentID);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateStudent(sgt.model.Student s) {
        String sql = "UPDATE tbl_students SET first_name=?, last_name=?, year_level=?, " + "program_id=?, faculty_id=?, admin_id=? WHERE student_number=?";
        try (Connection conn = SQLconnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, s.getFirstName());
            pstmt.setString(2, s.getlastName());
            pstmt.setInt(3, s.getYearLevel());
            pstmt.setInt(4, s.getProgramId());
            
            if (s.getFacultyId() != null) {
                pstmt.setInt(5, s.getFacultyId());
            } else {
                pstmt.setNull(5, java.sql.Types.INTEGER);
            }
            
            if (s.getAdminId() != null) {
                pstmt.setInt(6, s.getAdminId());
            } else {
                pstmt.setNull(6, java.sql.Types.INTEGER);
            }
            
            pstmt.setString(7, s.getStudentNum());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public int getTotalStudentCount() {
        String role = sgt.session.UserSession.getCurrentRole();
        int userId = sgt.session.UserSession.getUserId();
    
    
        String sql = "SELECT COUNT(*) AS total FROM tbl_students";
    
    
        if ("faculty".equals(role)) {
            sql = "SELECT COUNT(DISTINCT student_id) AS total FROM tbl_grades WHERE faculty_id = ?";
        }

        try (Connection con = SQLconnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql)) {
        
            if ("faculty".equals(role)) {
                pst.setInt(1, userId);
            }
        
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException ex) {
        ex.printStackTrace();
        }
        return 0;
    }
            
}
