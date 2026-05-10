package sgt.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sgt.model.Grade;

public class GradeDAO {
    public double convertRawToGWA(double rawGrade) {
        if (rawGrade >= 97) return 1.00;
        else if (rawGrade >= 94) return 1.25;
        else if (rawGrade >= 91) return 1.50;
        else if (rawGrade >= 88) return 1.75;
        else if (rawGrade >= 85) return 2.00;
        else if (rawGrade >= 82) return 2.25;
        else if (rawGrade >= 79) return 2.50;
        else if (rawGrade >= 76) return 2.75;
        else if (rawGrade == 75) return 3.00;
        else return 5.00;
    }

    public List<String> searchStudents(String query) {
        List<String> results = new ArrayList<>();

        String sql = "SELECT student_no, first_name, last_name FROM tbl_students WHERE student_no LIKE ? OR last_name LIKE ?";

        try (Connection con = sgt.session.SQLconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, "%" + query + "%");
            pst.setString(2, "%" + query + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String studentNo = rs.getString("student_no");
                String fullName = rs.getString("first_name") + " " + rs.getString("last_name");
                results.add(studentNo + " - " + fullName);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }
    public boolean saveGrade(Grade grade) {
        String sql = "INSERT INTO tbl_grades (student_id, subject_code, raw_grade, gwa, faculty_id) " +
                "VALUES (?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE raw_grade = VALUES(raw_grade), gwa = VALUES(gwa), faculty_id = VALUES(faculty_id)";

        try (Connection con = sgt.session.SQLconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, grade.getStudentId());
            pst.setString(2, grade.getSubjectCode());
            pst.setDouble(3, grade.getRawGrade());
            pst.setDouble(4, grade.getGwa());
            pst.setInt(5, grade.getFacultyId());

            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}