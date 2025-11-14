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
import javax.swing.JList;
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
        panelGatosDisponibles = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        listaGatosNoAdoptados = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        panelGatosAdoptados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaGatosAdoptados = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
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
        panelGatos.setLayout(new java.awt.GridLayout(1, 2, 50, 0));

        panelGatosDisponibles.setLayout(new java.awt.BorderLayout(0, 10));

        listaGatosNoAdoptados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaGatosNoAdoptados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane.setViewportView(listaGatosNoAdoptados);

        panelGatosDisponibles.add(jScrollPane, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Gatos No adoptados");
        panelGatosDisponibles.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        panelGatos.add(panelGatosDisponibles);

        panelGatosAdoptados.setLayout(new java.awt.BorderLayout(0, 10));

        listaGatosAdoptados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaGatosAdoptados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listaGatosAdoptados);

        panelGatosAdoptados.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Gatos adoptados");
        panelGatosAdoptados.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        panelGatos.add(panelGatosAdoptados);

        add(panelGatos, java.awt.BorderLayout.CENTER);

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

        add(PanelBotones, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerGatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerGatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerGatoActionPerformed

    private void btnRegistrarGatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarGatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarGatoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btnRegistrarGato;
    private javax.swing.JButton btnVerGato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaGatosAdoptados;
    private javax.swing.JList<String> listaGatosNoAdoptados;
    private javax.swing.JPanel panelGatos;
    private javax.swing.JPanel panelGatosAdoptados;
    private javax.swing.JPanel panelGatosDisponibles;
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
    
    public void cargarListaGatosNoAdoptados(List<String> items) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String s : items) model.addElement(s);
        listaGatosNoAdoptados.setModel(model); // setModel reemplaza el contenido visible de la JList
    }
    public void cargarListaGatosAdoptados(List<String> items) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String s : items) model.addElement(s);
        listaGatosAdoptados.setModel(model); // setModel reemplaza el contenido visible de la JList
    }

    public JButton getBtnRegistrarGato() {
        return btnRegistrarGato;
    }

    public JList<String> getListaGatosAdoptados() {
        return listaGatosAdoptados;
    }

    public JList<String> getListaGatosNoAdoptados() {
        return listaGatosNoAdoptados;
    }
    
    

}
