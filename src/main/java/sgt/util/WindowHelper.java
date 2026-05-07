/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.util;
import javax.swing.JFrame;

/**
 *
 * @author Cii
 */
public class WindowHelper {
    
    public static void openWindow(JFrame parent, JFrame newWindow) {
        //newWindow.setSize(parent.getSize());
        newWindow.setLocationRelativeTo(null);
        newWindow.setVisible(true);
        parent.dispose();
    }
}
