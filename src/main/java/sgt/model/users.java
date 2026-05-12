/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.model;

/**
 *
 * @author Skimtle
 */
public class users {
    protected int id;
    private String username;
    private String password;
    private String fullName;
    
    
    public users(int id, String username, String password, String fullName){
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }
    public int getId(){
        return id;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getfullName(){
        return fullName;
    }
    
}
