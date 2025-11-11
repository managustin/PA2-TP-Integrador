package Controlador.veterinario;

import Controlador.Gato.PerfilGatoControlador;
import java.util.List;
import modelo.Gato;
import modelo.Veterinario;
import persistencia.ControladoraPersistencia;
import vista.gato.VentanaPerfilGato;
import vista.veterinario.PanelPrincipalVeterinario;


public class VeterinarioControlador {
    private PanelPrincipalVeterinario vista;
    private Veterinario veterinario;
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    private List<Gato> gatos;

    public VeterinarioControlador(PanelPrincipalVeterinario vista, Veterinario veterinario) {
        this.vista = vista;
        this.veterinario = veterinario;
        
        cargarGatos();
        configurarListeners();
    }
    
    private void cargarGatos() {
        gatos = controlPersis.traerGatos(); // TODOS los gatos
        vista.cargarListaGatos(
            gatos.stream().map(Gato::toString).toList()
        );
    }
    private void configurarListeners(){
        
        vista.getListaGatos().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {

                if (vista.getListaGatos().getSelectedIndex() >= 0) {
                    vista.getBtnVerGato().setEnabled(true);
                }
            }
        });
        
        vista.getBtnVerGato().addActionListener(e -> verGato());
    }
    
    public void verGato() {
        int idx = vista.getListaGatos().getSelectedIndex();
        if (idx < 0) return;

        Gato seleccionado = gatos.get(idx);

        VentanaPerfilGato dialog = new VentanaPerfilGato(null, true, seleccionado);

        new PerfilGatoControlador(dialog, seleccionado, veterinario);

        dialog.setLocationRelativeTo(vista);
        dialog.setVisible(true);
    }

    
}
