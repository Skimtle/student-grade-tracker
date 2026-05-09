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
    private static int userId;
    
    public static void setSession(int id, String name, String role){
       currentUser = name;
       userId = id;
       isLoggedIn = true;
       currentRole = role;
   }
    
   public static String getCurrentUser(){
       return (currentUser != null) ? currentUser : "Guest";
   }
   
    public static String getCurrentRole() { //Added by Cii
        return currentRole;
    }
    
    public static void clear(){
       logout();
    }
    public static boolean isLoggedIn(){
       return isLoggedIn;
    }
    public static void logout(){
       currentUser = null;
       currentRole = null;
       userId = 0;
       isLoggedIn = false;
    }

    public static int getUserId(){ return userId; }
}
