/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sgt;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;
import sgt.UI.LoginUI;
//import sgt.session.SQLconnection;

/**
 *
 * @author Skimtle
 */
public class StudentGradeTracker {

    public static void main(String[] args) {
        try{
            FlatMacLightLaf.setup();
            
            UIManager.put("Button.arc", 20);
            UIManager.put("Component.arc", 20);
            UIManager.put("TextComponent.arc", 20);
            UIManager.put("CheckBox.arc", 5);
            UIManager.put("ScrollBar.showButtons", true);
            UIManager.put("ScrollBar.width", 12);
        } catch (Exception ex){
            System.err.println("Failed to initialize flatlaf");}
        java.awt.EventQueue.invokeLater(() -> {
            new LoginUI().setVisible(true);
        });
    }
}
