/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import javax.swing.JOptionPane;
import utils.DB;
import Forms.Utilisateur;
/**
 *
 * @author DELL
 */
public class DBSetup extends javax.swing.JFrame {

    /**
     * Creates new form DBSetup
     */
    public DBSetup() {
        initComponents();
        
        String[] params = DB.getConnectionParameters().split(",");
        jTextFieldUsername.setText(params[0]);
        jTextFieldPassword.setText(params[1]);
        jTextFieldPort.setText(params[2]);
        jTextFieldDatabasename.setText(params[3]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPort = new javax.swing.JTextField();
        jTextFieldUsername = new javax.swing.JTextField();
        jTextFieldPassword = new javax.swing.JTextField();
        jButtonSetup = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDatabasename = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Database Setup");
        setLocation(new java.awt.Point(400, 200));

        jLabel1.setText("DATABASE PARAMETERS SETUP");

        jLabel2.setText("USERNAME");

        jLabel3.setText("PASSWORD");

        jLabel4.setText("PORT");

        jTextFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPasswordActionPerformed(evt);
            }
        });

        jButtonSetup.setText("SETUP");
        jButtonSetup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSetupActionPerformed(evt);
            }
        });

        jLabel5.setText("DATABASENAME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldDatabasename, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldPort, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonSetup, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel1)))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                            .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDatabasename, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jButtonSetup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPasswordActionPerformed

    private void jButtonSetupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSetupActionPerformed
        // TODO add your handling code here:
        
        if (jTextFieldUsername.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Username obligatoire!");
        }else if(jTextFieldPort.getText().isBlank()){
            JOptionPane.showMessageDialog(rootPane, "Port obligatoire!");
        }else if(jTextFieldDatabasename.getText().isBlank()){
            JOptionPane.showMessageDialog(rootPane, "Databasename obligatoire!");
        }else if(jTextFieldPort.getText().isBlank()){
            JOptionPane.showMessageDialog(rootPane, "Port obligatoire!");
        }else{
            String username = jTextFieldUsername.getText() ;
            String password = jTextFieldPassword.getText() ;
            String port = jTextFieldPort.getText();
            String database = jTextFieldDatabasename.getText();
            DB.setupConnection(username, password, port, database);
            if(DB.getConnection() != null){
                JOptionPane.showMessageDialog(rootPane, "connection a la base de donnees reussi");
                Utilisateur login = new Utilisateur();
                login.setVisible(true);
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Erreur de connection a la base de donnees");
            }
        }
    }//GEN-LAST:event_jButtonSetupActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DBSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DBSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DBSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DBSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DBSetup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSetup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldDatabasename;
    private javax.swing.JTextField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldPort;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}