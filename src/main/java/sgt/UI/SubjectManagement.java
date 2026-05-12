/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sgt.UI;

import java.awt.Color;
import sgt.UI.DashboardFaculty;
import sgt.UI.LoginUI;
import sgt.session.UserSession;
import sgt.util.WindowHelper;
import sgt.util.TableHelper;

/**
 *
 * @author Cii
 * @author Skimtle
 */
public class SubjectManagement extends javax.swing.JFrame {
   private final String BASE_QUERY = 
    "SELECT s.subject_id as 'ID', " +
    "s.subject_code as 'Code', " +
    "s.subject_name as 'Subject Name', " +
    "s.room_number as 'Room', " +
    "IFNULL(p.program_code, 'N/A') as 'Program' " + // Shows N/A if no program is set
    "FROM tbl_subjects s " +
    "LEFT JOIN tbl_programs p ON s.program_id = p.program_id";
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SubjectManagement.class.getName());

    /**
     * Creates new form SubjectManagement
     */
    public SubjectManagement() {
        if (sgt.session.UserSession.getCurrentUser() == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "Please login first!");
        new LoginUI().setVisible(true);
        this.dispose();
        return;
        }
        initComponents();
        setResizable(false);
        jPanel1.setBackground(Color.decode("#F28C5E"));
        populate_table();
        loadProgramDropdown();
    }

    private void populate_table(){
        sgt.util.TableHelper.updateTable(jTable1, BASE_QUERY, "");
    }
    
    private void resetUI() {
        sgt.util.UIHelper.clearComponents(SubjectCode, SubjectName, jTable1);
        jButton3.setEnabled(true); // Re-enable Add button
    }
    
    private int getSelectedId() {
        int row = jTable1.getSelectedRow();
        if (row == -1) return -1;
        return Integer.parseInt(jTable1.getValueAt(row, 0).toString());
    }
    
    private void loadProgramDropdown(){
        program.removeAllItems();
        program.addItem("Select Program");

        for (String p : sgt.service.StudentService.getProgramList()){
            program.addItem(p);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        SubjectCode = new javax.swing.JTextField();
        SubjectName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        RoomNum = new javax.swing.JTextField();
        program = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        SubjectCode.setToolTipText("");

        SubjectName.addActionListener(this::SubjectNameActionPerformed);

        jLabel1.setFont(new java.awt.Font("Public Sans Medium", 0, 18)); // NOI18N
        jLabel1.setText("Subject Code");

        jLabel2.setFont(new java.awt.Font("Public Sans Medium", 0, 18)); // NOI18N
        jLabel2.setText("Subject Name");

        jLabel3.setFont(new java.awt.Font("Public Sans Medium", 0, 24)); // NOI18N
        jLabel3.setText("Subject Management");

        jButton1.setText("Back");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Update");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("Add");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setText("Delete");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jLabel4.setFont(new java.awt.Font("Public Sans Medium", 0, 18)); // NOI18N
        jLabel4.setText("Program");

        jLabel5.setFont(new java.awt.Font("Public Sans Medium", 0, 18)); // NOI18N
        jLabel5.setText("Room Number");

        RoomNum.addActionListener(this::RoomNumActionPerformed);

        program.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SubjectCode)
                    .addComponent(SubjectName)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RoomNum)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(program, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(program, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RoomNum, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubjectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubjectNameActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int row = jTable1.getSelectedRow();
        if (row == -1) return;

        int id = Integer.parseInt(jTable1.getValueAt(row, 0).toString());
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Delete this subject?", "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            sgt.dao.subjectDAO dao = new sgt.dao.subjectDAO();
        if (dao.deleteSubjects(id)) {
            populate_table();
            sgt.util.UIHelper.clearComponents(SubjectCode, SubjectName, jTable1);
            jButton3.setEnabled(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Cannot delete: Subject is currently in use by students.");
        }
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         int row = jTable1.getSelectedRow();
    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please select a subject to update!");
        return;
    }

    int id    = Integer.parseInt(jTable1.getValueAt(row, 0).toString());
    String code = SubjectCode.getText().trim();
    String name = SubjectName.getText().trim();
    String room = RoomNum.getText().trim();                       
    String prog = (String) program.getSelectedItem();            

    if (code.isEmpty() || name.isEmpty() || room.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Fields cannot be empty!");
        return;
    }

    if (prog == null || prog.equals("Select Program")) {            
        javax.swing.JOptionPane.showMessageDialog(this, "Please select a program!");
        return;
    }

    sgt.model.Subject updatedSubj = new sgt.model.Subject(id, code, name, room, prog);
    sgt.dao.subjectDAO dao = new sgt.dao.subjectDAO();

    if (dao.updateSubjects(updatedSubj)) {
        javax.swing.JOptionPane.showMessageDialog(this, "Subject updated successfully!");
        populate_table();
        sgt.util.UIHelper.clearComponents(SubjectCode, SubjectName, RoomNum, jTable1); 
        program.setSelectedIndex(0);                            
        jButton3.setEnabled(true);
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Update failed.");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    int row = jTable1.getSelectedRow();
    if (row != -1) {
        SubjectCode.setText(jTable1.getValueAt(row, 1).toString());
        SubjectName.setText(jTable1.getValueAt(row, 2).toString());
        RoomNum.setText(jTable1.getValueAt(row, 3).toString());

        // match the program in the dropdown
        String prog = jTable1.getValueAt(row, 4).toString();      
        program.setSelectedItem(prog);

        jButton3.setEnabled(false);
    }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    String code = SubjectCode.getText().trim();
    String name = SubjectName.getText().trim();
    String room = RoomNum.getText().trim();                          
    String prog = (String) program.getSelectedItem();          

    if (code.isEmpty() || name.isEmpty() || room.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Fields cannot be empty!");
        return;
    }

    if (prog == null || prog.equals("Select Program")) {         
        javax.swing.JOptionPane.showMessageDialog(this, "Please select a program!");
        return;
    }

    sgt.dao.subjectDAO dao = new sgt.dao.subjectDAO();
    if (dao.addSubjects(new sgt.model.Subject(code, name, room, prog))) {
        javax.swing.JOptionPane.showMessageDialog(this, "Subject added successfully!");
        populate_table();
        SubjectCode.setText("");
        SubjectName.setText("");
        RoomNum.setText("");                                        
        program.setSelectedIndex(0);                           
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Failed to add subject.");
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String role = sgt.session.UserSession.getCurrentRole();
        if ("faculty".equals(role)) {
            WindowHelper.openWindow(this, new DashboardFaculty(UserSession.getCurrentUser()));
        } else {
            WindowHelper.openWindow(this, new DashboardAdmin(UserSession.getCurrentUser()));
        }   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RoomNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoomNumActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new SubjectManagement().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField RoomNum;
    private javax.swing.JTextField SubjectCode;
    private javax.swing.JTextField SubjectName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> program;
    // End of variables declaration//GEN-END:variables
}
