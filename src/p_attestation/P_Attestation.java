/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_attestation;
import utils.DB;
import Forms.Utilisateur;
import Forms.DBSetup;
import javax.swing.JOptionPane;
/**
 *
 * @author DELL
 */
public class P_Attestation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //DB.setupConnection("root", "", "3306", "gestattestation");
        //DB.getConnectionParameters();
        DB.getConnection();
        if(DB.getConnection() != null){
            Utilisateur login = new Utilisateur();
            login.setVisible(true);
        }else{
            DBSetup dbs = new DBSetup();
            JOptionPane.showMessageDialog(dbs,"Erreur de connection a la base de donnees");
            dbs.setVisible(true);
        }

        //(new Utilisateur()).setVisible(true);
    }
    
}
