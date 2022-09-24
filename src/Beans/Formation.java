/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import java.util.Date;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import utils.DB;
import utils.DateUtils;

/**
 *
 * @author DELL
 */
public class Formation {
    public int idFormation;
    public String titre;
    public Date dateDebut;
    public Date dateFin;
    public String prix;

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getPrix() {
        return prix;
    }

    public Formation() {
    }

    public Formation(int idFormation, String titre, Date dateDebut, Date dateFin, String prix) {
        this.idFormation = idFormation;
        this.titre = titre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
    }
    
    public Formation(int idFormation, String titre) {
        this.idFormation = idFormation;
        this.titre = titre;
    }

    

    public int getIdFormation() {
        return idFormation;
    }

    public String getTitre() {
        return titre;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    
    
    public boolean Insert(){
       try (java.sql.PreparedStatement ps = DB.getConnection().prepareStatement("INSERT INTO formation(titre, dateDebut, "
                + "                                                             dateFin, prix) "
                + "                                                             VALUES(?,?,?,?)")) {
            ps.setString(1,this.titre);
            ps.setString(2, DateUtils.dateToString(this.dateDebut));
            ps.setString(3, DateUtils.dateToString(this.dateFin));
            ps.setString(4, this.prix);
           
            return ps.executeUpdate()> 0;
        } catch (Exception e) {
            Logger.getLogger(Formation.class.getName()).log(Level.SEVERE, null, e);        
        }
        return false;
    }
    public DefaultTableModel getForJTable(String params) {
    // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("TITRE");
        model.addColumn("PRIX");
        model.addColumn("DATE DEBUT");
        model.addColumn("DATE FIN");
        //model.addColumn("");
    
        try ( 
            PreparedStatement ps = (PreparedStatement) DB.getConnection().prepareStatement("SELECT * FROM formation "
                                                                                            + "WHERE titre LIKE '%"+params+"%' "
                                                                                            + "ORDER BY idFormation DESC");
                                                                                            
                                                                                            
            ResultSet rset = ps.executeQuery()) {
            while (rset.next()) {
            
            model.addRow(new Object[]{
                rset.getInt("idFormation"),
                rset.getString("titre"),
                rset.getString("prix"),
                rset.getString("dateDebut"),
                rset.getString("dateFin"),
                
            });
        }

        } catch (Exception e) {
            Logger.getLogger(Formation.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        return model;
    
    }   
    
    public boolean Delete() {
        
         try(java.sql.PreparedStatement ps = DB.getConnection().prepareStatement("DELETE FROM  formation WHERE idFormation = ?")) {
            ps.setInt(1, idFormation);
            return ps.executeUpdate() > 0;
        }catch (SQLException ex) {
            Logger.getLogger(Formation.class.getName()).log(Level.SEVERE, null, ex);
            
        }
           return false;
        
    }
    
    public boolean Update() {
        try(java.sql.PreparedStatement ps = DB.getConnection().prepareStatement("UPDATE formation SET titre = ?, prix = ?, dateDebut = ?, dateFin = ? WHERE  idFormation = ?")) {
            ps.setString(1, getTitre());
            ps.setString(2, getPrix());
            ps.setString(3, DateUtils.dateToString(this.getDateDebut()));
            ps.setString(4, DateUtils.dateToString(this.getDateFin()));
            ps.setInt(5, getIdFormation());
            return ps.executeUpdate() > 0;
        }catch (SQLException ex) {
            Logger.getLogger(Formation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public DefaultListModel getForAffectationList(int codeApprenant){
        DefaultListModel model = new DefaultListModel();
        try ( 
        PreparedStatement ps = (PreparedStatement) DB.getConnection().prepareStatement("SELECT f.* FROM formation f WHERE f.idFormation NOT IN (SELECT a.idFormation FROM affectation a WHERE a.codeApprenant = "+codeApprenant+")");
                                                                                            
                                                                                            
            ResultSet rset = ps.executeQuery()) {
            while (rset.next()) {
                
                Formation f = new Formation();
                f.setIdFormation(rset.getInt("f.idFormation"));
                f.setTitre(rset.getString("f.titre"));
                model.addElement(f);
            }

        } catch (Exception e) {
            Logger.getLogger(Formation.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        
        return model;
    }
    
    public DefaultComboBoxModel getForCombobox(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try ( 
        PreparedStatement ps = (PreparedStatement) DB.getConnection().prepareStatement("SELECT * FROM formation");
                                                                                            
                                                                                            
            ResultSet rset = ps.executeQuery()) {
            while (rset.next()) {
                
                Formation f = new Formation(
                   rset.getInt("idFormation"),
                   rset.getString("titre")
                );
                model.addElement(f);
            }

        } catch (Exception e) {
            Logger.getLogger(Formation.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        
        return model;
    }

    
    @Override
    public String toString() {
        return this.getTitre();
    }
}
