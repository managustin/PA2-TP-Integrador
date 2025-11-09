/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.gato;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import modelo.Gato;
import modelo.Tarea;

/**
 *
 * @author ms_ma
 */
public class VentanaPerfilGato extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPerfilGato.class.getName());

    public VentanaPerfilGato(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public VentanaPerfilGato(java.awt.Frame parent, boolean modal, Gato gato) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNorth = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        panelRellenoDerecha = new javax.swing.JPanel();
        panelRellenoIzq = new javax.swing.JPanel();
        panelCentral = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        lblZona = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        PanelTareas = new javax.swing.JPanel();
        lblTareas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTareas = new javax.swing.JList<>();
        panelBotones = new javax.swing.JPanel();
        btnRegistrarTarea = new javax.swing.JButton();
        btnVerHistorialMedico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 800));
        setPreferredSize(new java.awt.Dimension(900, 800));

        panelNorth.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 20, 1));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNombre.setText("Nombre Gato");
        panelNorth.add(lblNombre);

        getContentPane().add(panelNorth, java.awt.BorderLayout.NORTH);

        panelRellenoDerecha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 1, 1));
        panelRellenoDerecha.setPreferredSize(new java.awt.Dimension(50, 0));

        javax.swing.GroupLayout panelRellenoDerechaLayout = new javax.swing.GroupLayout(panelRellenoDerecha);
        panelRellenoDerecha.setLayout(panelRellenoDerechaLayout);
        panelRellenoDerechaLayout.setHorizontalGroup(
            panelRellenoDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRellenoDerechaLayout.setVerticalGroup(
            panelRellenoDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        getContentPane().add(panelRellenoDerecha, java.awt.BorderLayout.EAST);

        panelRellenoIzq.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        panelRellenoIzq.setPreferredSize(new java.awt.Dimension(50, 0));

        javax.swing.GroupLayout panelRellenoIzqLayout = new javax.swing.GroupLayout(panelRellenoIzq);
        panelRellenoIzq.setLayout(panelRellenoIzqLayout);
        panelRellenoIzqLayout.setHorizontalGroup(
            panelRellenoIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );
        panelRellenoIzqLayout.setVerticalGroup(
            panelRellenoIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        getContentPane().add(panelRellenoIzq, java.awt.BorderLayout.LINE_START);

        panelCentral.setLayout(new java.awt.GridLayout(4, 0));

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelCentral.add(lblFoto);

        lblZona.setText("Zona");
        panelCentral.add(lblZona);

        lblEstado.setText("Estado");
        panelCentral.add(lblEstado);

        PanelTareas.setLayout(new java.awt.GridLayout(2, 1));

        lblTareas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTareas.setText("Tareas");
        PanelTareas.add(lblTareas);

        listaTareas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaTareas.setMaximumSize(new java.awt.Dimension(100, 250));
        listaTareas.setMinimumSize(new java.awt.Dimension(45, 150));
        listaTareas.setPreferredSize(new java.awt.Dimension(45, 150));
        jScrollPane1.setViewportView(listaTareas);

        PanelTareas.add(jScrollPane1);

        panelCentral.add(PanelTareas);

        getContentPane().add(panelCentral, java.awt.BorderLayout.CENTER);

        panelBotones.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panelBotones.setLayout(new java.awt.GridLayout(1, 2, 50, 0));

        btnRegistrarTarea.setText("Agregar Tarea");
        btnRegistrarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarTareaActionPerformed(evt);
            }
        });
        panelBotones.add(btnRegistrarTarea);

        btnVerHistorialMedico.setText("Ver historial Médico");
        panelBotones.add(btnVerHistorialMedico);

        getContentPane().add(panelBotones, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarTareaActionPerformed
                
    }//GEN-LAST:event_btnRegistrarTareaActionPerformed

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
                VentanaPerfilGato dialog = new VentanaPerfilGato(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel PanelTareas;
    private javax.swing.JButton btnRegistrarTarea;
    private javax.swing.JButton btnVerHistorialMedico;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTareas;
    private javax.swing.JLabel lblZona;
    private javax.swing.JList<String> listaTareas;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelNorth;
    private javax.swing.JPanel panelRellenoDerecha;
    private javax.swing.JPanel panelRellenoIzq;
    // End of variables declaration//GEN-END:variables

// setters desde controlador:
    public void setNombreGato(String nombre) {
        lblNombre.setText(nombre);
    }

    public void setZona(String zona) {
        lblZona.setText(zona);
    }

    public void setEstado(String estado) {
        lblEstado.setText(estado);
    }

    public void setFoto(ImageIcon icono) {
        lblFoto.setIcon(icono);
    }
    
    public void cargarTareas(List<Tarea> tareas) {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Tarea t : tareas) {
            modelo.addElement(t.toString());
        }
        listaTareas.setModel(modelo);
    }
    
        public JList<String> getListaTareas() {
        return listaTareas;
    }
        
        public JButton getBtnRegistrarTarea(){
            return btnRegistrarTarea;
        }
        
}


