/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgt.session;

/**
 *
 * @author Skimtle
 * @author Cii
 */
public class UserSession {
    private static String currentUser = null;
    private static String currentRole = null; //Added by Cii
    private static boolean isLoggedIn= false;
    private static int facultyId;
    private static String facultyName;
    
   public static void setCurrentUser(String name){
       currentUser = name;
   }
   public static String getCurrentUser(){
       return (currentUser != null) ? currentUser : "Guest";
   }
   public static void setCurrentRole(String role) { //Added by Cii 
        currentRole = role;
    }

    public static String getCurrentRole() { //Added by Cii
        return currentRole;
    }
   public static void clear(){
       currentUser = null;
   }
   public static boolean isLoggedIn(){
       return isLoggedIn;
   }
   public static void logout(){
       currentUser = null;
       isLoggedIn = false;
   }
   public static int getFacultyId(){return facultyId;}
   public static String getFacultyName(){return facultyName;}
   public static void setSession(int id, String name){
       facultyId = id;
       facultyName = name;
       currentUser = name;
       isLoggedIn = true;
   }
}
