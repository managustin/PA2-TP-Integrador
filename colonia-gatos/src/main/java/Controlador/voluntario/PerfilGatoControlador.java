/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.voluntario;

import Controlador.QrGenerator;
import com.google.zxing.WriterException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Adopcion;
import modelo.EstadoAdopcion;
import modelo.FamiliaAdoptante;
import modelo.Gato;
import modelo.Tarea;
import modelo.TipoAdopcion;
import modelo.Usuario;
import modelo.Visita;
import modelo.Voluntario;
import persistencia.ControladoraPersistencia;
import vista.gato.VentanaPerfilGato;
import vista.gato.VentanaRegistrarTarea;
import vista.gato.VentanaVisitas;

/**
 *
 * @author ms_ma
 */
public class PerfilGatoControlador {
    private VentanaPerfilGato vista;
    private Gato gato;
    private Usuario usuario; // genérico
    private ControladoraPersistencia controlPersis;

    public PerfilGatoControlador(VentanaPerfilGato vista, Gato gato, Usuario usuario) {
        this.vista = vista;
        this.gato = gato;
        this.usuario = usuario;
        this.controlPersis = new ControladoraPersistencia();
        
        //habilitar/deshabilitar boton postular para familia
        ajustarBotonesSegunEstado();

        mostrarDatos();
        cargarFamiliasPostuladas();
        configurarEventos();
    }
    
    private void ajustarBotonesSegunEstado() {
        if (usuario instanceof FamiliaAdoptante) {
            FamiliaAdoptante familia = (FamiliaAdoptante) usuario;
            boolean yaPostulo = controlPersis.existePostulacion(gato, familia);
            vista.getBtnPostular().setEnabled(!yaPostulo);
            vista.getBtnPostular().setText(yaPostulo ? "Ya se postuló" : "Postularse para adoptar");

            // para familias, siempre ocultamos los botones de voluntario
            vista.getBtnRevisarPostulacion().setVisible(false);
            vista.getBtnVisitas().setVisible(false);

        } else if (usuario instanceof Voluntario) {
            Voluntario voluntario = (Voluntario) usuario;

            // ocultamos el botón de postular para voluntarios
            vista.getBtnPostular().setVisible(false);

            // ahora vemos si el gato ya tiene adopción aceptada
            Adopcion adopcionAceptada = controlPersis.traerAdopcionAceptada(gato);
            if (adopcionAceptada != null) {
                vista.getBtnRevisarPostulacion().setVisible(false);
                vista.getBtnVisitas().setVisible(true);
            } else {
                vista.getBtnRevisarPostulacion().setVisible(true);
                vista.getBtnVisitas().setVisible(false);
            }
        }
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
        vista.getBtnPostular().addActionListener(e -> postularGato());
        vista.getBtnRevisarPostulacion().addActionListener(e -> revisarPostulacion());
        vista.getBtnVisitas().addActionListener(e -> abrirVentanaVisitas());
    }
    
    private void cargarFamiliasPostuladas() {
        List<Adopcion> postulaciones = controlPersis.traerPostulacionesPendientesPorGato(gato);
        DefaultListModel<String> model = new DefaultListModel<>();

        for (Adopcion adopcion : postulaciones) {
            FamiliaAdoptante familia = adopcion.getFamilia();
            String item = familia.getNombre() + " - " + familia.getTelefono() + " - " + familia.getDireccion();
            model.addElement(item);
        }

        vista.getListaFamilias().setModel(model);
    }



    
    private void revisarPostulacion() {
        int idx = vista.getIndiceFamiliaSeleccionado();
        if (idx < 0) {
            JOptionPane.showMessageDialog(vista, "Seleccioná una familia.");
            return;
        }

        List<Adopcion> postulaciones = controlPersis.traerPostulacionesPendientesPorGato(gato);
        Adopcion adopcionSeleccionada = postulaciones.get(idx);

        Object[] opciones = {"Aceptar", "Rechazar"};
        int resultado = JOptionPane.showOptionDialog(
                vista,
                "¿Deseás aceptar o rechazar esta postulación?",
                "Revisar postulacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (resultado == JOptionPane.YES_OPTION) {
            adopcionSeleccionada.setEstado(EstadoAdopcion.ACTIVA);
        } else if (resultado == JOptionPane.NO_OPTION) {
            adopcionSeleccionada.setEstado(EstadoAdopcion.CANCELADA);
        } else {
            return;
        }

        controlPersis.actualizarAdopcion(adopcionSeleccionada);
        cargarFamiliasPostuladas();
    }
    
    private void postularGato() {
        
        // Opciones para el tipo de adopción
        TipoAdopcion[] opciones = {TipoAdopcion.TRANSITORIA, TipoAdopcion.DEFINITIVA};

        TipoAdopcion tipoSeleccionado = (TipoAdopcion) JOptionPane.showInputDialog(
                vista,
                "¿Para qué tipo de hogar querés postular este gato?",
                "Seleccionar tipo de adopción",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0] // opción por defecto
        );

        // Si el usuario cerró el diálogo o canceló, salimos
        if (tipoSeleccionado == null) {
            return;
        }
        
        // crear la adopción en estado “PENDIENTE”
        Adopcion adopcion = new Adopcion();
        adopcion.setMichi(gato);
        adopcion.setFamilia((FamiliaAdoptante) usuario);
        adopcion.setTipo(tipoSeleccionado);
        adopcion.setEstado(EstadoAdopcion.PENDIENTE);
        adopcion.setFechaInicio(new Date());

        controlPersis.crearAdopcion(adopcion);

        JOptionPane.showMessageDialog(vista, "Postulación enviada correctamente!");
        vista.getBtnPostular().setEnabled(false);        
    }


    private void abrirVentanaRegistrarTarea() {
        VentanaRegistrarTarea dialog = new VentanaRegistrarTarea(
            vista,  // parent
            true   // modal
        );
        new RegistrarTareaControlador(dialog, gato, (Voluntario) usuario);
        dialog.setLocationRelativeTo(vista);
        dialog.setVisible(true);

        // cuando se cierre el dialog, recargar lista de tareas:
        ControladoraPersistencia control = new ControladoraPersistencia();
        List<Tarea> tareas = control.traerTareasPorGato(gato.getId_gato());
        vista.cargarTareas(tareas);
    }
    
    private void abrirVentanaVisitas() {
        // Crear la vista (el diálogo)
        VentanaVisitas vistaVisitas = new VentanaVisitas(vista, true);

        // Crear el controlador y pasarle la vista y los datos necesarios
        ControladorVentanaVisitas controladorVisitas = new ControladorVentanaVisitas(vistaVisitas, gato);

        // Mostrar la ventana
        vistaVisitas.setLocationRelativeTo(vista);
        vistaVisitas.setVisible(true);
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
