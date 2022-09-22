/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
 import java.util.Date;
/**
 *
 * @author DELL
 */
public class attestation {
    
    public int codeApprenant;
    public int idFormation;
    public Date dateAttes;

    public attestation() {
    }

    public attestation(int codeApprenant, int idFormation, Date dateAttes) {
        this.codeApprenant = codeApprenant;
        this.idFormation = idFormation;
        this.dateAttes = dateAttes;
    }

    public int getCodeApprenant() {
        return codeApprenant;
    }

    public int getIdFormation() {
        return idFormation;
    }

    public Date getDateAttes() {
        return dateAttes;
    }

    public void setCodeApprenant(int codeApprenant) {
        this.codeApprenant = codeApprenant;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public void setDateAttes(Date dateAttes) {
        this.dateAttes = dateAttes;
    }
    
    
}
