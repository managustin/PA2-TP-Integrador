package Controlador.zona;

import javax.swing.JDialog;
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
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        
        Zona zona = new Zona();
        zona.setNombre(this.vista.getTxtNombre().getText());
        controlPersis.crearZona(zona);
        this.vista.dispose();
    }
}
