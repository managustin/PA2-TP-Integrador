package Controlador.Gato;

import Controlador.zona.ZonaControlador;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.EstadoSalud;
import modelo.Gato;
import modelo.HistorialMedico;
import modelo.Voluntario;
import modelo.Zona;
import persistencia.ControladoraPersistencia;
import vista.gato.VentanaRegistrarGato;
import vista.zona.VentanaZona;

public class GatoControlador {
    
    private VentanaRegistrarGato vista;
    private Voluntario voluntario;
    private ControladoraPersistencia controlPersis;
    private byte[] fotoSeleccionada;

    public GatoControlador(VentanaRegistrarGato vista, Voluntario voluntario, ControladoraPersistencia controlPersis) { /* Código para VentanaRegistrarGato*/
        this.vista = vista;
        this.voluntario = voluntario;
        this.controlPersis = controlPersis;
        
        this.vista.cargarZona(controlPersis.traerZonas());
        this.vista.cargarEstadoSalud(EstadoSalud.values());
        
        this.vista.getBtnSeleccionarFoto().addActionListener(e -> seleccionarFoto());
        this.vista.getBtnGuardar().addActionListener(e -> guardarGato(controlPersis));
        this.vista.getBtnAgregarUbicacion().addActionListener(e -> agregarZona(controlPersis));
        
    }
    
    private void agregarZona(ControladoraPersistencia controlPersis){
        VentanaZona vistaZona = new VentanaZona(null, true);
        ZonaControlador zonaCont = new ZonaControlador(vistaZona, this.voluntario, controlPersis);
        vista.cargarZona(controlPersis.traerZonas());
        
        vistaZona.setLocationRelativeTo(vista);
        vistaZona.setVisible(true);
    }
    
    private void seleccionarFoto() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccionar foto del gato");
        chooser.setFileFilter(new FileNameExtensionFilter("Imágenes JPG y PNG", "jpg", "jpeg", "png"));

        int resultado = chooser.showOpenDialog(vista);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();

            try {
                // 1) Leer bytes originales
                byte[] bytesOriginal = Files.readAllBytes(archivo.toPath());

                // 2) Redimensionar (por ejemplo a 600 px de ancho)
                System.out.println("\n\n\n\n\n\nORIGINAL: " + bytesOriginal.length + " bytes");
                byte[] bytesReducidos = redimensionar(bytesOriginal, 600);
                System.out.println("REDUCIDA: " + bytesReducidos.length + " bytes");
 
                // 3) Guardar para persistir después
                fotoSeleccionada = bytesReducidos;

            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(vista, "No se pudo leer la imagen.");
            }
        }
    }

    
    private void guardarGato(ControladoraPersistencia controlPersis){
        
        try{
            Gato gato = new Gato();
            gato.setNombre(vista.getTxtNombre().getText());
            gato.setColor(vista.getTxtColor().getText());
            gato.setCaracteristicas(vista.getTxtCaracteristicas().getText());
            gato.setZona((Zona) vista.getComboZona().getSelectedItem());
            gato.setEstadoSalud((EstadoSalud) vista.getComboEstadoSalud().getSelectedItem());
            gato.setEsterilizado(vista.getChkEsterilizado().isSelected());
            gato.setFoto(fotoSeleccionada);
            gato.setVolun(voluntario);
            HistorialMedico historial = new HistorialMedico();
            controlPersis.crearHistorial(historial);
            gato.setHistorial(historial);
            
            controlPersis.crearGato(gato);
            
            JOptionPane.showMessageDialog(vista, "Gato guardado correctamente.");
            vista.dispose();
            
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista, "Error al guardar el gato: " + e.getMessage());
        }
    }
    
    private byte[] redimensionar(byte[] originalBytes, int nuevoAncho) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(originalBytes);
        BufferedImage original = ImageIO.read(bis);

        int anchoOriginal = original.getWidth();
        int altoOriginal = original.getHeight();

        // Mantener proporción
        int nuevoAlto = (nuevoAncho * altoOriginal) / anchoOriginal;

        Image imagenEscalada = original.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);

        BufferedImage bufferedEscalado = new BufferedImage(
                nuevoAncho, nuevoAlto, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = bufferedEscalado.createGraphics();
        g2d.drawImage(imagenEscalada, 0, 0, null);
        g2d.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedEscalado, "jpg", baos);

        return baos.toByteArray();
    }
}
