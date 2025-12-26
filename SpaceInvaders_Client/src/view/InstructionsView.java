package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import main.MainClient;

/**
 *Ventana de instrucciones, permite ver las instrucciones generales del juego
 */
public class InstructionsView extends javax.swing.JFrame {

    /**
     * Constructor, Inicializa los componentes y hace visible la ventana
     */
    public InstructionsView() {
        initComponents();
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        setSize(MainClient.width, MainClient.height);
        setPreferredSize(new Dimension(MainClient.width, MainClient.height));
        
        this.getContentPane().setBackground(Color.BLACK);
        
        setResizable(false);
        setLocationRelativeTo(null);

        txtPaneInstructions.setWrapStyleWord(rootPaneCheckingEnabled);
        jScrollPane1.setBorder(null);

        //Display window
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblInstructions = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPaneInstructions = new javax.swing.JTextArea();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblInstructions.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblInstructions.setForeground(new java.awt.Color(255, 255, 255));
        lblInstructions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInstructions.setText("INSTRUCCIONES");

        txtPaneInstructions.setEditable(false);
        txtPaneInstructions.setBackground(new java.awt.Color(0, 0, 0));
        txtPaneInstructions.setColumns(20);
        txtPaneInstructions.setBorder(null);
        txtPaneInstructions.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPaneInstructions.setForeground(new java.awt.Color(255, 255, 255));
        txtPaneInstructions.setLineWrap(true);
        txtPaneInstructions.setRows(5);
        txtPaneInstructions.setWrapStyleWord(true);
        txtPaneInstructions.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtPaneInstructions.setFocusable(false);
        jScrollPane1.setViewportView(txtPaneInstructions);

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnBack.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("VOLVER");
        btnBack.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(lblInstructions, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(319, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(315, 315, 315))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblInstructions)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInstructions;
    private javax.swing.JTextArea txtPaneInstructions;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(JButton btnBack) {
        this.btnBack = btnBack;
    }

    public JLabel getLblInstructions() {
        return lblInstructions;
    }

    public void setLblInstructions(JLabel lblInstructions) {
        this.lblInstructions = lblInstructions;
    }

    public JTextArea getTextAreaInstructions() {
        return txtPaneInstructions;
    }

    public void setTextAreaInstructions(JTextArea textAreaInstructions) {
        this.txtPaneInstructions = textAreaInstructions;
    }

    public void setInstructions(String instructions) {
        txtPaneInstructions.setText(instructions);
    }

}
