/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sgt;
import sgt.UI.LoginUI;
//import sgt.session.SQLconnection;

/**
 *
 * @author Skimtle
 */
public class StudentGradeTracker {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        java.awt.EventQueue.invokeLater(() -> {
            new LoginUI().setVisible(true);
        });
    }
}
