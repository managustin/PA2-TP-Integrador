/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.voluntario;

import vista.familia.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.Gato;

/**
 *
 * @author ms_ma
 */
public class PanelPrincipalVoluntario extends javax.swing.JPanel {

    public PanelPrincipalVoluntario() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNorth = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        panelRellenoIzq = new javax.swing.JPanel();
        panelRellenoDerecha = new javax.swing.JPanel();
        panelGatos = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        ListaGatos = new javax.swing.JList<>();
        PanelBotones = new javax.swing.JPanel();
        btnVerGato = new javax.swing.JButton();
        btnRegistrarGato = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(500, 600));
        setPreferredSize(new java.awt.Dimension(500, 600));
        setLayout(new java.awt.BorderLayout());

        panelNorth.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 20, 1));

        Titulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Titulo.setText("GATOS REGISTRADOS");
        panelNorth.add(Titulo);

        add(panelNorth, java.awt.BorderLayout.NORTH);

        panelRellenoIzq.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        panelRellenoIzq.setPreferredSize(new java.awt.Dimension(50, 0));

        javax.swing.GroupLayout panelRellenoIzqLayout = new javax.swing.GroupLayout(panelRellenoIzq);
        panelRellenoIzq.setLayout(panelRellenoIzqLayout);
        panelRellenoIzqLayout.setHorizontalGroup(
            panelRellenoIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRellenoIzqLayout.setVerticalGroup(
            panelRellenoIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(panelRellenoIzq, java.awt.BorderLayout.LINE_START);

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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(panelRellenoDerecha, java.awt.BorderLayout.EAST);

        panelGatos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        panelGatos.setMinimumSize(new java.awt.Dimension(500, 600));
        panelGatos.setPreferredSize(new java.awt.Dimension(500, 600));
        panelGatos.setLayout(new java.awt.BorderLayout());

        ListaGatos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane.setViewportView(ListaGatos);

        panelGatos.add(jScrollPane, java.awt.BorderLayout.CENTER);

        PanelBotones.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 30, 1));
        java.awt.GridBagLayout PanelBotonesLayout = new java.awt.GridBagLayout();
        PanelBotonesLayout.columnWeights = new double[] {2.0, 0.0};
        PanelBotones.setLayout(PanelBotonesLayout);

        btnVerGato.setText("Ver gato");
        btnVerGato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerGatoActionPerformed(evt);
            }
        });
        PanelBotones.add(btnVerGato, new java.awt.GridBagConstraints());

        btnRegistrarGato.setText("Registrar Gato");
        btnRegistrarGato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarGatoActionPerformed(evt);
            }
        });
        PanelBotones.add(btnRegistrarGato, new java.awt.GridBagConstraints());

        panelGatos.add(PanelBotones, java.awt.BorderLayout.SOUTH);

        add(panelGatos, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerGatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerGatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerGatoActionPerformed

    private void btnRegistrarGatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarGatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarGatoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListaGatos;
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btnRegistrarGato;
    private javax.swing.JButton btnVerGato;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JPanel panelGatos;
    private javax.swing.JPanel panelNorth;
    private javax.swing.JPanel panelRellenoDerecha;
    private javax.swing.JPanel panelRellenoIzq;
    // End of variables declaration//GEN-END:variables
    
    public JPanel getPanelGatos(){
        return panelGatos;
    }
    
    public JButton getBtnVerGato() {
        return btnVerGato;
    }
    
    public void cargarListaGatosComoStrings(List<String> items) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String s : items) model.addElement(s);
        ListaGatos.setModel(model); // setModel reemplaza el contenido visible de la JList
    }
    
    public int getIndiceGatoSeleccionado() {
        return ListaGatos.getSelectedIndex();
    }

    public javax.swing.JList<String> getListaGatos() {
        return ListaGatos;
    }

    public JButton getBtnRegistrarGato() {
        return btnRegistrarGato;
    }

}
