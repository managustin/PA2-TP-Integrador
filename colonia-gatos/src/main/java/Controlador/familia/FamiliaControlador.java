/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.familia;

import Controlador.Gato.PerfilGatoControlador;
import java.util.List;
import modelo.FamiliaAdoptante;
import modelo.Gato;
import persistencia.ControladoraPersistencia;
import vista.familia.PanelGatoCard;
import vista.familia.PanelPrincipalFamiliaAdoptante;
import vista.gato.VentanaPerfilGato;

/**
 *
 * @author ms_ma
 */
public class FamiliaControlador {
    
    private PanelPrincipalFamiliaAdoptante vista;
    private FamiliaAdoptante familia;
    private ControladoraPersistencia controladora;
    
    public FamiliaControlador(PanelPrincipalFamiliaAdoptante vista, FamiliaAdoptante familia) {
        this.vista = vista;
        this.familia = familia;
        this.controladora = new ControladoraPersistencia();
        saludoBienvenida();
        mostrarGatos();
        // después habrá listeners.
        System.out.println("la familia controlador se usa");
        
    }
    
    private void saludoBienvenida(){
        this.vista.getLblBienvenido().setText("Bienvenida, familia " + familia.verNombre() + ". Estos gatos buscan un hogar.");
    }
    
    private void mostrarGatos() {
        List<Gato> todos = controladora.traerGatos();

        // filtrar NO adoptados
        List<Gato> noAdoptados = todos.stream()
            .filter(g -> !controladora.tieneAdopcionActiva(g))
            .toList();

        vista.getPanelGatos().removeAll();

        for (Gato gato : noAdoptados) {
            PanelGatoCard card = new PanelGatoCard(gato);
            card.getBtnVerGato().addActionListener(e -> abrirPerfilGato(gato));
            vista.getPanelGatos().add(card);
        }

        vista.getPanelGatos().revalidate();
        vista.getPanelGatos().repaint();
    }

    
    private void abrirPerfilGato(Gato gato) {
        VentanaPerfilGato dialog = new VentanaPerfilGato(null, true, gato);
        new PerfilGatoControlador(dialog, gato, this.familia);  // usuario = FamiliaAdoptante
        dialog.setLocationRelativeTo(vista);
        dialog.setVisible(true);
    }   
    
}
