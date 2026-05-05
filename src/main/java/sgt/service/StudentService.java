/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sgt.util.DatabaseHelper;
import java.util.Random;

/**
 *
 * @author Skimtle
 */
public class StudentService {

    public static String generateNextID(){
        int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        Random rand = new Random();
        String studentNumber;
        try (Connection conn = DatabaseHelper.getConnection()) {
            do{
                int randomPart = 1000 + rand.nextInt(9000);
                studentNumber = year + "-" + randomPart;
                
                PreparedStatement pst = conn.prepareStatement(
                        "SELECT COUNT(*) FROM tbl_students WHERE student_number = ?"
                );
                pst.setString(1, studentNumber);
                ResultSet rs = pst.executeQuery();
                if(rs.next()&& rs.getInt(1) == 0) break;
            } while(true);
        } catch(SQLException e){
            throw new RuntimeException(e);
        } return studentNumber;
    }
             

    public static List<String> getProgramList(){
        List<String> list = new ArrayList<>();
        try (Connection conn = DatabaseHelper.getConnection();
             ResultSet rs = conn.createStatement().executeQuery("SELECT program_name FROM tbl_programs"))
            {
                while(rs.next()){
                    list.add(rs.getString("program_name"));
                }
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public static int getProgramId(String programName){
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement pst = conn.prepareStatement(
                "SELECT program_id FROM tbl_programs WHERE program_name = ?")) {
            pst.setString(1, programName);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) return rs.getInt("program_id");
        } catch (SQLException e){
            throw new RuntimeException(e);
        } 
        return -1;
    }
}

    
