/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import utils.DB;


/**
 *
 * @author DELL
 */
public class Apprenant {
    
    public int  codeApprenant;
    public String nomApp;
    public String prenomApp;
    public String email ;
    public String telephone;

    public Apprenant() {
    }

    public Apprenant(int codeApprenant, String nomApp, String prenomApp, String email, String telephone) {
        this.codeApprenant = codeApprenant;
        this.nomApp = nomApp;
        this.prenomApp = prenomApp;
        this.email = email;
        this.telephone = telephone;
    }

    public int getCodeApprenant() {
        return codeApprenant;
    }

    public String getNomApp() {
        return nomApp;
    }

    public String getPrenomApp() {
        return prenomApp;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setCodeApprenant(int codeApprenant) {
        this.codeApprenant = codeApprenant;
    }

    public void setNomApp(String nomApp) {
        this.nomApp = nomApp;
    }

    public void setPrenomApp(String prenomApp) {
        this.prenomApp = prenomApp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public boolean Insert(){
       try (java.sql.PreparedStatement ps = DB.getConnection().prepareStatement("INSERT INTO apprenant(nomApp, prenomApp, "
                + "                                                             email, telephone) "
                + "                                                             VALUES(?,?,?,?)")) {
            ps.setString(1,this.nomApp);
            ps.setString(2, this.prenomApp);
            ps.setString(3, this.email);
            ps.setString(4, this.telephone);
   
         
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            Logger.getLogger(Apprenant.class.getName()).log(Level.SEVERE, null, e);        
        }
        return false;
    }
    public DefaultTableModel getForJTable(String params, String on) {
    // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("CODE");
    model.addColumn("NOM");
    model.addColumn("PRENOM");
    model.addColumn("EMAIL");
    model.addColumn("TELEPHONE");
    
    String query = "";
    
    if(on == "a"){
        query = "SELECT * FROM apprenant WHERE nomApp "
                + "LIKE '%"+params+"%' OR prenomApp LIKE '%"+params+"%' "
                + "ORDER BY codeApprenant DESC;";
    }else if(on == "f"){
        query = "SELECT * FROM apprenant_in_formation WHERE idFormation = "+params+"";
    }
    
    
    try ( 
            PreparedStatement ps = (PreparedStatement) DB.getConnection().prepareStatement(query);
            ResultSet rset = ps.executeQuery()) {
        while (rset.next()) {
            
            model.addRow(new Object[]{
                rset.getInt("codeApprenant"),
                rset.getString("nomApp"),
                rset.getString("prenomApp"),
                rset.getString("Email"),
                rset.getString("Telephone"),
                
                });
        }

    } catch (Exception e) {
        Logger.getLogger(Apprenant.class.getName()).log(Level.SEVERE, null, e);
        return null;
    }
        return model;
    
    }   
    
    
    public boolean Delete() {
        
         try(java.sql.PreparedStatement ps = DB.getConnection().prepareStatement("DELETE FROM  apprenant WHERE codeApprenant = ?")) {
            ps.setInt(1, codeApprenant);
            return ps.executeUpdate() > 0;
        }catch (SQLException ex) {
            Logger.getLogger(Apprenant.class.getName()).log(Level.SEVERE, null, ex);
            
        }

           return false;
        
    }
    
    public boolean Update() {
        try(java.sql.PreparedStatement ps = DB.getConnection().prepareStatement("UPDATE apprenant SET nomApp = ?, prenomApp = ?, email = ?, telephone = ? WHERE  codeApprenant = ?")) {
            ps.setString(1, getNomApp());
            ps.setString(2, getPrenomApp());
            ps.setString(3, getEmail());
            ps.setString(4, getTelephone());
            ps.setInt(5, getCodeApprenant());
            return ps.executeUpdate() > 0;
        }catch (SQLException ex) {
            Logger.getLogger(Apprenant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public DefaultListModel getFormations(){
        DefaultListModel model = new DefaultListModel();
        try ( 
        PreparedStatement ps = (PreparedStatement) DB.getConnection().prepareStatement("SELECT f.* FROM formation f, affectation a "
                + "                                                                                WHERE f.idFormation = a.idFormation "
                + "                                                                                AND a.codeApprenant =  "+getCodeApprenant());
                                                                                                                                                                         
            ResultSet rset = ps.executeQuery()) {
            while (rset.next()) {
                
                Formation f = new Formation();
                f.setIdFormation(rset.getInt("idFormation"));
                f.setTitre(rset.getString("titre"));
                model.addElement(f);
            }

        } catch (Exception e) {
            Logger.getLogger(Formation.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        
        return model;
    }
    
    public boolean removeFormation(Formation formation) {
        
        try(java.sql.PreparedStatement ps = DB.getConnection().prepareStatement("DELETE FROM  affectation WHERE codeApprenant = ? AND idFormation = ?")) {
            ps.setInt(1, codeApprenant);
            ps.setInt(2, formation.getIdFormation());
            return ps.executeUpdate() > 0;
        }catch (SQLException ex) {
            Logger.getLogger(Apprenant.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        return false;
        
    }
    
    public boolean addFormation(Formation formation) {
        
        try(java.sql.PreparedStatement ps = DB.getConnection().prepareStatement("INSERT INTO affectation VALUES(?,?)")) {
            ps.setInt(1, codeApprenant);
            ps.setInt(2, formation.getIdFormation());
            return ps.executeUpdate() > 0;
        }catch (SQLException ex) {
            Logger.getLogger(Apprenant.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        return false;
        
    }
}

