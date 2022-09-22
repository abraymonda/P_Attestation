/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_attestation;
import utils.DB;
import Forms.Utilisateur;
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
        DB.getConnection();
        Utilisateur login = new Utilisateur();
        login.setVisible(true);
        //(new Utilisateur()).setVisible(true);
    }
    
}
