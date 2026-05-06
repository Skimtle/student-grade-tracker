/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.dao;
import sgt.session.SQLconnection;
import java.sql.*;
import sgt.model.admin;
import sgt.model.users;
import sgt.model.faculty;

/**
 *
 * @author Skimtle
 */
public class loginUIDAO {
    public users login(String username, String password, String tableName){
        try{
            Connection con = SQLconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from " +tableName + " where username=? and password=?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                String fullName = rs.getString("full_name");
                
                if(tableName.equals("tbl_faculty")){
                    int id = rs.getInt("faculty_id");
                    return new faculty(id, username, password, fullName);
                } else {
                    int id = rs.getInt("admin_id");
                    return new admin(id, username, password, fullName);
                }
            }
            }catch(Exception ex){
                System.out.println(ex);
            }
            return null;
    }
}