package Controlador.zona;

import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Administrador;
import modelo.Usuario;
import modelo.Zona;
import persistencia.ControladoraPersistencia;
import vista.zona.VentanaZona;

public class ZonaControlador {
    private VentanaZona vista;
    private Usuario usuario;
    private List<Zona> zonas;
    private ControladoraPersistencia controlPersis;

    public ZonaControlador(VentanaZona vista, Usuario usuario, ControladoraPersistencia controlPersis) {
        this.vista = vista;
        this.usuario = usuario;
        this.controlPersis = controlPersis;
        
        cargarZonas();
        configurarEventos();
        
        if (!(usuario instanceof Administrador)) {
            vista.getBtnEliminar().setVisible(false);
        }
    }

    private void configurarEventos(){
        this.vista.getBtnAgregar().addActionListener(e -> guardarZona());
        vista.getBtnEliminar().addActionListener(e -> eliminarZona());
    }
    
    private void cargarZonas() {
        zonas = controlPersis.traerZonas();
        vista.cargarListaZonas(
            zonas.stream().map(Zona::toString).toList()
        );
    }
    
    private void eliminarZona() {
        String seleccionada = vista.getListaZonas().getSelectedValue();
        if (seleccionada == null) {
            JOptionPane.showMessageDialog(vista, "Seleccioná una zona.");
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(
                vista,
                "¿Eliminar la zona \"" + seleccionada + "\"?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );
        if (opcion != JOptionPane.YES_OPTION) return;

        Zona zona = controlPersis.buscarZonaPorNombre(seleccionada);
        if (zona == null) {
            JOptionPane.showMessageDialog(vista, "La zona no existe en la BD.");
            return;
        }

        try {
            controlPersis.eliminarZona(zona);
            cargarZonas();

        } catch (RuntimeException ex) {
            if ("NO_SE_PUEDE_ELIMINAR_ZONA_REFERENCIADA".equals(ex.getMessage())) {
                JOptionPane.showMessageDialog(
                        vista,
                        "No se puede eliminar la zona porque hay gatos asignados.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(vista, "Error inesperado.");
            }
        }
    }


    
    private void guardarZona(){
        
        try {
            
            String nombre = vista.getTxtNombre().getText().trim();
            
            if(nombre.isEmpty()){
                JOptionPane.showMessageDialog(vista, "El nombre no puede estar vacío.");
                return;
            }
            Zona zona = new Zona();
            zona.setNombre(nombre);
            
            controlPersis.crearZona(zona);
            this.vista.dispose();
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista, "Error al guardar la tarea: " + e.getMessage());
        }
    }
}
