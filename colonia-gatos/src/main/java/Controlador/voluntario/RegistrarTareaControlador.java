/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.voluntario;

import Controlador.zona.ZonaControlador;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Gato;
import modelo.Tarea;
import modelo.TipoTarea;
import modelo.Voluntario;
import persistencia.ControladoraPersistencia;
import vista.gato.VentanaRegistrarTarea;
import vista.zona.VentanaZona;

/**
 *
 * @author ms_ma
 */
public class RegistrarTareaControlador {
    private VentanaRegistrarTarea vista;
    private Gato gato;
    private Voluntario voluntario;
    private ControladoraPersistencia controlPersis;

    List<TipoTarea> tipos = Arrays.asList(TipoTarea.values());
    
    public RegistrarTareaControlador(VentanaRegistrarTarea vista, Gato gato, Voluntario voluntario, ControladoraPersistencia controlPersis) {
        this.vista = vista;
        this.gato = gato;
        this.voluntario = voluntario;
        this.controlPersis = controlPersis;
        
        vista.cargarTiposTarea(tipos);
        
        this.vista.setLblNombreVoluntario(voluntario.getNombre());
        
        this.vista.cargarZona(controlPersis.traerZonas());
        
        this.vista.getBtnAgregarZona().addActionListener(e -> agregarZona(controlPersis));
        
        this.vista.getBtnGuardar().addActionListener(e -> guardarTarea());
        
    }
    
    private void agregarZona(ControladoraPersistencia controlPersis){
        VentanaZona vistaZona = new VentanaZona(null, true);
        ZonaControlador zonaCont = new ZonaControlador(vistaZona, this.voluntario, controlPersis);
        vista.cargarTiposTarea(tipos);
        vista.cargarZona(controlPersis.traerZonas());
        
        vistaZona.setLocationRelativeTo(vista);
        vistaZona.setVisible(true);
        this.vista.cargarZona(controlPersis.traerZonas());
    }
    
    private void guardarTarea() {
        
        try {
            //Crear controladora
            ControladoraPersistencia control = new ControladoraPersistencia();

            // Obtener datos desde la vista
            String tipoTarea = vista.getComboTipoTarea().getSelectedItem().toString();
            String zona = vista.getComboZona().getSelectedItem().toString();
            String observaciones = vista.getTxtObservaciones().getText();
            String nombreVoluntario = vista.getLblNombreVoluntario().getText();

            // 
            Voluntario volun = control.buscarVoluntarioPorNombre(nombreVoluntario);

            // También necesitás el michi seleccionado (ajustá según tu modelo)
            Gato michi = this.gato; // o control.buscarMichiPorId(...)

            LocalDateTime ahora = LocalDateTime.now();
            Date fecha = java.sql.Date.valueOf(ahora.toLocalDate());
            Date hora = java.sql.Time.valueOf(ahora.toLocalTime());

            // Crear la tarea            
            
            Tarea tarea = new Tarea();
            
            tarea.setTipoTarea(TipoTarea.valueOf(tipoTarea.toUpperCase().replace(" ", "_")));
            tarea.setFecha(fecha);
            tarea.setHora(hora);
            tarea.setUbicacion(zona);
            tarea.setObservaciones(observaciones);
            tarea.setVolun(volun);
            tarea.setMichi(michi);
            

            // Guardar en BD
            control.crearTarea(tarea);

            // 6️⃣ Feedback al usuario
            JOptionPane.showMessageDialog(vista, "Tarea guardada correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista, "Error al guardar la tarea: " + e.getMessage());
        }
        
    }
    
}
