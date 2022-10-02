/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


import java.io.*;
/**
 *
 * @author DELL
 */
public class DB {
    static Connection connect = null;
   
    
    static String[] params;
     
    
    static String url = "";

    static String login = "";
 
    static String password = "";
    
    public static Connection getConnection()  {
        
        params = getConnectionParameters().split(",");
        
        login = params[0];
        password = params[1];
        String port = params[2];
        url = "jdbc:mysql://localhost:+"+port+"/"+params[3];
        if (connect == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(url, login,password);
                System.out.println("Connection réussie"); 
            } catch (SQLException e) {
                System.out.println("connection échoué: "+e.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return connect;
    
    }
    
    public static void setupConnection(String username, String password,String port, String database){
        try {
            System.out.println("writing...");
            BufferedWriter bw  = new BufferedWriter(
                new FileWriter("conn_params.txt")
            );
            
            bw.write(username+","+password+","+port+","+database);
            bw.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }
    
    public static String getConnectionParameters(){
        
        String values = null;
        try {
            BufferedReader br  = new BufferedReader(
                new FileReader("conn_params.txt")
            );
            
            values = br.readLine();
            
            br.close();
            
        }catch(IOException e){
            System.out.println(e.toString());
        }
        
        return values;
        
    }
}