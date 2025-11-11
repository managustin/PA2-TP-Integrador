package Controlador.Gato;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.HistorialMedico;
import modelo.RegistroMedico;
import modelo.TipoRegistroMedico;
import modelo.Veterinario;
import persistencia.ControladoraPersistencia;
import vista.gato.VentanaAgregarRegistroMedico;

public class AgregarRegistroMedicoControlador {

    private final VentanaAgregarRegistroMedico vista;
    private final HistorialMedico historial;
    private final ControladoraPersistencia controlPersis;
    private final Veterinario veterinario;

    public AgregarRegistroMedicoControlador(VentanaAgregarRegistroMedico vista,
                                            HistorialMedico historial,
                                            ControladoraPersistencia controlPersis, Veterinario veterinario) {
        this.vista = vista;
        this.historial = historial;
        this.controlPersis = controlPersis;
        this.veterinario = veterinario;

        cargarComboTipos();
        agregarListeners();
    }


    private void cargarComboTipos() {
        for (TipoRegistroMedico t : TipoRegistroMedico.values()) {
            vista.getComboTipo().addItem(t); // El combo debe ser <TipoRegistroMedico>
        }
    }

    private void agregarListeners() {
        vista.getBtnGuardar().addActionListener(e -> guardarRegistro());
    }

    private void guardarRegistro() {
        TipoRegistroMedico tipo = (TipoRegistroMedico) vista.getComboTipo().getSelectedItem();
        String descripcion = vista.getTxtDescripcion().getText().trim();
        String archivo = vista.getTxtArchivoEstudio().getText().trim();

        if (tipo == null || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Complete los campos obligatorios.");
            return;
        }

        // Crear nuevo registro
        RegistroMedico nuevo = new RegistroMedico();
        nuevo.setTipo(tipo);
        nuevo.setDescripcion(descripcion);
        nuevo.setArchivoEstudio(archivo);
        nuevo.setFecha(new Date());
        nuevo.setHistorial(historial);
        nuevo.setVet(veterinario);

        // Persistencia
        controlPersis.crearRegistroMedico(nuevo);

        vista.dispose();
    }
}
