/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.voluntario;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Gato;
import modelo.Voluntario;
import persistencia.ControladoraPersistencia;
import vista.gato.VentanaPerfilGato;
import vista.voluntario.PanelPrincipalVoluntario;

/**
 *
 * @author ms_ma
 */
public class VoluntarioControlador {
    private PanelPrincipalVoluntario vista;
    private Voluntario voluntario;
    private ControladoraPersistencia controlPersistencia;
    private List<Gato> gatos; // lista real de objetos

    public VoluntarioControlador(PanelPrincipalVoluntario vista, Voluntario voluntario){
        this.vista = vista;
        this.voluntario = voluntario;
        this.controlPersistencia = new ControladoraPersistencia();

        cargarGatosDesdeBD();
        configurarListeners();
    }
    
    private void cargarGatosDesdeBD(){
        gatos = controlPersistencia.traerGatos(); // trae todos los gatos
        // Convertir a lista de strings (el toString de Gato debe estar bueno, ej "id - nombre")
        List<String> items = gatos.stream()
                                 .map(g -> g.toString())
                                 .toList();
        vista.cargarListaGatosComoStrings(items);
        vista.getBtnVerGato().setEnabled(false); // deshabilita botón hasta selección
    }

    private void configurarListeners(){
        // Habilitar botón cuando haya selección
        vista.getListaGatos().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // ignore adjusting events
                if (!e.getValueIsAdjusting()) {
                    int idx = vista.getIndiceGatoSeleccionado();
                    vista.getBtnVerGato().setEnabled(idx >= 0);
                }
            }
        });

        // Listener del botón 
        vista.getBtnVerGato().addActionListener(e -> abrirPerfilGatoSeleccionado());
    }
    
    private void abrirPerfilGatoSeleccionado(){
        int idx = vista.getIndiceGatoSeleccionado();
        if (idx < 0) {
            JOptionPane.showMessageDialog(vista, "Seleccioná un gato.");
            return;
        }

        Gato seleccionado = gatos.get(idx);

        // VentanaPerfilGato debe ser un JDialog modal con constructor que reciba Gato
        VentanaPerfilGato dialog = new VentanaPerfilGato(null, true, seleccionado);

        new PerfilGatoControlador(dialog, seleccionado, voluntario);

        dialog.setLocationRelativeTo(vista);
        dialog.setVisible(true);
        // cuando se cierre el dialog, si hiciste cambios podrías recargar:
        // cargarGatosDesdeBD(); // opcional si se modificó algo
    }
}
