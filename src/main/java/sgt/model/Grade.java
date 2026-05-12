package sgt.model;

public class Grade {
    private int gradeId;
    private int studentId;
    private int subjectId;
    private double rawGrade;
    private double gwa;
    private int facultyId;

    public Grade() {}

    public Grade(int studentId, int subjectId, double rawGrade, double gwa, int facultyId) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.rawGrade = rawGrade;
        this.gwa = gwa;
        this.facultyId = facultyId;
    }

    // Getters and Setters
    public int getGradeId() { return gradeId; }
    public void setGradeId(int gradeId) { this.gradeId = gradeId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getSubjectId() { return subjectId; }
    public void setSubjectId(int subjectId) { this.subjectId = subjectId; }

    public double getRawGrade() { return rawGrade; }
    public void setRawGrade(double rawGrade) { this.rawGrade = rawGrade; }

    public double getGwa() { return gwa; }
    public void setGwa(double gwa) { this.gwa = gwa; }

    public int getFacultyId() { return facultyId; }
    public void setFacultyId(int facultyId) { this.facultyId = facultyId; }
}