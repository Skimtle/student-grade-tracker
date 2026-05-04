/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.model;

/**
 *
 * @author Skimtle
 */
public class admin extends users {
    private int adminID;
    
    public admin(int adminID, String username, String password, String fullName){
        super(username, password, fullName);
        this.adminID = adminID;
    }
    
    public int getfacultyID(){
        return adminID;
    }
}
