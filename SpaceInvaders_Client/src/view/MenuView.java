
package view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import main.MainClient;

/**
 * Representa la ventana del menú, que tiene las opciones:
 * jugar, ver instrucciones, ver mejores puntajes y volver.
 */
public class MenuView extends javax.swing.JFrame {

    /**
     * Constructor, Inicializa los componentes y hace visible la ventana
     */
    public MenuView() {
        initComponents();
        
        setSize(MainClient.width, MainClient.height);
        
        setResizable(false);
        setLocationRelativeTo(null);
        
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelInstruction = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jButtonPlay = new javax.swing.JButton();
        jButtonScores = new javax.swing.JButton();
        jButtonInstructions = new javax.swing.JButton();
        jButtonReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));

        jLabelInstruction.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelInstruction.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInstruction.setText("Seleccione una opción");

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 54)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("SPACE INVADERS");

        jButtonPlay.setBackground(new java.awt.Color(0, 0, 0));
        jButtonPlay.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonPlay.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPlay.setText("JUGAR");
        jButtonPlay.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE, 2));
        jButtonPlay.setFocusable(false);
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });

        jButtonScores.setBackground(new java.awt.Color(0, 0, 0));
        jButtonScores.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonScores.setForeground(new java.awt.Color(255, 255, 255));
        jButtonScores.setText("TOP PUNTAJES");
        jButtonScores.setActionCommand("");
        jButtonScores.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        jButtonScores.setFocusable(false);
        jButtonScores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonScores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonScoresActionPerformed(evt);
            }
        });

        jButtonInstructions.setBackground(new java.awt.Color(0, 0, 0));
        jButtonInstructions.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonInstructions.setForeground(new java.awt.Color(255, 255, 255));
        jButtonInstructions.setText("INSTRUCCIONES");
        jButtonInstructions.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        jButtonInstructions.setFocusable(false);
        jButtonInstructions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInstructionsActionPerformed(evt);
            }
        });

        jButtonReturn.setBackground(new java.awt.Color(0, 0, 0));
        jButtonReturn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonReturn.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReturn.setText("VOLVER");
        jButtonReturn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        jButtonReturn.setFocusable(false);
        jButtonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 140, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelInstruction)
                        .addGap(331, 331, 331))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButtonPlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonInstructions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonScores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(278, 278, 278))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabelTitle)
                .addGap(81, 81, 81)
                .addComponent(jLabelInstruction)
                .addGap(50, 50, 50)
                .addComponent(jButtonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButtonInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButtonScores, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButtonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
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

    //autogenerador por netbeans, pero no se utilizan aquí
    
    private void jButtonScoresActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonScoresActionPerformed
    }// GEN-LAST:event_jButtonScoresActionPerformed

    private void jButtonInstructionsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonInstructionsActionPerformed
    }// GEN-LAST:event_jButtonInstructionsActionPerformed

    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonPlayActionPerformed
    }// GEN-LAST:event_jButtonPlayActionPerformed

    private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonReturnActionPerformed

    }// GEN-LAST:event_jButtonReturnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInstructions;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JButton jButtonReturn;
    private javax.swing.JButton jButtonScores;
    private javax.swing.JLabel jLabelInstruction;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public JButton getjButtonInstructions() {
        return jButtonInstructions;
    }

    public void setjButtonInstructions(JButton jButtonInstructions) {
        this.jButtonInstructions = jButtonInstructions;
    }

    public JButton getjButtonPlay() {
        return jButtonPlay;
    }

    public void setjButtonPlay(JButton jButtonPlay) {
        this.jButtonPlay = jButtonPlay;
    }

    public JButton getjButtonReturn() {
        return jButtonReturn;
    }

    public void setjButtonReturn(JButton jButtonReturn) {
        this.jButtonReturn = jButtonReturn;
    }

    public JButton getjButtonScores() {
        return jButtonScores;
    }

    public void setjButtonScores(JButton jButtonScores) {
        this.jButtonScores = jButtonScores;
    }

    public JLabel getjLabelInstruction() {
        return jLabelInstruction;
    }

    public void setjLabelInstruction(JLabel jLabelInstruction) {
        this.jLabelInstruction = jLabelInstruction;
    }

    public JLabel getjLabelTitle() {
        return jLabelTitle;
    }

    public void setjLabelTitle(JLabel jLabelTitle) {
        this.jLabelTitle = jLabelTitle;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

}
