package vista;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author Victor
 */
public class ActualizarVista extends javax.swing.JPanel {

    /**
     * Creates new form ActualizarVista
     */
    public ActualizarVista() {
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

        btnGroupCategoria = new javax.swing.ButtonGroup();
        bgActualizar = new javax.swing.JPanel();
        pnTitulo = new javax.swing.JPanel();
        lbTitulo1 = new javax.swing.JLabel();
        lbSeleccion = new javax.swing.JLabel();
        cbListaDulces = new javax.swing.JComboBox<>();
        lbNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lbCategoria = new javax.swing.JLabel();
        rbDulce = new javax.swing.JRadioButton();
        rbAcido = new javax.swing.JRadioButton();
        rbSinAzucar = new javax.swing.JRadioButton();
        btnModificarDulce = new javax.swing.JButton();

        bgActualizar.setBackground(new java.awt.Color(255, 250, 244));
        bgActualizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnTitulo.setBackground(new java.awt.Color(255, 226, 225));

        lbTitulo1.setFont(new java.awt.Font("Calisto MT", 0, 48)); // NOI18N
        lbTitulo1.setForeground(new java.awt.Color(0, 51, 51));
        lbTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo1.setText("Actualizar Dulces");

        javax.swing.GroupLayout pnTituloLayout = new javax.swing.GroupLayout(pnTitulo);
        pnTitulo.setLayout(pnTituloLayout);
        pnTituloLayout.setHorizontalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTituloLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnTituloLayout.setVerticalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTituloLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addContainerGap())
        );

        bgActualizar.add(pnTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 110));

        lbSeleccion.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        lbSeleccion.setText("Seleccione el dulce que desea actualizar");
        bgActualizar.add(lbSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        cbListaDulces.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        cbListaDulces.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        bgActualizar.add(cbListaDulces, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, -1));

        lbNombre.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        lbNombre.setText("Ingrese el nuevo nombre del dulce");
        bgActualizar.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        txtNombre.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        txtNombre.setText("Nombre del dulce");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        bgActualizar.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 200, -1));

        lbCategoria.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        lbCategoria.setText("Seleccione la nueva categoria del dulce");
        bgActualizar.add(lbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        rbDulce.setBackground(new java.awt.Color(255, 250, 244));
        btnGroupCategoria.add(rbDulce);
        rbDulce.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        rbDulce.setText("Dulce");
        bgActualizar.add(rbDulce, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        rbAcido.setBackground(new java.awt.Color(255, 250, 244));
        btnGroupCategoria.add(rbAcido);
        rbAcido.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        rbAcido.setText("Acido");
        bgActualizar.add(rbAcido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, -1, -1));

        rbSinAzucar.setBackground(new java.awt.Color(255, 250, 244));
        btnGroupCategoria.add(rbSinAzucar);
        rbSinAzucar.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        rbSinAzucar.setText("Sin azucar");
        bgActualizar.add(rbSinAzucar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));

        btnModificarDulce.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        btnModificarDulce.setText("Modificar dulce");
        btnModificarDulce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarDulceActionPerformed(evt);
            }
        });
        bgActualizar.add(btnModificarDulce, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnModificarDulceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarDulceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarDulceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgActualizar;
    public javax.swing.ButtonGroup btnGroupCategoria;
    public javax.swing.JButton btnModificarDulce;
    public javax.swing.JComboBox<String> cbListaDulces;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbSeleccion;
    private javax.swing.JLabel lbTitulo1;
    private javax.swing.JPanel pnTitulo;
    public javax.swing.JRadioButton rbAcido;
    public javax.swing.JRadioButton rbDulce;
    public javax.swing.JRadioButton rbSinAzucar;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
