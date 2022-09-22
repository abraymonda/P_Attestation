/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import utils.DB;
import static utils.DB.getConnection;

/**
 *
 * 
 * @author DELL
 */
public class utilisateur {
    
    public int idUtilisateur;
    public String nomUtil;
    public String password;

    public utilisateur() {
    }

    public utilisateur(String nomUtil, String password) {
        this.nomUtil = nomUtil;
        this.password = password;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getNomUtil() {
        return nomUtil;
    }

    public String getPassword() {
        return password;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setNomUtil(String nomUtil) {
        this.nomUtil = nomUtil;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean login(){
        try (java.sql.PreparedStatement ps = DB.getConnection().prepareStatement("SELECT * FROM utilisateur WHERE nomUtil = ? AND password = ?")) {
            ps.setString(1, this.nomUtil);
            ps.setString(2, this.password);
            ResultSet rset = ps.executeQuery();
            if(rset.next()) return true;
        } catch (Exception ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
    
}
