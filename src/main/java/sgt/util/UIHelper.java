/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.util;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.text.JTextComponent;
/**
 *
 * @author Skimtle
 */
public class UIHelper {
    public static void clearComponents(Object... components) {
        for (Object c : components) {
            if (c instanceof JTextComponent) {
                ((JTextComponent) c).setText("");
            } else if (c instanceof JComboBox) {
                ((JComboBox<?>) c).setSelectedIndex(0);
            } else if (c instanceof JTable) {
                ((JTable) c).clearSelection();
            }
        }
    }
}
