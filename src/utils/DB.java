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

/**
 *
 * @author DELL
 */
public class DB {
    static Connection connect;
   

    static String url = "jdbc:mysql://localhost:3306/gestattestation";

    static String login = "root";
 
    static String password = "";

    public static Connection getConnection()  {
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
}