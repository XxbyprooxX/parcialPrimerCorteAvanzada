package edu.progAvUD.parcialPrimerCorte.vista;

import javax.swing.ImageIcon;

/**
 *Esta clase se encarga de mostrar la menu var para serializar o cerrar el programa
 * @author Andres Felipe
 */
public class PanelPrincipal extends javax.swing.JPanel {

    /**
     * Creates new form PanelPrincipal
     */
    public PanelPrincipal() {
        initComponents();
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
        jButtonPropiedadesBD = new javax.swing.JButton();
        jButtonPropiedadesGatos = new javax.swing.JButton();
        jButtonContinuar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(8, 8, 6));
        setForeground(new java.awt.Color(8, 8, 6));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(203, 171, 112));
        jLabel1.setText("Antes de iniciar el programa, seleccione las propiedades de los siguientes parametros");

        jButtonPropiedadesBD.setBackground(new java.awt.Color(203, 171, 112));
        jButtonPropiedadesBD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonPropiedadesBD.setText("Propiedades Base de Datos");
        jButtonPropiedadesBD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButtonPropiedadesGatos.setBackground(new java.awt.Color(203, 171, 112));
        jButtonPropiedadesGatos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonPropiedadesGatos.setText("Propiedades Iniciales de Gatos");
        jButtonPropiedadesGatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButtonContinuar.setBackground(new java.awt.Color(203, 171, 112));
        jButtonContinuar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonContinuar.setText("Continuar");
        jButtonContinuar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/main/java/edu/progAvUD/parcialPrimerCorte/Imagenes/gatobd.jpg"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178))))
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonPropiedadesGatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPropiedadesBD, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jButtonContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButtonPropiedadesBD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonPropiedadesGatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonContinuar;
    public javax.swing.JButton jButtonPropiedadesBD;
    public javax.swing.JButton jButtonPropiedadesGatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
