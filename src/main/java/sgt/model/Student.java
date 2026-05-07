/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.model;

/**
 *
 * @author Skimtle
 */
public class Student {
    private String studentNum;
    private String firstName;
    private String lastName;
    private int yearLevel;
    private int programId;
    private Integer facultyId;
    private Integer adminId;
    
    public Student(String studentNum, String firstName, String lastName, int yearLevel, int programId, Integer facultyId, Integer adminId){
        this.studentNum = studentNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearLevel = yearLevel;
        this.programId = programId;
        this.facultyId = facultyId;
        this.adminId = adminId;
    }
    //getter
    public String getStudentNum(){
        return studentNum;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getlastName(){
        return lastName;
    }
    public int getYearLevel(){
        return yearLevel;
    }
    public int getProgramId(){
        return programId;
    }
    public Integer getFacultyId(){
        return facultyId;
    }
    public Integer getAdminId(){
        return adminId;
    }
    //setters
    public void setStudentNum(String studentNum){
        this.studentNum = studentNum;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setlastName(String lastName){
        this.lastName = lastName;
    }
    public void setYearLevel(int yearLevel){
        this.yearLevel = yearLevel;
    }
    public void setProgramId(int programId){
        this.programId = programId;
    }
    public void setFacultyId(Integer facultyId){
        this.facultyId = facultyId;
    }
    public void setAdminId(Integer adminId){
        this.adminId = adminId;
    }
    
}
