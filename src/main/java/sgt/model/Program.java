/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.model;

/**
 *
 * @author Skimtle
 */
public class Program{
    private int id;
    private String program_code;
    private String program_name;
    
    public Program(String program_code, String program_name){
        this.program_code = program_code;
        this.program_name = program_name;
    }
    
    public Program(int id, String program_code, String program_name){
        this.id = id;
        this.program_code = program_code;
        this.program_name = program_name;
    }
    
    public int getId(){
        return id;
    }
    public String getCode(){
        return program_code;
    }
    public String getName(){
        return program_name;
    }
    
    public void setCode(String program_code){
        this.program_code = program_code;
    }
    public void setName(String program_name){
        this.program_name = program_name;
    }
    
}
