package sgt.model;

public class Grade {
    private int gradeId;
    private int studentId;
    private String subjectCode;
    private double rawGrade;
    private double gwa;
    private int facultyId;
    private int adminId;

    public Grade() {}

    public Grade(int studentId, String subjectCode, double rawGrade, double gwa, int facultyId) {
        this.studentId = studentId;
        this.subjectCode = subjectCode;
        this.rawGrade = rawGrade;
        this.gwa = gwa;
        this.facultyId = facultyId;
    }

    // Getters and Setters
    public int getGradeId() { return gradeId; }
    public void setGradeId(int gradeId) { this.gradeId = gradeId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getSubjectCode() { return subjectCode; }
    public void setSubjectCode(String subjectCode) { this.subjectCode = subjectCode; }

    public double getRawGrade() { return rawGrade; }
    public void setRawGrade(double rawGrade) { this.rawGrade = rawGrade; }

    public double getGwa() { return gwa; }
    public void setGwa(double gwa) { this.gwa = gwa; }

    public int getFacultyId() { return facultyId; }
    public void setFacultyId(int facultyId) { this.facultyId = facultyId; }
}