/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.administrador.AdministradorControlador;
import Controlador.familia.FamiliaControlador;
import Controlador.veterinario.VeterinarioControlador;
import Controlador.voluntario.VoluntarioControlador;
import java.util.List;
import modelo.Administrador;
import modelo.FamiliaAdoptante;
import modelo.Usuario;
import modelo.Veterinario;
import modelo.Voluntario;
import persistencia.ControladoraPersistencia;
import persistencia.UsuarioJpaController;
import vista.VentanaInicioSesion;
import vista.VentanaPrincipal;
import vista.VentanaRegistro;
import vista.administrador.PanelPrincipalAdministrador;
import vista.familia.PanelPrincipalFamiliaAdoptante;
import vista.veterinario.PanelPrincipalVeterinario;
import vista.voluntario.PanelPrincipalVoluntario;

/**
 *
 * @author ms_ma
 */
public class LoginControlador{
    
    private VentanaInicioSesion vista;
    private ControladoraPersistencia controlPersis;

    public LoginControlador(VentanaInicioSesion vista) {
        this.vista = vista;
        this.vista.setLoginControlador(this);
        this.vista.setLocationRelativeTo(null);
        this.controlPersis = new ControladoraPersistencia();
        configurarListeners();
    }
    
    private void configurarListeners(){
         vista.getBtnIngresar().addActionListener(e -> procesarLogin());
         vista.getBtnRegistrarse().addActionListener(e -> abrirVentanaRegistrarse());
         vista.getBtnRestablecerPass().addActionListener(e -> procesarLogin());
    }
    
    private void abrirVentanaRegistrarse() {

        // Crear vista de registro
        VentanaRegistro vr = new VentanaRegistro();

        // Crear controlador de registro
        new RegistroControlador(vr, controlPersis, "FAMILIA", null);  

        // Mostrar la ventana de registro
        vr.setLocationRelativeTo(vista); // centrar respecto al login
        vr.setVisible(true);

        // Cerrar la ventana de login
        vista.dispose();
    }
    
    public void procesarLogin() {
            System.out.println("se ejecuta el login");
            // obtenemos datos de la vista
            String email = vista.getEmail();
            String password = vista.getPassword();
            
            Usuario usuario = controlPersis.validarLogin(email, password);

            if(usuario!=null){
                vista.dispose();    // Cierra la ventana login
                abrirVentanaPrincipal(usuario);
            }else{
                javax.swing.JOptionPane.showMessageDialog(vista, "Credenciales incorrectas o el usuario no existe.");
            }
    }

    private void abrirVentanaPrincipal(Usuario usuario){
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        new VentanaPrincipalControlador(ventanaPrincipal);
        if(usuario instanceof FamiliaAdoptante){
            PanelPrincipalFamiliaAdoptante panelFamilia = new PanelPrincipalFamiliaAdoptante();
            new FamiliaControlador(panelFamilia, (FamiliaAdoptante) usuario, controlPersis);
            ventanaPrincipal.setPanelPrincipal(panelFamilia);
            System.out.println("Panel familia seteado");
        }
        
        if(usuario instanceof Voluntario){
            PanelPrincipalVoluntario panelVol = new PanelPrincipalVoluntario();
            new VoluntarioControlador(panelVol, (Voluntario) usuario, controlPersis);
            ventanaPrincipal.setPanelPrincipal(panelVol);
        }
        
        if(usuario instanceof Veterinario){
            PanelPrincipalVeterinario panelVet = new PanelPrincipalVeterinario();
            new VeterinarioControlador(panelVet, (Veterinario) usuario, controlPersis);
            ventanaPrincipal.setPanelPrincipal(panelVet);
        }
        
        if(usuario instanceof Administrador){
            PanelPrincipalAdministrador panelAdmin = new PanelPrincipalAdministrador();
            new AdministradorControlador(panelAdmin, (Administrador) usuario, controlPersis);
            ventanaPrincipal.setPanelPrincipal(panelAdmin);
        }
        
        ventanaPrincipal.setVisible(true);
    }
}
