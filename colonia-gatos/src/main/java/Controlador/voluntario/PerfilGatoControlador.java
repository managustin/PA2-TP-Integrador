/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.voluntario;

import java.util.List;
import javax.swing.ImageIcon;
import modelo.Gato;
import modelo.Tarea;
import modelo.Voluntario;
import persistencia.ControladoraPersistencia;
import vista.gato.VentanaPerfilGato;
import vista.gato.VentanaRegistrarTarea;

/**
 *
 * @author ms_ma
 */
public class PerfilGatoControlador {
    private VentanaPerfilGato vista;
    private Gato gato;
    private Voluntario voluntario;

    public PerfilGatoControlador(VentanaPerfilGato vista, Gato gato, Voluntario voluntario) {
        this.vista = vista;
        this.gato = gato;
        this.voluntario = voluntario;

        mostrarDatos();
        configurarEventos();
    }

    private void mostrarDatos() {
        vista.setNombreGato(gato.getNombre());
        vista.setZona(gato.getZona().getNombre());
        vista.setEstado("Estado de Salud: " + gato.getEstadoSalud());

        // FOTO (si existe)
        if (gato.getFoto() != null) {
            System.out.println("Bytes foto: " + (gato.getFoto() == null ? "null" : gato.getFoto().length));
            vista.setFoto(new ImageIcon(gato.getFoto()));
        }
        
        // --- TAREAS ---
        ControladoraPersistencia control = new ControladoraPersistencia();
        List<Tarea> tareas = control.traerTareasPorGato(gato.getId_gato());
        vista.cargarTareas(tareas);
    }
    
    private void configurarEventos() {
        vista.getBtnRegistrarTarea().addActionListener(e -> abrirVentanaRegistrarTarea());
    }

    private void abrirVentanaRegistrarTarea() {
        VentanaRegistrarTarea dialog = new VentanaRegistrarTarea(
            vista,  // parent
            true   // modal
        );
        new RegistrarTareaControlador(dialog, gato, voluntario);
        dialog.setLocationRelativeTo(vista);
        dialog.setVisible(true);

        // cuando se cierre el dialog, recargar lista de tareas:
        ControladoraPersistencia control = new ControladoraPersistencia();
        List<Tarea> tareas = control.traerTareasPorGato(gato.getId_gato());
        vista.cargarTareas(tareas);
    }

}
