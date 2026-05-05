/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import sgt.session.SQLconnection;
/**
 *
 * @author Skimtle
 */
public class DatabaseHelper {
    public static boolean executeUpdate(String sql, Object... params){
        try (Connection con = SQLconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            for(int i = 0; i < params.length; i++){
                pst.setObject(i + 1, params[i]);
            }
                
            int result = pst.executeUpdate();
            return result > 0;
            } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                    }
        }

    public static Connection getConnection() {
        return sgt.session.SQLconnection.getConnection();
    }
    }

