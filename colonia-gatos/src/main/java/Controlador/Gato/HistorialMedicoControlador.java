package Controlador.Gato;

import java.util.List;
import javax.swing.JOptionPane;
import modelo.Gato;
import modelo.HistorialMedico;
import modelo.RegistroMedico;
import modelo.Veterinario;
import persistencia.ControladoraPersistencia;
import vista.gato.VentanaAgregarRegistroMedico;
import vista.gato.VentanaHistorialMedico;


public class HistorialMedicoControlador {
    
    private VentanaHistorialMedico vista;
    private Gato gato;
    private Veterinario veterinario;
    private ControladoraPersistencia controlPersis;
    private PerfilGatoControlador perfilControlador;
    private List<RegistroMedico> registros;

    public HistorialMedicoControlador(VentanaHistorialMedico vista, Gato gato, Veterinario veterinario, ControladoraPersistencia controlPersis, PerfilGatoControlador perfilControlador) {
        this.vista = vista;
        this.gato = gato;
        this.veterinario = veterinario;
        this.controlPersis = controlPersis;
        this.perfilControlador = perfilControlador;
        
        mostrarDatos();
        configurarListeners();
    }
    
    private void configurarListeners(){
        vista.getBtnVerRegistro().addActionListener(e -> verRegistroSeleccionado());
        vista.getBtnAgregarRegistro().addActionListener(e -> abrirVentanaAgregarRegistroMedico());
        vista.getBtnCertificado().addActionListener(e -> emitirCertificado());
    }
    
    private void emitirCertificado() {

        // Confirmación inicial
        int opcion = JOptionPane.showConfirmDialog(
                vista,
                "¿Emitir certificado de adopción?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion != JOptionPane.YES_OPTION) return;

        // Mostrar mensaje final
        JOptionPane.showMessageDialog(
                vista,
                "El gato " + gato.getNombre() + " está apto para adopción.",
                "Certificado emitido",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Cambiar estado
        Gato gatoBD = controlPersis.traerGatoPorId(gato.getId_gato());  
        gatoBD.setAptoParaAdopcion(true);
        
        gatoBD.getTareas().size();

        try {
            controlPersis.actualizarGato(gatoBD);
            perfilControlador.setGato(controlPersis.traerGatoPorId(gato.getId_gato()));
            perfilControlador.mostrarDatos();
            System.out.println("Gato marcado apto para adopción");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    vista,
                    "Error al actualizar el estado del gato.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            ex.printStackTrace();
        }
    }

    
    private void abrirVentanaAgregarRegistroMedico() {
        VentanaAgregarRegistroMedico dialog = new VentanaAgregarRegistroMedico(null, true);

        new AgregarRegistroMedicoControlador(dialog, gato.getHistorial(), controlPersis, veterinario);


        dialog.setLocationRelativeTo(vista);
        dialog.setVisible(true);

        // Al cerrar, refrescás la lista de registros
        mostrarDatos();
    }

    
    public void mostrarDatos() {
        // 1. estado del gato
        vista.setEstado("Estado de Salud: " + gato.getEstadoSalud());

        if (gato.getHistorial() != null) { //esto solo por los gatos de prueba viejos que los cree sin historial
            registros = controlPersis.traerRegistros(gato.getHistorial());
        }else {
            registros = List.of(); // para gatos viejos sin historial
        }
        
            if (registros == null) { // doble seguro
                registros = List.of();
            }
        // 3. cargar lista
            List<String> items = registros.stream()
                    .map(r -> r.getFecha() + " - " + r.getTipo() + " - " + r.getDescripcion())
                    .toList();

            vista.cargarListaRegistros(items);

            // Guardás la lista en el controlador para abrir el registro exacto cuando el usuario seleccione uno
            this.registros = registros;
    }
    
    private void verRegistroSeleccionado() {
        int index = vista.getListaRegistros().getSelectedIndex();
        if (index < 0) {
            JOptionPane.showMessageDialog(vista, "Seleccione un registro primero");
            return;
        }

        RegistroMedico reg = registros.get(index);

        // Mostrar en un dialogo simple usando su toString
        JOptionPane.showMessageDialog(
                vista,
                reg.toString(),
                "Detalle del Registro Médico",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


}
