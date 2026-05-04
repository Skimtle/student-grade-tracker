/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.model;

/**
 *
 * @author Skimtle
 */
public class faculty extends users {
    private int facultyID;
    
    public faculty(int facultyID, String username, String password, String fullName){
        super(username, password, fullName);
        this.facultyID = facultyID;
    }
    
    public int getfacultyID(){
        return facultyID;
    }
}
