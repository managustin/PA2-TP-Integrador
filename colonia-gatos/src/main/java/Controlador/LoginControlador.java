/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.familia.FamiliaControlador;
import Controlador.voluntario.VoluntarioControlador;
import java.util.List;
import modelo.FamiliaAdoptante;
import modelo.Usuario;
import modelo.Voluntario;
import persistencia.ControladoraPersistencia;
import persistencia.UsuarioJpaController;
import vista.VentanaInicioSesion;
import vista.VentanaPrincipal;
import vista.familia.PanelPrincipalFamiliaAdoptante;
import vista.voluntario.PanelPrincipalVoluntario;

/**
 *
 * @author ms_ma
 */
public class LoginControlador{
    
    private VentanaInicioSesion vista;

    public LoginControlador(VentanaInicioSesion vista) {
        this.vista = vista;
        this.vista.setLoginControlador(this);
    }
    
    public void procesarLogin() {
            System.out.println("se ejecuta el login");
            // obtenemos datos de la vista
            String email = vista.getEmail();
            String password = vista.getPassword();
            
            Usuario usuario = validarUsuario(email, password);

            if(usuario!=null){
                vista.dispose();    // Cierra la ventana login
                abrirVentanaPrincipal(usuario);
            }else{
                javax.swing.JOptionPane.showMessageDialog(vista, "Credenciales incorrectas.");
            }
    }
        
        //  Simula la validación con usuario dummy
    private Usuario validarUsuarioDummy(String email, String password){
        if(email.equals("a") && password.equals("1")){
            return new FamiliaAdoptante(); //String nom, String email, String password, String direccion
        }
        return null;
    }
    
    private Usuario validarUsuario(String email, String password){
        UsuarioJpaController usuarioJpa = new UsuarioJpaController();
        List<Usuario> usuarios = usuarioJpa.findUsuarioEntities();

        for(Usuario u : usuarios){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                return u; // puede ser Voluntario, FamiliaAdoptante, etc.
            }
        }
        return null;
    }


    private void abrirVentanaPrincipal(Usuario usuario){
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();

        if(usuario instanceof FamiliaAdoptante){
            PanelPrincipalFamiliaAdoptante panelFamilia = new PanelPrincipalFamiliaAdoptante();
            new FamiliaControlador(panelFamilia, (FamiliaAdoptante) usuario);
            ventanaPrincipal.setPanelPrincipal(panelFamilia);
            System.out.println("Panel familia seteado");
        }
        
        if(usuario instanceof Voluntario){
            PanelPrincipalVoluntario panelVol = new PanelPrincipalVoluntario();
            new VoluntarioControlador(panelVol, (Voluntario) usuario);
            ventanaPrincipal.setPanelPrincipal(panelVol);
        }

        ventanaPrincipal.setVisible(true);
    }
}
