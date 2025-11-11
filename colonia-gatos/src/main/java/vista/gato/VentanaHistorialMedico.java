package vista.gato;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class VentanaHistorialMedico extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaHistorialMedico.class.getName());


    public VentanaHistorialMedico(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelRellenoIzq = new javax.swing.JPanel();
        panelCentro = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        listaRegistros = new javax.swing.JList<>();
        panelBotones = new javax.swing.JPanel();
        btnVerRegistro = new javax.swing.JButton();
        btnAgregarRegistro = new javax.swing.JButton();
        btnCertificado = new javax.swing.JButton();
        panelRellenoDer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 800));
        setPreferredSize(new java.awt.Dimension(900, 800));

        panelPrincipal.setMaximumSize(new java.awt.Dimension(10000, 2147483647));
        panelPrincipal.setMinimumSize(new java.awt.Dimension(900, 800));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(900, 800));
        panelPrincipal.setLayout(new java.awt.BorderLayout());

        panelRellenoIzq.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 1, 1));
        panelRellenoIzq.setPreferredSize(new java.awt.Dimension(100, 1193));

        javax.swing.GroupLayout panelRellenoIzqLayout = new javax.swing.GroupLayout(panelRellenoIzq);
        panelRellenoIzq.setLayout(panelRellenoIzqLayout);
        panelRellenoIzqLayout.setHorizontalGroup(
            panelRellenoIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );
        panelRellenoIzqLayout.setVerticalGroup(
            panelRellenoIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );

        panelPrincipal.add(panelRellenoIzq, java.awt.BorderLayout.LINE_START);

        panelCentro.setMinimumSize(new java.awt.Dimension(400, 300));
        panelCentro.setPreferredSize(new java.awt.Dimension(400, 300));
        panelCentro.setLayout(new java.awt.GridLayout(4, 1, 0, 35));

        panelTitulo.setLayout(new java.awt.GridLayout(2, 0));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Historial Médico");
        lblTitulo.setToolTipText("");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelTitulo.add(lblTitulo);

        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstado.setText("jLabel1");
        panelTitulo.add(lblEstado);

        panelCentro.add(panelTitulo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );

        panelCentro.add(jPanel2);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane.setViewportView(listaRegistros);

        jPanel1.add(jScrollPane, java.awt.BorderLayout.CENTER);

        panelCentro.add(jPanel1);

        panelBotones.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));

        btnVerRegistro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVerRegistro.setText("Ver Registro");
        btnVerRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerRegistroActionPerformed(evt);
            }
        });
        panelBotones.add(btnVerRegistro);

        btnAgregarRegistro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAgregarRegistro.setText("Agregar Registro");
        btnAgregarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRegistroActionPerformed(evt);
            }
        });
        panelBotones.add(btnAgregarRegistro);

        btnCertificado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCertificado.setText("Emitir Certificado");
        btnCertificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCertificadoActionPerformed(evt);
            }
        });
        panelBotones.add(btnCertificado);

        panelCentro.add(panelBotones);

        panelPrincipal.add(panelCentro, java.awt.BorderLayout.CENTER);

        panelRellenoDer.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 1, 1));
        panelRellenoDer.setPreferredSize(new java.awt.Dimension(100, 1193));

        javax.swing.GroupLayout panelRellenoDerLayout = new javax.swing.GroupLayout(panelRellenoDer);
        panelRellenoDer.setLayout(panelRellenoDerLayout);
        panelRellenoDerLayout.setHorizontalGroup(
            panelRellenoDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRellenoDerLayout.setVerticalGroup(
            panelRellenoDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );

        panelPrincipal.add(panelRellenoDer, java.awt.BorderLayout.EAST);

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerRegistroActionPerformed

    }//GEN-LAST:event_btnVerRegistroActionPerformed

    private void btnAgregarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarRegistroActionPerformed

    private void btnCertificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCertificadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCertificadoActionPerformed


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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaHistorialMedico dialog = new VentanaHistorialMedico(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarRegistro;
    private javax.swing.JButton btnCertificado;
    private javax.swing.JButton btnVerRegistro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<String> listaRegistros;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelRellenoDer;
    private javax.swing.JPanel panelRellenoIzq;
    private javax.swing.JPanel panelTitulo;
    // End of variables declaration//GEN-END:variables

    public void setEstado(String estado) {
        lblEstado.setText(estado);
    }
    
    public void cargarListaRegistros(List<String> items) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String s : items) model.addElement(s);
        listaRegistros.setModel(model); // setModel reemplaza el contenido visible de la JList
    }

    public JButton getBtnAgregarRegistro() {
        return btnAgregarRegistro;
    }

    public JButton getBtnCertificado() {
        return btnCertificado;
    }

    public JButton getBtnVerRegistro() {
        return btnVerRegistro;
    }

    public JList<String> getListaRegistros() {
        return listaRegistros;
    }
    
    
}
