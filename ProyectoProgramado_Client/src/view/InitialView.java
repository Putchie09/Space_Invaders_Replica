package view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import main.MainClient;

/**
 * Ventana inicial, permite autenticar y registrar usuarios
 */
public class InitialView extends javax.swing.JFrame {

    /**
     * Constructor, inicializa los componentes y hace visible la ventana
     */
    public InitialView() {
        initComponents();
        setResizable(false);

        setSize(MainClient.width, MainClient.height);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        exitBtn = new javax.swing.JButton();
        authenticateBtn = new javax.swing.JButton();
        signUpBtn = new javax.swing.JButton();
        titleLbl = new javax.swing.JLabel();
        enemiesLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 800));

        jPanel.setBackground(new java.awt.Color(0, 0, 0));
        jPanel.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel.setPreferredSize(new java.awt.Dimension(800, 800));

        exitBtn.setBackground(new java.awt.Color(0, 0, 0));
        exitBtn.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        exitBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn.setText("SALIR");
        exitBtn.setFocusable(false);

        authenticateBtn.setBackground(new java.awt.Color(0, 0, 0));
        authenticateBtn.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        authenticateBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        authenticateBtn.setForeground(new java.awt.Color(255, 255, 255));
        authenticateBtn.setText("AUTENTICAR");
        authenticateBtn.setFocusable(false);
        authenticateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authenticateBtnActionPerformed(evt);
            }
        });

        signUpBtn.setBackground(new java.awt.Color(0, 0, 0));
        signUpBtn.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        signUpBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        signUpBtn.setForeground(new java.awt.Color(255, 255, 255));
        signUpBtn.setText("INSCRIBIR");
        signUpBtn.setFocusable(false);

        titleLbl.setFont(new java.awt.Font("Times New Roman", 3, 86)); // NOI18N
        titleLbl.setForeground(new java.awt.Color(204, 204, 204));
        titleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLbl.setText("Space Invaders");

        enemiesLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        enemiesLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enemiesLbl.png"))); // NOI18N

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(enemiesLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(exitBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(authenticateBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(signUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(260, 260, 260))))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(enemiesLbl)
                .addGap(54, 54, 54)
                .addComponent(signUpBtn)
                .addGap(32, 32, 32)
                .addComponent(authenticateBtn)
                .addGap(37, 37, 37)
                .addComponent(exitBtn)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void authenticateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authenticateBtnActionPerformed
    }//GEN-LAST:event_authenticateBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton authenticateBtn;
    private javax.swing.JLabel enemiesLbl;
    private javax.swing.JButton exitBtn;
    private javax.swing.JPanel jPanel;
    private javax.swing.JButton signUpBtn;
    private javax.swing.JLabel titleLbl;
    // End of variables declaration//GEN-END:variables

    //--Setters and Getters--//
    public JButton getSignUpBtn() {
        return signUpBtn;
    }

    public void setSignUpBtn(JButton signUpBtn) {
        this.signUpBtn = signUpBtn;
    }

    public JButton getAuthenticateBtn() {
        return authenticateBtn;
    }

    public void setAuthenticateBtn(JButton authenticateBtn) {
        this.authenticateBtn = authenticateBtn;
    }

    public JButton getExitBtn() {
        return exitBtn;
    }

    public void setExitBtn(JButton exitBtn) {
        this.exitBtn = exitBtn;
    }

    public JLabel getTitleLbl() {
        return titleLbl;
    }

    public void setTitleLbl(JLabel titleLbl) {
        this.titleLbl = titleLbl;
    }

    public JLabel getEnemiesLbl() {
        return enemiesLbl;
    }

    public void setEnemiesLbl(JLabel enemiesLbl) {
        this.enemiesLbl = enemiesLbl;
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

}
