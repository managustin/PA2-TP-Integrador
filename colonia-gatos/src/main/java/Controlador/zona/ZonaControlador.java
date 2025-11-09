package Controlador.zona;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.Zona;
import persistencia.ControladoraPersistencia;
import vista.zona.VentanaZona;

public class ZonaControlador {
    private VentanaZona vista;
    private Usuario usuario;

    public ZonaControlador(VentanaZona vista, Usuario usuario) {
        this.vista = vista;
        this.usuario = usuario;
    
        configurarEventos();
    }

    private void configurarEventos(){
        this.vista.getBtnGuardar().addActionListener(e -> guardarZona());
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
            
            ControladoraPersistencia controlPersis = new ControladoraPersistencia();
            
            controlPersis.crearZona(zona);
            this.vista.dispose();
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista, "Error al guardar la tarea: " + e.getMessage());
        }
    }
}
