/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.model;

/**
 *
 * @author Skimtle
 */
public class Subject {
    private int id;
    private String subjectCode;
    private String subjectName;
    private String roomNumber; 
    private String program;    

    public Subject(String subjectCode, String subjectName, String roomNumber, String program) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.roomNumber  = roomNumber;
        this.program     = program;
    }

    public Subject(int id, String subjectCode, String subjectName, String roomNumber, String program) {
        this.id          = id;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.roomNumber  = roomNumber;
        this.program     = program;
    }

    public int getId()            { return id; }
    public String getSubjectCode(){ return subjectCode; }
    public String getSubjectName(){ return subjectName; }
    public String getRoomNumber() { return roomNumber; }  
    public String getProgram()    { return program; }     

    public void setSubjectCode(String subjectCode) { this.subjectCode = subjectCode; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }
    public void setRoomNumber(String roomNumber)   { this.roomNumber = roomNumber; } 
    public void setProgram(String program)         { this.program = program; }        
}