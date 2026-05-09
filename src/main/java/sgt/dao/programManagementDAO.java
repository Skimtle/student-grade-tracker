/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.dao;
import java.sql.*;
import sgt.session.SQLconnection;
import sgt.model.Program;

/**
 *
 * @author Skimtle
 */
public class programManagementDAO {
    public boolean addProgram(Program p) {
        String sql = "INSERT INTO tbl_programs (program_code, program_name) VALUES (?, ?)";
        try (Connection con = SQLconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, p.getCode());
            pst.setString(2, p.getName());
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean updateProgram(Program p) {
        String sql = "UPDATE tbl_programs SET program_code = ?, program_name = ? WHERE program_id = ?";
        try (Connection con = SQLconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, p.getCode());
            pst.setString(2, p.getName());
            pst.setInt(3, p.getId());
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean deleteProgram(int id) {
        String sql = "DELETE FROM tbl_programs WHERE program_id = ?";
        try (Connection con = SQLconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            // Logic Check: This will fail if students are currently enrolled in this program (Foreign Key Constraint)
            ex.printStackTrace();
            return false;
        }
    }
    
}
