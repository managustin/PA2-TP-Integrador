/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Gato;

import Controlador.QrGenerator;
import Controlador.voluntario.ControladorVentanaVisitas;
import Controlador.voluntario.RegistrarTareaControlador;
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
import modelo.RolUsuario;
import modelo.Tarea;
import modelo.TipoAdopcion;
import modelo.Usuario;
import modelo.Veterinario;
import modelo.Visita;
import modelo.Voluntario;
import persistencia.ControladoraPersistencia;
import vista.gato.VentanaHistorialMedico;
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

    public PerfilGatoControlador(VentanaPerfilGato vista, Gato gato, Usuario usuario, ControladoraPersistencia controlPersis) {
        this.vista = vista;
        this.gato = gato;
        this.usuario = usuario;
        this.controlPersis = controlPersis;
        
        //habilitar/deshabilitar boton postular para familia
        ajustarBotonesSegunEstado();

        mostrarDatos();
        cargarFamiliasPostuladas();
        configurarEventos();
    }

    public void setGato(Gato gato) {
        this.gato = gato;
    }
    
    private RolUsuario obtenerRol(Usuario u) {
        if (u instanceof FamiliaAdoptante) return RolUsuario.FAMILIA;
        if (u instanceof Voluntario) return RolUsuario.VOLUNTARIO;
        if (u instanceof Veterinario) return RolUsuario.VETERINARIO;
        throw new IllegalArgumentException("Rol no soportado");
    }

    private void ajustarBotonesSegunEstado() {
        RolUsuario rol = obtenerRol(usuario);

        switch (rol) {
            case FAMILIA -> ajustarParaFamilia();
            case VOLUNTARIO -> ajustarParaVoluntario();
            case VETERINARIO -> ajustarParaVeterinario();
        }
    }
    
    private void ajustarParaFamilia() {
        boolean yaPostulo = controlPersis.existePostulacion(gato, (FamiliaAdoptante) usuario);
        vista.getBtnPostular().setEnabled(!yaPostulo);
        vista.getBtnPostular().setText(yaPostulo ? "Ya se postuló" : "Postularse para adoptar");

        vista.getBtnRevisarPostulacion().setVisible(false);
        vista.getBtnVisitas().setVisible(false);
        vista.getBtnVerHistorialMedico().setVisible(false);
        vista.getBtnRegistrarTarea().setVisible(false);
    }

    private void ajustarParaVoluntario() {
        vista.getBtnPostular().setVisible(false);

        Adopcion adopcionAceptada = controlPersis.traerAdopcionAceptada(gato);
        vista.getBtnRevisarPostulacion().setVisible(adopcionAceptada == null);
        vista.getBtnVisitas().setVisible(adopcionAceptada != null);

        vista.getBtnVerHistorialMedico().setVisible(false);
    }

    private void ajustarParaVeterinario() {
        vista.getBtnPostular().setVisible(false);
        vista.getBtnRevisarPostulacion().setVisible(false);
        vista.getBtnVisitas().setVisible(false);
        vista.getBtnRegistrarTarea().setVisible(false);

        vista.getBtnVerHistorialMedico().setVisible(true);
    }
    
    public void mostrarDatos() {
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
        vista.getBtnVerHistorialMedico().addActionListener(e -> abrirVentanaHistorial());
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
    
    private void abrirVentanaHistorial(){
        VentanaHistorialMedico dialog = new VentanaHistorialMedico(
            vista,  // parent
            true   // modal
        );
        new HistorialMedicoControlador(dialog, gato, (Veterinario) usuario, controlPersis, this);
        dialog.setLocationRelativeTo(vista);
        dialog.setVisible(true);

        // cuando se cierre el dialog, actualizar estado por si hubo un cambio:
        vista.setEstado("Estado de Salud: " + gato.getEstadoSalud());
    }


    private void abrirVentanaRegistrarTarea() {
        VentanaRegistrarTarea dialog = new VentanaRegistrarTarea(
            vista,  // parent
            true   // modal
        );
        new RegistrarTareaControlador(dialog, gato, (Voluntario) usuario, controlPersis);
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
        ControladorVentanaVisitas controladorVisitas = new ControladorVentanaVisitas(vistaVisitas, gato, controlPersis);

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
