package Controlador;

import vista.VentanaInicioSesion;
import vista.VentanaPrincipal;

public class VentanaPrincipalControlador {
    
    private final VentanaPrincipal vista;
    
    public VentanaPrincipalControlador(VentanaPrincipal vista){
        this.vista = vista;
        
        this.vista.getItemLogout().addActionListener(e -> cerrarSesion());
    }
    
    private void cerrarSesion(){
        vista.dispose();
        
        VentanaInicioSesion login = new VentanaInicioSesion();
        new LoginControlador(login);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
}
