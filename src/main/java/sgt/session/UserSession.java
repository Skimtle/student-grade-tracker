/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.session;

/**
 *
 * @author Skimtle
 */
public class UserSession {
    private static String currentUser;
    
   public static void setCurrentUser(String name){
       currentUser = name;
   }
   public static String getCurrentUser(){
       return (currentUser != null) ? currentUser : "Guest";
   }
   public static void clear(){
       currentUser = null;
   }
}
