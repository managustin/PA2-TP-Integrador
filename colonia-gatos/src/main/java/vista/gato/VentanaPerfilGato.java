/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.gato;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
        panelArriba = new javax.swing.JPanel();
        panelFoto = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        panelInfo = new javax.swing.JPanel();
        panelTexto = new javax.swing.JPanel();
        lblZona = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        panelQR = new javax.swing.JPanel();
        lblQR = new javax.swing.JLabel();
        panelAbajo = new javax.swing.JPanel();
        PanelTareas = new javax.swing.JPanel();
        lblTareas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTareas = new javax.swing.JList<>();
        panelFamiliasPostuladas = new javax.swing.JPanel();
        lblFamilias = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaFamilias = new javax.swing.JList<>();
        panelBotones = new javax.swing.JPanel();
        btnRegistrarTarea = new javax.swing.JButton();
        btnVerHistorialMedico = new javax.swing.JButton();
        btnPostular = new javax.swing.JButton();
        btnRevisarPostulacion = new javax.swing.JButton();
        btnVisitas = new javax.swing.JButton();

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
            .addGap(0, 1598, Short.MAX_VALUE)
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
            .addGap(0, 1598, Short.MAX_VALUE)
        );

        getContentPane().add(panelRellenoIzq, java.awt.BorderLayout.LINE_START);

        panelCentral.setLayout(new java.awt.GridLayout(2, 2, 15, 0));

        panelArriba.setMinimumSize(new java.awt.Dimension(450, 450));
        panelArriba.setPreferredSize(new java.awt.Dimension(450, 450));
        panelArriba.setLayout(new java.awt.GridLayout(1, 2, 25, 0));

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblFoto.setMaximumSize(new java.awt.Dimension(1000, 1000));
        lblFoto.setMinimumSize(new java.awt.Dimension(400, 400));
        lblFoto.setPreferredSize(new java.awt.Dimension(400, 400));
        panelFoto.add(lblFoto);

        panelArriba.add(panelFoto);

        panelInfo.setMinimumSize(new java.awt.Dimension(450, 450));
        panelInfo.setPreferredSize(new java.awt.Dimension(200, 450));
        panelInfo.setLayout(new java.awt.GridLayout(2, 0));

        panelTexto.setLayout(new java.awt.GridLayout(2, 0));

        lblZona.setText("Zona");
        panelTexto.add(lblZona);

        lblEstado.setText("Estado");
        panelTexto.add(lblEstado);

        panelInfo.add(panelTexto);

        panelQR.setAlignmentX(0.0F);
        panelQR.setAlignmentY(0.0F);
        panelQR.setLayout(new java.awt.GridLayout(1, 0));

        lblQR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblQR.setMaximumSize(new java.awt.Dimension(1000, 1000));
        lblQR.setMinimumSize(new java.awt.Dimension(200, 500));
        lblQR.setPreferredSize(new java.awt.Dimension(200, 500));
        panelQR.add(lblQR);

        panelInfo.add(panelQR);

        panelArriba.add(panelInfo);

        panelCentral.add(panelArriba);

        panelAbajo.setLayout(new java.awt.GridLayout(1, 2, 15, 0));

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

        panelAbajo.add(PanelTareas);

        panelFamiliasPostuladas.setLayout(new java.awt.GridLayout(2, 2));

        lblFamilias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFamilias.setText("Familias Postuladas");
        panelFamiliasPostuladas.add(lblFamilias);

        listaFamilias.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaFamilias.setMaximumSize(new java.awt.Dimension(100, 250));
        listaFamilias.setMinimumSize(new java.awt.Dimension(45, 150));
        listaFamilias.setPreferredSize(new java.awt.Dimension(45, 150));
        jScrollPane2.setViewportView(listaFamilias);

        panelFamiliasPostuladas.add(jScrollPane2);

        panelAbajo.add(panelFamiliasPostuladas);

        panelCentral.add(panelAbajo);

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

        btnPostular.setText("Postularse para adopción");
        btnPostular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostularActionPerformed(evt);
            }
        });
        panelBotones.add(btnPostular);

        btnRevisarPostulacion.setText("Revisar Postulacion");
        panelBotones.add(btnRevisarPostulacion);

        btnVisitas.setText("Gestionar Visitas");
        panelBotones.add(btnVisitas);

        getContentPane().add(panelBotones, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarTareaActionPerformed
                
    }//GEN-LAST:event_btnRegistrarTareaActionPerformed

    private void btnPostularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPostularActionPerformed

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
    private javax.swing.JButton btnPostular;
    private javax.swing.JButton btnRegistrarTarea;
    private javax.swing.JButton btnRevisarPostulacion;
    private javax.swing.JButton btnVerHistorialMedico;
    private javax.swing.JButton btnVisitas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFamilias;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblQR;
    private javax.swing.JLabel lblTareas;
    private javax.swing.JLabel lblZona;
    private javax.swing.JList<String> listaFamilias;
    private javax.swing.JList<String> listaTareas;
    private javax.swing.JPanel panelAbajo;
    private javax.swing.JPanel panelArriba;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelFamiliasPostuladas;
    private javax.swing.JPanel panelFoto;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelNorth;
    private javax.swing.JPanel panelQR;
    private javax.swing.JPanel panelRellenoDerecha;
    private javax.swing.JPanel panelRellenoIzq;
    private javax.swing.JPanel panelTexto;
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

    public JButton getBtnRevisarPostulacion() {
        return btnRevisarPostulacion;
    }

    public JButton getBtnVisitas() {
        return btnVisitas;
    }

    public JList<String> getListaFamilias() {
        return listaFamilias;
    }
    
    public int getIndiceFamiliaSeleccionado() {
        return listaFamilias.getSelectedIndex();
    }    
        
    public JButton getBtnRegistrarTarea(){
        return btnRegistrarTarea;
    }

    public JButton getBtnPostular() {
        return btnPostular;
    }

    public JButton getBtnVerHistorialMedico() {
        return btnVerHistorialMedico;
    }

    public JLabel getLblFoto() {
        return lblFoto;
    }

    public JLabel getLblQR() {
        return lblQR;
    }
}


