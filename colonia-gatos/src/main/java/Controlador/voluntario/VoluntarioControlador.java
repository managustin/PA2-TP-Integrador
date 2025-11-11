/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.voluntario;

import Controlador.Gato.PerfilGatoControlador;
import Controlador.Gato.GatoControlador;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Gato;
import modelo.Voluntario;
import persistencia.ControladoraPersistencia;
import vista.gato.VentanaPerfilGato;
import vista.gato.VentanaRegistrarGato;
import vista.voluntario.PanelPrincipalVoluntario;

/**
 *
 * @author ms_ma
 */
public class VoluntarioControlador {
    private PanelPrincipalVoluntario vista;
    private Voluntario voluntario;
    private ControladoraPersistencia controlPersistencia;
    private List<Gato> noAdoptados;
    private List<Gato> adoptados;


    public VoluntarioControlador(PanelPrincipalVoluntario vista, Voluntario voluntario){
        this.vista = vista;
        this.voluntario = voluntario;
        this.controlPersistencia = new ControladoraPersistencia();

        cargarGatosDesdeBD();
        configurarListeners();
    }
    
    public void cargarGatosDesdeBD() {

        List<Gato> todos = controlPersistencia.traerGatos();

        // separar adoptados vs no adoptados
        this.adoptados = todos.stream()
            .filter(g -> controlPersistencia.tieneAdopcionActiva(g))
            .toList();

        this.noAdoptados = todos.stream()
            .filter(g -> !controlPersistencia.tieneAdopcionActiva(g))
            .toList();

        // formatear strings
        List<String> stringsNoAdoptados = this.noAdoptados.stream()
            .map(g -> formatearGato(g))
            .toList();

        List<String> stringsAdoptados = this.adoptados.stream()
            .map(g -> g.toString())
            .toList();

        // enviar a la vista
        vista.cargarListaGatosNoAdoptados(stringsNoAdoptados);
        vista.cargarListaGatosAdoptados(stringsAdoptados);

        vista.getBtnVerGato().setEnabled(false);
    }

 
   private String formatearGato(Gato g) {
        boolean tienePendientes = controlPersistencia.tienePostulacionesPendientes(g);

        String base = g.toString();

        if (tienePendientes) {
            return base + "  | POSTULACIONES PARA REVISAR";
        } else {
            return base;
        }
    }


    private void configurarListeners() {

        vista.getListaGatosNoAdoptados().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {

                if (vista.getListaGatosNoAdoptados().getSelectedIndex() >= 0) {
                    // limpiar la otra lista, NO esta
                    vista.getListaGatosAdoptados().clearSelection();
                    vista.getBtnVerGato().setEnabled(true);
                }
            }
        });

        vista.getListaGatosAdoptados().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {

                if (vista.getListaGatosAdoptados().getSelectedIndex() >= 0) {
                    // limpiar la otra lista, NO esta
                    vista.getListaGatosNoAdoptados().clearSelection();
                    vista.getBtnVerGato().setEnabled(true);
                }
            }
        });

        vista.getBtnVerGato().addActionListener(e -> abrirPerfilGatoSeleccionado());
        vista.getBtnRegistrarGato().addActionListener(e -> abrirVentanaRegistrarGato());
    }

    
    private void abrirVentanaRegistrarGato() {
        VentanaRegistrarGato dialog = new VentanaRegistrarGato(null, true);

        new GatoControlador(dialog, voluntario); // si necesitás más params, pasalos acá

        dialog.setLocationRelativeTo(vista);
        dialog.setVisible(true);
        cargarGatosDesdeBD();
    }
    
    private void abrirPerfilGatoSeleccionado() {

        int idxNoAdoptados = vista.getListaGatosNoAdoptados().getSelectedIndex();
        int idxAdoptados = vista.getListaGatosAdoptados().getSelectedIndex();

        Gato seleccionado;

        if (idxNoAdoptados >= 0) {
            seleccionado = noAdoptados.get(idxNoAdoptados);
        } else {
            seleccionado = adoptados.get(idxAdoptados);
        }

        VentanaPerfilGato dialog = new VentanaPerfilGato(null, true, seleccionado);
        new PerfilGatoControlador(dialog, seleccionado, voluntario);
        dialog.setLocationRelativeTo(vista);
        dialog.setVisible(true);
        cargarGatosDesdeBD();
    }

}
