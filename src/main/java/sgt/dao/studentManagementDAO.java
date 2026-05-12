package sgt.dao;

import java.sql.Connection;
import sgt.session.SQLconnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sgt.model.Student;

/**
 * Merged Student Management DAO
 * Handles additional fields (Age, DOB, Address) and Role-based counts.
 */
public class studentManagementDAO {

    public boolean addStudent(Student s) {
        // SQL includes all 10 fields from the updated schema
        String sql = "INSERT INTO tbl_students " +
                     "(student_number, first_name, last_name, year_level, program_id, " +
                     "age, date_of_birth, address, faculty_id, admin_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = SQLconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, s.getStudentNum());
            pst.setString(2, s.getFirstName());
            pst.setString(3, s.getlastName());
            pst.setInt(4, s.getYearLevel());
            pst.setInt(5, s.getProgramId());
            pst.setString(6, s.getAge());
            pst.setString(7, s.getBirthday());
            pst.setString(8, s.getAddress());

            // Handle Nullable IDs (Faculty/Admin)
            if (s.getFacultyId() != null) pst.setInt(9, s.getFacultyId());
            else pst.setNull(9, java.sql.Types.INTEGER);

            if (s.getAdminId() != null) pst.setInt(10, s.getAdminId());
            else pst.setNull(10, java.sql.Types.INTEGER);

            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updateStudent(Student s) {
        String sql = "UPDATE tbl_students SET first_name=?, last_name=?, year_level=?, " +
                     "program_id=?, age=?, date_of_birth=?, address=?, " +
                     "faculty_id=?, admin_id=? WHERE student_number=?";
        
        try (Connection con = SQLconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, s.getFirstName());
            pst.setString(2, s.getlastName());
            pst.setInt(3, s.getYearLevel());
            pst.setInt(4, s.getProgramId());
            pst.setString(5, s.getAge());
            pst.setString(6, s.getBirthday());
            pst.setString(7, s.getAddress());

            if (s.getFacultyId() != null) pst.setInt(8, s.getFacultyId());
            else pst.setNull(8, java.sql.Types.INTEGER);

            if (s.getAdminId() != null) pst.setInt(9, s.getAdminId());
            else pst.setNull(9, java.sql.Types.INTEGER);

            pst.setString(10, s.getStudentNum());
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(String studentID) {
        String sql = "DELETE FROM tbl_students WHERE student_number = ?";
        try (Connection con = SQLconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, studentID);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getTotalStudentCount() {
        String role = sgt.session.UserSession.getCurrentRole();
        int userId = sgt.session.UserSession.getUserId();

        String sql = "SELECT COUNT(*) AS total FROM tbl_students";
        
        // If the user is a faculty member, only count students in their records
        if ("faculty".equals(role)) {
            sql = "SELECT COUNT(DISTINCT student_id) AS total FROM tbl_grades WHERE faculty_id = ?";
        }

        try (Connection con = SQLconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            if ("faculty".equals(role)) {
                pst.setInt(1, userId);
            }
            
            ResultSet rs = pst.executeQuery();
            if (rs.next()) return rs.getInt("total");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}