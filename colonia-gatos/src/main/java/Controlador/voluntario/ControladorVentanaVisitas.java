/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.voluntario;

import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Adopcion;
import modelo.Gato;
import modelo.Visita;
import persistencia.ControladoraPersistencia;
import vista.gato.VentanaVisitas;

/**
 *
 * @author ms_ma
 */
public class ControladorVentanaVisitas {
    
    private VentanaVisitas vista;
    private Gato gato;
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public ControladorVentanaVisitas(VentanaVisitas vista, Gato gato) {
        this.vista = vista;
        this.gato = gato;
        cargarVisitas();
        configurarEventos();
        
    }
    
    private void configurarEventos() {
        // Listener para el botón "Guardar visita"
        vista.getBtnGuardar().addActionListener(e -> guardarVisita());
    }
    
    private void guardarVisita() {
        // Obtener datos ingresados por el usuario
        String observaciones = vista.getTxtObservaciones().getText();
        String resultado = vista.getTxtResultado().getText();

        if ((observaciones == null || observaciones.isBlank()) &&
            (resultado == null || resultado.isBlank())) {
            JOptionPane.showMessageDialog(vista, "Debe completar al menos un campo.");
            return;
        }

        // Crear la visita
        Visita visita = new Visita();
        Date ahora = new Date();
        visita.setFecha(ahora);
        visita.setHora(ahora);
        visita.setObservaciones(observaciones);
        visita.setResultado(resultado);

        // Asociarla a la adopción activa y al voluntario (si aplica)
        Adopcion adopcionActiva = controlPersis.traerAdopcionAceptada(gato);
        if (adopcionActiva == null) {
            JOptionPane.showMessageDialog(vista, "Este gato no tiene adopción activa.");
            return;
        }
        visita.setAdop(adopcionActiva);

        // Guardar en la base de datos
        controlPersis.crearVisita(visita);

        // Actualizar la lista de visitas
        cargarVisitas();

        // Limpiar campos
        vista.getTxtObservaciones().setText("");
        vista.getTxtResultado().setText("");

        JOptionPane.showMessageDialog(vista, "Visita registrada correctamente.");
    }

    
    private void cargarVisitas() {
        // Traer visitas desde la base de datos
        List<Visita> visitas = controlPersis.traerVisitasPorGato(gato);

        // Crear el modelo de lista
        DefaultListModel<String> model = new DefaultListModel<>();

        // Cargar las visitas en el modelo
        for (Visita v : visitas) {
            String item = "Fecha: " + v.getFecha() +
                          " | Observaciones: " + v.getObservaciones() +
                          (v.getResultado() != null && !v.getResultado().isBlank()
                            ? " | Resultado: " + v.getResultado()
                            : "");
            model.addElement(item);
        }

        // Asignar el modelo al JList
        vista.getListaVisitas().setModel(model);
    }
    
}
