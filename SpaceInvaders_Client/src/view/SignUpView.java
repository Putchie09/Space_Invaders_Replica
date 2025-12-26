package view;

import javax.swing.JButton;
import javax.swing.JTextField;
import main.MainClient;

/**
 * Ventana donde los usuarios pueden inscribirse proporcionando un nombre de usuario y una contraseña.
 */
public class SignUpView extends javax.swing.JFrame {
    private int width = MainClient.width;
    private int height = MainClient.height;
    /**
     * Constructor, Inicializa los componentes y hace visible la ventana
     */
    public SignUpView() {
        initComponents();
        
        setSize(width, height);
        setResizable(false);
        
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
        signInBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SIGN UP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));

        nameLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        nameLbl.setForeground(new java.awt.Color(255, 255, 255));
        nameLbl.setText("Ingrese su nombre de usuario:");

        passwordLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        passwordLbl.setForeground(new java.awt.Color(255, 255, 255));
        passwordLbl.setText("Ingrese su contraseña:");

        nameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        passwordTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        signInBtn.setBackground(new java.awt.Color(0, 0, 0));
        signInBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        signInBtn.setForeground(new java.awt.Color(255, 255, 255));
        signInBtn.setText("Inscribir");
        signInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInBtnActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 164, Short.MAX_VALUE)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152)
                .addComponent(signInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(nameLbl)
                        .addGap(232, 232, 232))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(267, 267, 267))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(nameLbl)
                .addGap(81, 81, 81)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(passwordLbl)
                .addGap(61, 61, 61)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
    }//GEN-LAST:event_backBtnActionPerformed

    private void signInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInBtnActionPerformed
    }//GEN-LAST:event_signInBtnActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JButton signInBtn;
    // End of variables declaration//GEN-END:variables

    public JButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(JButton backBtn) {
        this.backBtn = backBtn;
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

    public JButton getSignInBtn() {
        return signInBtn;
    }

    public void setSignInBtn(JButton signInBtn) {
        this.signInBtn = signInBtn;
    }

   

}
