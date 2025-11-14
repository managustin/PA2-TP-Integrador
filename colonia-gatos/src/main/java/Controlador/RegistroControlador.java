/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import javax.swing.JOptionPane;
import modelo.FamiliaAdoptante;
import modelo.Usuario;
import modelo.Veterinario;
import modelo.Voluntario;
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
    private final String tipoUsuario; // "FAMILIA" | "VOLUNTARIO" | "VETERINARIO"
    private Runnable callback;


    public RegistroControlador(VentanaRegistro vista, ControladoraPersistencia controlPersis, String tipoUsuario, Runnable callback) {
        this.vista = vista;
        this.controlPersis = controlPersis;
        this.tipoUsuario = tipoUsuario;
        this.callback = callback;
        configurarVistaSegunTipo();
        
        configurarListeners();
    }
    
    private void configurarListeners(){
        vista.getBtnRegistrarse().addActionListener(e -> procesarRegistrarse());
        vista.getBtnVolver().addActionListener(e -> volver());
    }
    
    private void configurarVistaSegunTipo() {
        if (tipoUsuario.equals("FAMILIA")) {
            vista.getPanelDireccion().setVisible(true);
        } else {
            vista.getBtnVolver().setVisible(false);
            vista.getPanelDireccion().setVisible(false);
        }
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

            // 1) Crear instancia correcta
            Usuario nuevo;
            switch (tipoUsuario) {
                case "FAMILIA" -> nuevo = new FamiliaAdoptante();
                case "VOLUNTARIO" -> nuevo = new Voluntario();
                case "VETERINARIO" -> nuevo = new Veterinario();
                default -> throw new IllegalArgumentException("Tipo desconocido: " + tipoUsuario);
            }

            // 2) Setear campos comunes
            nuevo.setNombre(nombre);
            nuevo.setEmail(email);
            nuevo.setPassword(password);
            nuevo.setTelefono(telefono);

            // 3) Setear campos específicos
            if (nuevo instanceof FamiliaAdoptante fa) {
                fa.setDireccion(vista.getTxtDireccion().getText().trim());
            }

            if (nuevo instanceof Voluntario vo) {
                vo.setZona(null);  // o lo que corresponda
            }

            // 4) Persistir según tipo  
            switch (tipoUsuario) {
                case "FAMILIA" -> controlPersis.crearFamiliaAdoptante((FamiliaAdoptante) nuevo);
                case "VOLUNTARIO" -> controlPersis.crearVoluntario((Voluntario) nuevo);
                case "VETERINARIO" -> controlPersis.crearVeterinario((Veterinario) nuevo);
            }

            // 5) Mostrar mensaje
            JOptionPane.showMessageDialog(vista, "Registro exitoso.", "OK", JOptionPane.INFORMATION_MESSAGE);

            callback.run();  // refresca listas en AdminControlador

            // 6) Decidir cierre
            if (tipoUsuario.equals("FAMILIA")) {
                volver(); // familia vuelve al login
            } else {
                vista.dispose(); // admin sigue en la pantalla actual
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error al registrar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
   
}
