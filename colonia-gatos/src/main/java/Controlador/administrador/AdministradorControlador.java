package Controlador.administrador;

import Controlador.RegistroControlador;
import Controlador.zona.ZonaControlador;
import java.awt.Frame;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import modelo.Administrador;
import modelo.Adopcion;
import modelo.FamiliaAdoptante;
import modelo.Gato;
import modelo.Veterinario;
import modelo.Voluntario;
import modelo.Zona;
import persistencia.ControladoraPersistencia;
import vista.VentanaRegistro;
import vista.administrador.PanelPrincipalAdministrador;
import vista.administrador.VentanaReporte;
import vista.zona.VentanaZona;

public class AdministradorControlador {
    
    private final PanelPrincipalAdministrador vista;
    private final ControladoraPersistencia controlPersis;
    private final Administrador admin;
    private List<Gato> gatos;
    private List<Gato> ultimosFiltrados;
    private List<FamiliaAdoptante> familias;
    private List<Voluntario> voluntarios;
    private List<Veterinario> veterinarios;
    private String reporteActual;

    
    public AdministradorControlador(PanelPrincipalAdministrador vista, Administrador admin, ControladoraPersistencia controlPersis) {
        this.vista = vista;
        this.controlPersis = controlPersis;
        this.admin = admin;
        
        cargarGatos();
        cargarComboTipoReporte();
        cargarComboZona();
        configurarListeners();
        cargarListasUsuarios();
        configurarBusquedas();
    }
    
    private void configurarListeners(){
        vista.getComboTipoReporte().addActionListener(e -> configurarVisibilidadCampos());
        vista.getBtnAplicar().addActionListener(e -> aplicarFiltros());
        vista.getBtnZonas().addActionListener(e -> abrirZonas());
        vista.getBtnReporte().addActionListener(e -> abrirReporte());
        vista.getBtnEliminarUsuario().addActionListener(e -> eliminarUsuario());
        vista.getBtnRegistrarVoluntario().addActionListener(e -> abrirRegistroVoluntario());
        vista.getBtnRegistrarVeterinario().addActionListener(e -> abrirRegistroVeterinario());

    }
    
    private void abrirRegistroVoluntario() {
        VentanaRegistro v = new VentanaRegistro();
        new RegistroControlador(v, controlPersis, "VOLUNTARIO", this::cargarListasUsuarios);
        v.setLocationRelativeTo(vista);
        v.setVisible(true);

        cargarListasUsuarios(); // refrescar después de registrar
    }

    private void abrirRegistroVeterinario() {
        VentanaRegistro v = new VentanaRegistro();
        new RegistroControlador(v, controlPersis, "VETERINARIO", this::cargarListasUsuarios);
        v.setLocationRelativeTo(vista);
        v.setVisible(true);

        cargarListasUsuarios();
    }

    
    private Object obtenerSeleccionado() {
        if (!vista.getListaFamilias().isSelectionEmpty()) {
            return familias.get(vista.getListaFamilias().getSelectedIndex());
        }
        if (!vista.getListaVoluntarios().isSelectionEmpty()) {
            return voluntarios.get(vista.getListaVoluntarios().getSelectedIndex());
        }
        if (!vista.getListaVeterinarios().isSelectionEmpty()) {
            return veterinarios.get(vista.getListaVeterinarios().getSelectedIndex());
        }
        return null;
    }
    
