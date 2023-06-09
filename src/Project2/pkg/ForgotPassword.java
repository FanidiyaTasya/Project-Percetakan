/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Project2.pkg;

import Connection.pkg.Connect;
import java.awt.Color;
import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 *
 * @author heyitstasyaa
 */
public class ForgotPassword extends javax.swing.JFrame {

    public ForgotPassword() {
        initComponents();
        BtnReset.setBackground(new Color(0,0,0));
        BtnReset.setBorder(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        BtnReset = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        txtFavorite = new javax.swing.JTextField();
        txtConfPass = new javax.swing.JPasswordField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
        });
        getContentPane().add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 670, 210, 30));

        BtnReset.setBackground(new java.awt.Color(0, 0, 51));
        BtnReset.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        BtnReset.setForeground(new java.awt.Color(255, 255, 255));
        BtnReset.setText("Reset Password");
        BtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetActionPerformed(evt);
            }
        });
        getContentPane().add(BtnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 570, 170, 60));

        txtUsername.setBackground(new java.awt.Color(238, 238, 241));
        txtUsername.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtUsername.setBorder(null);
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 226, 330, 40));

        txtFavorite.setBackground(new java.awt.Color(238, 238, 241));
        txtFavorite.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtFavorite.setBorder(null);
        getContentPane().add(txtFavorite, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 313, 330, 40));

        txtConfPass.setBackground(new java.awt.Color(238, 238, 241));
        txtConfPass.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtConfPass.setBorder(null);
        getContentPane().add(txtConfPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 397, 330, 40));

        txtPassword.setBackground(new java.awt.Color(238, 238, 241));
        txtPassword.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtPassword.setBorder(null);
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 485, 330, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pkg/Forgot Password.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetActionPerformed
        try {
            if  (txtPassword.getText().equals(txtConfPass.getText())){
                String sql = "UPDATE akun SET password ='" + txtPassword.getText() +
                "' WHERE username ='" + txtUsername.getText() + "' AND favourite ='" + txtFavorite.getText() + "'";
                java.sql.Connection conn = (Connection) Connect.configDB();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Successfully Updated Password");
                setVisible(false);
                new Login().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null,"The password doesn't match");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_BtnResetActionPerformed

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_lblLoginMouseClicked

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
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JPasswordField txtConfPass;
    private javax.swing.JTextField txtFavorite;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
