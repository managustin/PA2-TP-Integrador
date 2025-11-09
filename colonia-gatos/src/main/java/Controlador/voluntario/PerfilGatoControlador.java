/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.voluntario;

import Controlador.QrGenerator;
import com.google.zxing.WriterException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.ImageIcon;
import modelo.Gato;
import modelo.Tarea;
import modelo.Voluntario;
import persistencia.ControladoraPersistencia;
import vista.gato.VentanaPerfilGato;
import vista.gato.VentanaRegistrarTarea;

/**
 *
 * @author ms_ma
 */
public class PerfilGatoControlador {
    private VentanaPerfilGato vista;
    private Gato gato;
    private Voluntario voluntario;

    public PerfilGatoControlador(VentanaPerfilGato vista, Gato gato, Voluntario voluntario) {
        this.vista = vista;
        this.gato = gato;
        this.voluntario = voluntario;

        mostrarDatos();
        configurarEventos();
    }

    private void mostrarDatos() {
        vista.setNombreGato(gato.getNombre());
        vista.setZona(gato.getZona().getNombre());
        vista.setEstado("Estado de Salud: " + gato.getEstadoSalud());

        // FOTO (si existe)
        if (gato.getFoto() != null) {

            int maxAncho = vista.getLblFoto().getWidth();
            int maxAlto = vista.getLblFoto().getHeight();

            ImageIcon icon = escalarManteniendoAspecto(gato.getFoto(), maxAncho, maxAlto);

            String contenidoQr = "GATO:" + gato.getId_gato() + ";NOMBRE:" + gato.getNombre();
            
            try {
                BufferedImage img = QrGenerator.generarQR(contenidoQr, 200, 400);
                vista.getLblQR().setIcon(new ImageIcon(img));
                vista.getLblQR().setText(""); // si antes tenía texto
            } catch (WriterException e) {
                e.printStackTrace();
                vista.getLblQR().setIcon(null);
                vista.getLblQR().setText("QR no disponible");
                // opcional: mostrar un JOptionPane.showMessageDialog(...) para avisar al usuario
            }
                
            
            vista.setFoto(icon);
        }
        
        // --- TAREAS ---
        ControladoraPersistencia control = new ControladoraPersistencia();
        List<Tarea> tareas = control.traerTareasPorGato(gato.getId_gato());
        vista.cargarTareas(tareas);
    }
    
    private void configurarEventos() {
        vista.getBtnRegistrarTarea().addActionListener(e -> abrirVentanaRegistrarTarea());
    }

    private void abrirVentanaRegistrarTarea() {
        VentanaRegistrarTarea dialog = new VentanaRegistrarTarea(
            vista,  // parent
            true   // modal
        );
        new RegistrarTareaControlador(dialog, gato, voluntario);
        dialog.setLocationRelativeTo(vista);
        dialog.setVisible(true);

        // cuando se cierre el dialog, recargar lista de tareas:
        ControladoraPersistencia control = new ControladoraPersistencia();
        List<Tarea> tareas = control.traerTareasPorGato(gato.getId_gato());
        vista.cargarTareas(tareas);
    }

    private ImageIcon escalarManteniendoAspecto(byte[] bytesImagen, int maxAncho, int maxAlto) {
        ImageIcon icon = new ImageIcon(bytesImagen);
        Image img = icon.getImage();

        int anchoOriginal = img.getWidth(null);
        int altoOriginal = img.getHeight(null);

        if (anchoOriginal <= 0 || altoOriginal <= 0) {
            return icon; // imagen corrupta
        }

        // Calcular escala manteniendo proporción
        double escalaAncho = (double) maxAncho / anchoOriginal;
        double escalaAlto = (double) maxAlto / altoOriginal;
        double escalaFinal = Math.min(escalaAncho, escalaAlto);

        int nuevoAncho = (int) (anchoOriginal * escalaFinal);
        int nuevoAlto = (int) (altoOriginal * escalaFinal);

        Image imgEscalada = img.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);

        return new ImageIcon(imgEscalada);
    }
    
}
