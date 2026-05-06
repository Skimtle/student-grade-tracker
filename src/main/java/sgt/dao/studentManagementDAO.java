/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.dao;
import sgt.model.Program;
import sgt.session.SQLconnection;

/**
 *
 * @author Skimtle
 */
public class studentManagementDAO {
    public Program manage(int id, String program_code, String program_name){
        String sql = "INSERT INTO tbl_students (student_number, first_name, last_name, year_level, program_id, faculty_id) " + "VALUES (?, ?, ?, ?, ?, ?)";
        try{ Connection con = SQLconnection.getConnection();
            
        
        } catch(Exeception ex){
            System.out.println(ex);
        }
    }
            
}
