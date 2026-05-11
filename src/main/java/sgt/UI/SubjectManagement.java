/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sgt.UI;

import java.awt.Color;
import sgt.session.UserSession;
import sgt.util.WindowHelper;

/**
 *
 * @author Cii
 * @author Skimtle
 */
public class SubjectManagement extends javax.swing.JFrame {
    private final String BASE_QUERY = "SELECT subject_id as 'ID', subject_code as 'Code', subject_name as 'Subject Name' FROM tbl_subjects";
    
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
        Program = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        RoomNum = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();

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

        Program.addActionListener(this::ProgramActionPerformed);

        jLabel5.setFont(new java.awt.Font("Public Sans Medium", 0, 18)); // NOI18N
        jLabel5.setText("Room Number");

        RoomNum.addActionListener(this::RoomNumActionPerformed);

        jLabel6.setFont(new java.awt.Font("Public Sans Medium", 0, 18)); // NOI18N
        jLabel6.setText("Time");

        jTextField5.addActionListener(this::jTextField5ActionPerformed);

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
                    .addComponent(Program)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RoomNum)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                        .addComponent(Program, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RoomNum, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(34, 34, 34)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1))
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
        
        if (row == -1){
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a subject from the table to update!");
            return;            
        }
        
        int id = Integer.parseInt(jTable1.getValueAt(row, 0).toString());
        String code = SubjectCode.getText().trim();
        String name = SubjectName.getText().trim();
        
        if (code.isEmpty() || name.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Fields cannot be empty!");
            return;
        }    
        
        sgt.model.Subject updatedSubj = new sgt.model.Subject(id, code, name);
        sgt.dao.subjectDAO dao = new sgt.dao.subjectDAO();
        
        if (dao.updateSubjects(updatedSubj)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Subject updated successfully!");
            populate_table();
            sgt.util.UIHelper.clearComponents(SubjectCode, SubjectName, jTable1);
            jButton3.setEnabled(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Update failed. Check database connection.");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        if(row != -1){
            SubjectCode.setText(jTable1.getValueAt(row, 1).toString());
            SubjectName.setText(jTable1.getValueAt(row, 2).toString());
            jButton3.setEnabled(false);
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String code = SubjectCode.getText().trim();
        String name = SubjectName.getText().trim();
        
        if(code.isEmpty() || name.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Fields cannot be empty!");
            return;
        }

        sgt.dao.subjectDAO dao = new sgt.dao.subjectDAO(); // Ensure you have this DAO
        if (dao.addSubjects(new sgt.model.Subject(code, name))) {
            javax.swing.JOptionPane.showMessageDialog(this, "Subject added successfully!", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            populate_table();
            SubjectCode.setText("");
            SubjectName.setText("");
        } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Failed to add subject. Check console for errors.");
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

    private void ProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgramActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProgramActionPerformed

    private void RoomNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoomNumActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

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
    private javax.swing.JTextField Program;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
