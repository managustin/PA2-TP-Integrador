/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.familia.FamiliaControlador;
import modelo.FamiliaAdoptante;
import modelo.Usuario;
import vista.VentanaInicioSesion;
import vista.VentanaPrincipal;
import vista.familia.PanelPrincipalFamiliaAdoptante;

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
        System.out.println("se ejecuta");
        // obtenemos datos de la vista
        String email = vista.getEmail();
        String password = vista.getPassword();
        
        //  Simulación de validación (por ahora sin DB)
        Usuario usuario = validarUsuarioDummy(email, password);
        
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

    private void abrirVentanaPrincipal(Usuario usuario){
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();

        if(usuario instanceof FamiliaAdoptante){
            PanelPrincipalFamiliaAdoptante panelFamilia = new PanelPrincipalFamiliaAdoptante();
            new FamiliaControlador(panelFamilia, (FamiliaAdoptante) usuario);
            ventanaPrincipal.setPanelPrincipal(panelFamilia);
            System.out.println("Panel familia seteado");
        }

        ventanaPrincipal.setVisible(true);
    }
}
