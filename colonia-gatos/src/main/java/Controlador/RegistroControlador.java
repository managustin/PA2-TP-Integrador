/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import javax.swing.JOptionPane;
import modelo.FamiliaAdoptante;
import modelo.Usuario;
import persistencia.ControladoraPersistencia;
import vista.VentanaInicioSesion;
import vista.VentanaRegistro;

/**
 *
 * @author ms_ma
 */
public class RegistroControlador {
    private VentanaRegistro vista;
    private ControladoraPersistencia controlPersis;

    public RegistroControlador(VentanaRegistro vista) {
        this.vista = vista;
        this.controlPersis = new ControladoraPersistencia();
        
        configurarListeners();
    }
    
    private void configurarListeners(){
        vista.getBtnRegistrarse().addActionListener(e -> procesarRegistrarse());
        vista.getBtnVolver().addActionListener(e -> volver());
    }
    
    private void volver() {

        // Cerrar la ventana actual
        vista.dispose();

        // Crear ventana de inicio de sesión
        VentanaInicioSesion vInicio = new VentanaInicioSesion();

        // Crear su controlador
        new LoginControlador(vInicio);

        // Mostrar
        vInicio.setLocationRelativeTo(null);
        vInicio.setVisible(true);
    }
    
    
    public void procesarRegistrarse(){
        try {
            String nombre = vista.getTxtNombre().getText().trim();
            String email = vista.getTxtEmail().getText().trim();
            String password = vista.getTxtPassword().getText().trim();
            String telefono = vista.getTxtTelefono().getText().trim();
            String direccion = vista.getTxtDireccion().getText().trim();

            if (nombre.isEmpty() || email.isEmpty() || password.isEmpty()
                    || telefono.isEmpty() || direccion.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!email.contains("@")) {
                JOptionPane.showMessageDialog(vista, "El email no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!telefono.matches("\\+?\\d+")) {
                JOptionPane.showMessageDialog(vista, "El teléfono solo puede contener números (y opcionalmente +).", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear y poblar la entidad
            FamiliaAdoptante familia = new FamiliaAdoptante();
            familia.setNombre(nombre);
            familia.setEmail(email);
            familia.setPassword(password);
            familia.setTelefono(telefono);
            familia.setDireccion(direccion);

            // Persistir usando la ControladoraPersistencia
            controlPersis.crearFamiliaAdoptante(familia);
            System.out.println("GUARDADO OK");

            JOptionPane.showMessageDialog(vista, "Registro exitoso. Ya puede iniciar sesión.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            volver();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error al registrar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
   
}
