package view;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import main.MainClient;

/**
 * Ventana de inicio de sesión donde los usuarios pueden ingresar su nombre y
 * contraseña para acceder al sistema.
 */
public class LogInView extends javax.swing.JFrame {

    /**
     * Constructor, Inicializa los componentes y hace visible la ventana
     */
    public LogInView() {
        initComponents();
        setResizable(false);

        setSize(MainClient.width, MainClient.height);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nameLbl = new javax.swing.JLabel();
        passwordLbl = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JPasswordField();
        backBtn = new javax.swing.JButton();
        logInBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 800));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LOG IN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));

        nameLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        nameLbl.setForeground(new java.awt.Color(255, 255, 255));
        nameLbl.setText("Ingrese su nombre de usuario:");

        passwordLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        passwordLbl.setForeground(new java.awt.Color(255, 255, 255));
        passwordLbl.setText("Ingrese su contraseña:");

        nameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        passwordTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextFieldActionPerformed(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(0, 0, 0));
        backBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Regresar");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        logInBtn.setBackground(new java.awt.Color(0, 0, 0));
        logInBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        logInBtn.setForeground(new java.awt.Color(255, 255, 255));
        logInBtn.setText("Autenticar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(logInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(passwordLbl))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(nameLbl)))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(nameLbl)
                .addGap(79, 79, 79)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(passwordLbl)
                .addGap(67, 67, 67)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(146, 146, 146))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logInBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JTextField passwordTextField;
    // End of variables declaration//GEN-END:variables

    public JButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(JButton backBtn) {
        this.backBtn = backBtn;
    }

    public JButton getLogInBtn() {
        return logInBtn;
    }

    public void setLogInBtn(JButton logInBtn) {
        this.logInBtn = logInBtn;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(JTextField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }



}