    private void eliminarUsuario() {
        Object seleccionado = obtenerSeleccionado();
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(vista, "No hay ningún usuario seleccionado.");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(
                vista,
                "¿Seguro que querés eliminar este usuario?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) return;

        try {
            if (seleccionado instanceof FamiliaAdoptante fa) {
                controlPersis.eliminarUsuario(fa.getId_usuario());
            } else if (seleccionado instanceof Voluntario v) {
                controlPersis.eliminarUsuario(v.getId_usuario());
            } else if (seleccionado instanceof Veterinario vet) {
                controlPersis.eliminarUsuario(vet.getId_usuario());
            }

            cargarListasUsuarios(); // refrescar la vista

            JOptionPane.showMessageDialog(vista, "Usuario eliminado.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "No se pudo eliminar: " + e.getMessage());
        }
    }


    
    private void abrirReporte() {
        if (ultimosFiltrados == null || ultimosFiltrados.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "No hay datos para mostrar.");
            return;
        }
        
        Frame parent = (Frame) SwingUtilities.getWindowAncestor(vista);
        VentanaReporte vr = new VentanaReporte(
                parent, 
                true, 
                ultimosFiltrados,
                reporteActual  // un String que guardás cuando aplicás filtro
        );

        vr.setLocationRelativeTo(vista);
        vr.setVisible(true);
    }

    
    private void abrirZonas(){

        Frame parent = (Frame) SwingUtilities.getWindowAncestor(vista);
        VentanaZona ventanaZonas = new VentanaZona(parent, true);
        new ZonaControlador(ventanaZonas, admin, controlPersis);
        ventanaZonas.setLocationRelativeTo(vista);
        ventanaZonas.setVisible(true);
    }
    
    private void configurarVisibilidadCampos() {
        String tipo = (String) vista.getComboTipoReporte().getSelectedItem();

        boolean necesitaZona = "Gatos por zona".equals(tipo);

        vista.getComboZona().setVisible(necesitaZona);
    }
    
        private void cargarListasUsuarios() {
        familias = controlPersis.traerFamilias();
        voluntarios = controlPersis.traerVoluntarios();
        veterinarios = controlPersis.traerVeterinarios();

        vista.cargarListaFamilias(familias.stream().map(FamiliaAdoptante::toString).toList());
        vista.cargarListaVoluntarios(voluntarios.stream().map(Voluntario::toString).toList());
        vista.cargarListaVeterinarios(veterinarios.stream().map(Veterinario::toString).toList());
    }
        
     private void configurarBusquedas() {

        vista.getBtnBuscarFamilia().addActionListener(e -> {
            String txt = vista.getTxtBuscarFamilia().getText().trim().toLowerCase();
            var filtrado = familias.stream()
                    .filter(f -> f.getNombre().toLowerCase().contains(txt))
                    .map(FamiliaAdoptante::toString)
                    .toList();
            vista.cargarListaFamilias(filtrado);
        });

        vista.getBtnBuscarVoluntario().addActionListener(e -> {
            String txt = vista.getTxtBuscarVoluntario().getText().trim().toLowerCase();
            var filtrado = voluntarios.stream()
                    .filter(v -> v.getNombre().toLowerCase().contains(txt))
                    .map(Voluntario::toString)
                    .toList();
            vista.cargarListaVoluntarios(filtrado);
        });

        vista.getBtnBuscarVeterinario().addActionListener(e -> {
            String txt = vista.getTxtBuscarVeterinario().getText().trim().toLowerCase();
            var filtrado = veterinarios.stream()
                    .filter(v -> v.getNombre().toLowerCase().contains(txt))
                    .map(Veterinario::toString)
                    .toList();
            vista.cargarListaVeterinarios(filtrado);
        });
    }
   

    
    private void aplicarFiltros() {
        String tipo = (String) vista.getComboTipoReporte().getSelectedItem();

        List<Gato> resultado;

        switch (tipo) {
            case "Gatos por zona" -> {
                Zona zona = (Zona) vista.getComboZona().getSelectedItem();
                System.out.println(zona);
                resultado = filtrarPorZona(gatos, zona);
                reporteActual = "Reporte: Gatos por zona - " + zona.getNombre();
            }
            case "Esterilizados" -> {
                resultado = filtrarEsterilizados();
                reporteActual = "Reporte: Gatos esterilizados";
            }
            case "Adoptados" -> {
                resultado = filtrarAdoptados();
                reporteActual = "Reporte: Gatos adoptados";
            }
            default -> resultado = List.of();
        }

        // mostrar en vista
        vista.cargarListaGatos(
            resultado.stream().map(Gato::toString).toList()
        );

        // opcional: se guarda el último resultado para generar el reporte
        this.ultimosFiltrados = resultado;
    }
    
    public List<Gato> filtrarPorZona(List<Gato> todos, Zona zona) {
        return todos.stream()
                .filter(g -> g.getZona() != null &&
                             Objects.equals(g.getZona().getId_zona(), zona.getId_zona()))
                .toList();
    }

    
    private List<Gato> filtrarEsterilizados() {
        return gatos.stream()
                .filter(Gato::isEsterilizado)   // o getEsterilizado(), depende de tu entidad
                .toList();
    }

    private List<Gato> filtrarAdoptados() {

        List<Adopcion> adopciones = controlPersis.traerAdopciones();

        // Solo adopciones activas (fechaFin == null)
        Set<Integer> idsGatosAdoptados = adopciones.stream()
                .filter(a -> a.getFechaFin() == null)
                .map(a -> a.getMichi().getId_gato())
                .collect(Collectors.toSet());

        // Devuelvo solo los gatos cuyo id esté en la tabla adopciones
        return gatos.stream()
                .filter(g -> idsGatosAdoptados.contains(g.getId_gato()))
                .toList();
    }
    
    private void cargarGatos() {
        gatos = controlPersis.traerGatos();
        vista.cargarListaGatos(
            gatos.stream().map(Gato::toString).toList()
        );
    }
    
    private void cargarComboTipoReporte() {
        vista.getComboTipoReporte().removeAllItems();
        vista.getComboTipoReporte().addItem("Gatos por zona");
        vista.getComboTipoReporte().addItem("Esterilizados");
        vista.getComboTipoReporte().addItem("Adoptados");
    }
    
    private void cargarComboZona() {
        List<Zona> zonas = controlPersis.traerZonas();

        vista.getComboZona().removeAllItems();
        for (Zona z : zonas) {
            vista.getComboZona().addItem(z);
        }
    }


    
}
