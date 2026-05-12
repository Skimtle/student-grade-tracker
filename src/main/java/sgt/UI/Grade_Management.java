/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sgt.UI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import sgt.session.UserSession;
import sgt.util.WindowHelper;



/**
 *
 * @author ADMIN
 */
public class Grade_Management extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Grade_Management.class.getName());
    private JPopupMenu suggestionPopup;
    private JList<String> suggestionList;
    private DefaultListModel<String> listModel;
    /**
     * Creates new form Grade_Management
     */
    public Grade_Management() {
        initComponents();
        initSearchSuggestions();
        loadAllGrades();
        Grade.setEnabled(false);
        Grade.setBackground(java.awt.Color.LIGHT_GRAY); 
        loadSubjectDropdown();
        checkInputs();
    
        StudentNumber.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { updateSuggestions(); }
            public void removeUpdate(DocumentEvent e) { updateSuggestions(); }
            public void insertUpdate(DocumentEvent e) { updateSuggestions(); }

            private void updateSuggestions() {
                String text = StudentNumber.getText().trim();
                if (text.length() >= 2) { // Show suggestions after 2 characters
                    showSuggestions(text);
                } else {
                    suggestionPopup.setVisible(false);
                }
                checkInputs(); // Call unused method to toggle Grade field
            }
        });
        Subject.addActionListener(e -> checkInputs());
    }
    
    private void initSearchSuggestions() {
        suggestionPopup = new JPopupMenu();
        listModel = new DefaultListModel<>();
        suggestionList = new JList<>(listModel);
        
        suggestionPopup.setFocusable(false);
        suggestionPopup.add(new JScrollPane(suggestionList));

        // When a student number is clicked in the dropdown
        suggestionList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    String selected = suggestionList.getSelectedValue();
                    StudentNumber.setText(selected);
                    suggestionPopup.setVisible(false);
                    searchStudent(selected); // Automatically trigger search
                }
            }
        });
    }
    
    private void showSuggestions(String text) {
        listModel.removeAllElements();
        String sql = "SELECT student_number FROM tbl_students WHERE student_number LIKE ?";
        
        try (Connection con = sgt.session.SQLconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, text + "%");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                listModel.addElement(rs.getString("student_number"));
            }

            if (listModel.getSize() > 0) {
                suggestionPopup.show(StudentNumber, 0, StudentNumber.getHeight());
                StudentNumber.requestFocus(); // Keep focus on textfield
            } else {
                suggestionPopup.setVisible(false);
            }
        } catch (Exception ex) {
            System.out.println("Suggestion Error: " + ex);
        }
    }
    
    private void loadAllGrades() {
        String sql ="SELECT s.student_number, " +
                 "CONCAT(s.first_name, ' ', s.last_name) AS full_name, " +
                 "p.program_code, " +
                 "sub.subject_code, " +
                 "sub.subject_name, " +
                 "g.raw_grade, " +
                 "g.gwa_grade " +
                 "FROM tbl_grades g " +
                 "JOIN tbl_students s ON g.student_id = s.student_id " +
                 "JOIN tbl_subjects sub ON g.subject_id = sub.subject_id " +
                 "JOIN tbl_programs p ON s.program_id = p.program_id " +
                 "ORDER BY s.student_number, sub.subject_code";
        
        // Using your existing TableHelper
        sgt.util.TableHelper.updateTable(tbl_students, sql);
    }
    
    private void searchStudent(String studentNumber) {
        String sql = "SELECT student_id, first_name, last_name FROM tbl_students WHERE student_number = ?";

        try (Connection con = sgt.session.SQLconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, studentNumber);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String fullName = rs.getString("first_name") + " " + rs.getString("last_name");
                FullName.setText(fullName);
                
                // Filter table for this specific student
                loadFilteredGrades(rs.getInt("student_id"));
            } else {
                FullName.setText("Student not found!");
                loadAllGrades(); // Revert to showing all if search fails
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    private void loadFilteredGrades(int studentId) {
        String sql ="SELECT s.student_number, " +
                    "CONCAT(s.first_name, ' ', s.last_name) AS full_name, " +
                    "p.program_code, " +
                    "sub.subject_code, " +
                    "sub.subject_name, " +
                    "g.raw_grade, " +
                    "g.gwa_grade " +
                    "FROM tbl_grades g " +
                    "JOIN tbl_students s ON g.student_id = s.student_id " +
                    "JOIN tbl_subjects sub ON g.subject_id = sub.subject_id " +
                    "JOIN tbl_programs p ON s.program_id = p.program_id " +
                    "WHERE g.student_id = ? " +
                    "ORDER BY sub.subject_code";
        
        sgt.util.TableHelper.updateTable(tbl_students, sql, String.valueOf(studentId));
    }
    
    private void loadSubjectDropdown() {
        Subject.removeAllItems();
        Subject.addItem("Select Subject");

        String sql = "SELECT subject_id, subject_code, subject_name FROM tbl_subjects";

        try {
            Connection con = sgt.session.SQLconnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                int id = rs.getInt("subject_id");
                String code = rs.getString("subject_code");
                String name = rs.getString("subject_name");
                Subject.addItem(id + " - " + code + " - " + name);
            }
        } catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    private void loadStudentGrades(int studentId) {
        String sql = "SELECT sub.subject_code, sub.subject_name, g.raw_grade, g.gwa_grade " +
                     "FROM tbl_grades g " +
                     "JOIN tbl_subjects sub ON g.subject_id = sub.subject_id " +
                     "WHERE g.student_id = ?";
        sgt.util.TableHelper.updateTable(tbl_students, sql, String.valueOf(studentId));
    }

    private void checkInputs() {
        boolean hasStudent = !StudentNumber.getText().trim().isEmpty();
        boolean hasSubject = Subject.getSelectedIndex() > 0;
    
        if (hasStudent && hasSubject) {
            Grade.setEnabled(true);
            Grade.setBackground(java.awt.Color.WHITE);
        } else {
            Grade.setEnabled(false);
            Grade.setBackground(java.awt.Color.LIGHT_GRAY);
        }
    }
    
    private int getStudentId(String studentNumber) {
        String sql = "SELECT student_id FROM tbl_students WHERE student_number = ?";
        try {
            Connection con = sgt.session.SQLconnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentNumber);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("student_id");
            }
        } catch (Exception ex) {
            System.out.println("Error getting student ID: " + ex);
        }
        return -1; // Returns -1 if student doesn't exist
    }
    
    private void clearGradeTable() {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tbl_students.getModel();
        model.setRowCount(0); // This wipes the table rows clean
        GWA.setText("0.00");  // Reset GWA display
    }
    
    private void updateGWA() {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tbl_students.getModel();
        double total = 0;
        int count = 0;
    
        for (int i = 0; i < model.getRowCount(); i++) {
            Object val = model.getValueAt(i, 5); // Grade column
            if (val != null) {
                total += Double.parseDouble(val.toString());
                count++;
            }
        }
    
        if (count > 0) {
            double avg = total / count;
            GWA.setText(String.format("%.2f", avg));
        }
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_students = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        FullName = new javax.swing.JTextField();
        Subject = new javax.swing.JComboBox<>();
        back = new javax.swing.JButton();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        StudentNumber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Grade = new javax.swing.JTextField();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tbl_students.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "Program", "Subject", "Subject Code", "Grade"
            }
        ));
        tbl_students.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_students);

        jLabel3.setText("Subject:");

        Subject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computer Programming 2", "Information Management", "Discrete Structures 1" }));

        back.setText("Back");
        back.addActionListener(this::backActionPerformed);

        add.setText("Add");
        add.addActionListener(this::addActionPerformed);

        update.setText("Update");
        update.addActionListener(this::updateActionPerformed);

        delete.setText("Delete");
        delete.addActionListener(this::deleteActionPerformed);

        jLabel7.setText("Name:");

        jLabel8.setText("Student Number:");

        StudentNumber.addActionListener(this::StudentNumberActionPerformed);

        jLabel1.setText("Grade:");

        Grade.addActionListener(this::GradeActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(StudentNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Grade, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(FullName, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Subject, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(add)
                                .addGap(18, 18, 18)
                                .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(delete)
                                .addGap(3, 3, 3)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(StudentNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(update)
                    .addComponent(delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
       if (StudentNumber.getText().isEmpty() || Subject.getSelectedIndex() <= 0) {
             javax.swing.JOptionPane.showMessageDialog(this, "Please select a grade from the table to delete.");
             return;
        }

        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Delete this grade?", "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            int studentId = getStudentId(StudentNumber.getText().trim());
            int subjectId = Integer.parseInt(Subject.getSelectedItem().toString().split(" - ")[0]);

            String sql = "DELETE FROM tbl_grades WHERE student_id = ? AND subject_id = ?";
            if (sgt.util.DatabaseHelper.executeUpdate(sql, studentId, subjectId)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Grade Deleted.");
                loadStudentGrades(studentId); // Refresh UI
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String studentNum = StudentNumber.getText().trim();
        String gradeText = Grade.getText().trim();
        String selected = Subject.getSelectedItem().toString();

        if (studentNum.isEmpty() || gradeText.isEmpty()) return;

        int studentId = getStudentId(studentNum);
        int subjectId = Integer.parseInt(selected.split(" - ")[0]);
        double rawGrade = Double.parseDouble(gradeText);
        double gwaGrade = new sgt.dao.GradeDAO().convertRawToGWA(rawGrade);

        String sql = "UPDATE tbl_grades SET raw_grade = ?, gwa_grade = ? WHERE student_id = ? AND subject_id = ?";
        boolean success = sgt.util.DatabaseHelper.executeUpdate(sql, rawGrade, gwaGrade, studentId, subjectId);

        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this, "Grade Updated!");
            loadStudentGrades(studentId);
            updateGWA();
        }
    }//GEN-LAST:event_updateActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String studentNum = StudentNumber.getText().trim();
        String gradeText = Grade.getText().trim();

        if(studentNum.isEmpty() || gradeText.isEmpty() || Subject.getSelectedIndex() <= 0){
            javax.swing.JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        try {
            double rawGrade = Double.parseDouble(gradeText);
            if(rawGrade < 75 || rawGrade > 100){
                javax.swing.JOptionPane.showMessageDialog(this, "Grade must be 75-100!");
                return;
            }

            int studentId = getStudentId(studentNum);
            int subjectId = Integer.parseInt(Subject.getSelectedItem().toString().split(" - ")[0]);
            double gwaGrade = new sgt.dao.GradeDAO().convertRawToGWA(rawGrade);

            String sql = "INSERT INTO tbl_grades (student_id, subject_id, raw_grade, gwa_grade, faculty_id, admin_id) VALUES (?, ?, ?, ?, ?, ?)";
            int currentId = UserSession.getUserId();
            String role = UserSession.getCurrentRole();

            Object facultyId = "faculty".equals(role) ? currentId : null;
            Object adminId = "admin".equals(role) ? currentId : null;

            if(sgt.util.DatabaseHelper.executeUpdate(sql, studentId, subjectId, rawGrade, gwaGrade, facultyId, adminId)){
                javax.swing.JOptionPane.showMessageDialog(this, "Grade saved!");
                loadStudentGrades(studentId);
                Grade.setText("");
            }
        } catch(NumberFormatException e){
            javax.swing.JOptionPane.showMessageDialog(this, "Invalid grade format!");
        }
    }//GEN-LAST:event_addActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        String role = sgt.session.UserSession.getCurrentRole();
        if ("faculty".equals(role)) {
            WindowHelper.openWindow(this, new DashboardFaculty(UserSession.getCurrentUser()));
        } else {
            WindowHelper.openWindow(this, new DashboardAdmin(UserSession.getCurrentUser()));
        }
    }//GEN-LAST:event_backActionPerformed

    private void StudentNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentNumberActionPerformed
        String searchID = StudentNumber.getText().trim();
    }//GEN-LAST:event_StudentNumberActionPerformed

    private void GradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GradeActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tbl_studentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentsMouseClicked
        int row = tbl_students.getSelectedRow();
            if (row != -1) {
                // Mapping: 0=StudNum, 3=SubCode, 5=RawGrade
                String sNum = tbl_students.getValueAt(row, 0).toString();
                String subCode = tbl_students.getValueAt(row, 3).toString();
                String rawGrade = tbl_students.getValueAt(row, 5).toString();

                StudentNumber.setText(sNum);
                Grade.setText(rawGrade);

                // Loop through ComboBox to match the Subject Code
                for (int i = 0; i < Subject.getItemCount(); i++) {
                    if (Subject.getItemAt(i).toString().contains(subCode)) {
                        Subject.setSelectedIndex(i);
                        break;
                    }
                }

                // Refresh the student search to update the name labels/GWA
                searchStudent(sNum);
            }
    }//GEN-LAST:event_tbl_studentsMouseClicked

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
        java.awt.EventQueue.invokeLater(() -> new Grade_Management().setVisible(true));
    }
    private javax.swing.JLabel GWA;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FullName;
    private javax.swing.JTextField Grade;
    private javax.swing.JTextField StudentNumber;
    private javax.swing.JComboBox<String> Subject;
    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_students;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
