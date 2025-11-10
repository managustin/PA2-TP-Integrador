package vista.gato;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author ms_ma
 */
public class VentanaVisitas extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaVisitas.class.getName());

    public VentanaVisitas(java.awt.Dialog  parent, boolean modal) {
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
        panelObservaciones2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaVisitas = new javax.swing.JList<>();
        panelObservaciones = new javax.swing.JPanel();
        lblObservaciones = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextField();
        panelObservaciones1 = new javax.swing.JPanel();
        lblResultado = new javax.swing.JLabel();
        txtResultado = new javax.swing.JTextField();
        panelBoton = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        panelRellenoDer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        panelPrincipal.setMaximumSize(new java.awt.Dimension(800, 2147483647));
        panelPrincipal.setMinimumSize(new java.awt.Dimension(800, 600));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(800, 600));
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
            .addGap(0, 598, Short.MAX_VALUE)
        );

        panelPrincipal.add(panelRellenoIzq, java.awt.BorderLayout.LINE_START);

        panelCentro.setMinimumSize(new java.awt.Dimension(400, 300));
        panelCentro.setPreferredSize(new java.awt.Dimension(400, 300));
        panelCentro.setLayout(new java.awt.GridLayout(5, 1, 0, 25));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo.setText("Registrar Visita");
        lblTitulo.setToolTipText("");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelTitulo.add(lblTitulo);

        panelCentro.add(panelTitulo);

        panelObservaciones2.setLayout(new java.awt.GridLayout(1, 1));

        listaVisitas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaVisitas);

        panelObservaciones2.add(jScrollPane1);

        panelCentro.add(panelObservaciones2);

        panelObservaciones.setLayout(new java.awt.GridLayout(2, 1));

        lblObservaciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblObservaciones.setText("Observaciones");
        lblObservaciones.setToolTipText("");
        panelObservaciones.add(lblObservaciones);
        panelObservaciones.add(txtObservaciones);

        panelCentro.add(panelObservaciones);

        panelObservaciones1.setLayout(new java.awt.GridLayout(2, 1));

        lblResultado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResultado.setText("Resultado");
        lblResultado.setToolTipText("");
        panelObservaciones1.add(lblResultado);
        panelObservaciones1.add(txtResultado);

        panelCentro.add(panelObservaciones1);

        panelBoton.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelBoton.add(btnGuardar);

        panelCentro.add(panelBoton);

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
            .addGap(0, 598, Short.MAX_VALUE)
        );

        panelPrincipal.add(panelRellenoDer, java.awt.BorderLayout.EAST);

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

    }//GEN-LAST:event_btnGuardarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<String> listaVisitas;
    private javax.swing.JPanel panelBoton;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelObservaciones;
    private javax.swing.JPanel panelObservaciones1;
    private javax.swing.JPanel panelObservaciones2;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelRellenoDer;
    private javax.swing.JPanel panelRellenoIzq;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JTextField txtResultado;
    // End of variables declaration//GEN-END:variables

    public JTextField getTxtObservaciones() {
        return txtObservaciones;
    }

    public JTextField getTxtResultado() {
        return txtResultado;
    }

    public JList<String> getListaVisitas() {
        return listaVisitas;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }
    
    
    
    
}
