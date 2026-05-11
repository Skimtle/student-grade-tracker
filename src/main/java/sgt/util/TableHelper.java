/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.util;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import sgt.session.SQLconnection;

/**
 *
 * @author Skimtle
 */
public class TableHelper {
    public static void updateTable(JTable table, String query, String param){
        try (Connection con = SQLconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             ) {
            
                if (param != null) {
                pst.setObject(1, param); 
            }
            try(ResultSet rs = pst.executeQuery()){
            table.setModel(DbUtils.resultSetToTableModel(rs));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Table Error: " + e.getMessage());
        }
    }
}
