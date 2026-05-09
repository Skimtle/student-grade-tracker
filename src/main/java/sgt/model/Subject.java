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
    
    public Subject(String subjectCode, String subjectName){
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
    }
    public Subject(int id, String subjectCode, String subjectName){
        this.id = id;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
    }
    public int getId(){return id;}
    public String getSubjectCode(){ return subjectCode;}
    public String getSubjectName(){ return subjectName;}
    
    public void setSubjectCode(String subjectCode){ 
        this.subjectCode = subjectCode;
    }
    public void setSubjectName(String subjectName){
        this.subjectName = subjectName;
    }
    
}
