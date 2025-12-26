package view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import main.MainClient;

/**
 * Vista donde se muestran las mejores 10 puntuaciones
 */
public class ScoresView extends javax.swing.JFrame {

    /**
     * Constructor, Inicializa los componentes y hace visible la ventana
     */
    public ScoresView() {
        initComponents();

        this.getContentPane().setBackground(Color.BLACK);

        setSize(MainClient.width, MainClient.height);
        
        setResizable(false);
        setLocationRelativeTo(null);

        jScrollPane1.setBorder(null);

        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAScores = new javax.swing.JTextPane();
        lblMejoresPuntajes = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        txtAScores.setEditable(false);
        txtAScores.setBackground(new java.awt.Color(0, 0, 0));
        txtAScores.setBorder(null);
        txtAScores.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtAScores.setForeground(new java.awt.Color(255, 255, 255));
        txtAScores.setFocusable(false);
        jScrollPane1.setViewportView(txtAScores);
        // estilo de documento para centrar texto
        StyledDocument doc = txtAScores.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);

        // Aplicar el estilo al documento
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        lblMejoresPuntajes.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblMejoresPuntajes.setForeground(new java.awt.Color(255, 255, 255));
        lblMejoresPuntajes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMejoresPuntajes.setText("MEJORES PUNTAJES");

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnBack.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("VOLVER");
        btnBack.setFocusable(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMejoresPuntajes, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblMejoresPuntajes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMejoresPuntajes;
    private javax.swing.JTextPane txtAScores;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(JButton btnBack) {
        this.btnBack = btnBack;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLblBestScores() {
        return lblMejoresPuntajes;
    }

    public void setLblBestScores(JLabel lblMejoresPuntajes) {
        this.lblMejoresPuntajes = lblMejoresPuntajes;
    }

    public JTextPane getTxtAScores() {
        return txtAScores;
    }

    public void setTxtAScores(JTextPane txtAScores) {
        this.txtAScores = txtAScores;
    }

    public void setScores(String scores) {
        txtAScores.setText(scores);
    }

}
