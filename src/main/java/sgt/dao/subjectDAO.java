/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sgt.model.Subject;
import sgt.session.SQLconnection;
import sgt.session.UserSession;

/**
 *
 * @author Skimtle
 */
public class subjectDAO {
        public boolean addSubjects(Subject s) {
            int currentUserId = UserSession.getUserId();
        String sql = "INSERT INTO tbl_subjects (subject_code, subject_name, room_number, program_id) " +
                 "VALUES (?, ?, ?, (SELECT program_id FROM tbl_programs WHERE program_code = ? OR program_name = ? LIMIT 1))";
        try (Connection con = SQLconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, s.getSubjectCode());
            pst.setString(2, s.getSubjectName());
            pst.setString(3, s.getRoomNumber());
            pst.setString(4, s.getProgram()); // This is the string from your ComboBox
            pst.setString(5, s.getProgram()); // Backup check for name
            pst.setInt(6, currentUserId);
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean updateSubjects(Subject s) {
        String sql = "UPDATE tbl_subjects SET " +
                 "subject_code = ?, " +
                 "subject_name = ?, " +
                 "room_number = ?, " +
                 "program_id = (SELECT program_id FROM tbl_programs WHERE program_code = ? OR program_name = ? LIMIT 1) " +
                 "WHERE subject_id = ?";
        try (Connection con = SQLconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, s.getSubjectCode());
            pst.setString(2, s.getSubjectName());
            pst.setString(3, s.getRoomNumber());
            pst.setString(4, s.getProgram()); // This is the string from your ComboBox
            pst.setString(5, s.getProgram()); // Backup check for name
            pst.setInt(6, s.getId());
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteSubjects(int id) {
        String sql = "DELETE FROM tbl_subjects WHERE subject_id = ?";
        try (Connection con = SQLconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
