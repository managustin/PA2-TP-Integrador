/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.familia;

import java.util.List;
import modelo.FamiliaAdoptante;
import modelo.Gato;
import vista.familia.PanelGatoCard;
import vista.familia.PanelPrincipalFamiliaAdoptante;

/**
 *
 * @author ms_ma
 */
public class FamiliaControlador {
    
    private PanelPrincipalFamiliaAdoptante vista;
    private FamiliaAdoptante familia;

    public FamiliaControlador(PanelPrincipalFamiliaAdoptante vista, FamiliaAdoptante familia) {
        this.vista = vista;
        this.familia = familia;
        mostrarGatos();
        // después habrá listeners.
        System.out.println("la familia controlador se usa");
    }
    
    
    private void mostrarGatos(){
        List<Gato> gatos = familia.verPerfilesGatos();
        
        vista.getPanelGatos().removeAll();
        for(Gato gato: gatos){
            PanelGatoCard card = new PanelGatoCard(gato);
            vista.getPanelGatos().add(card);
        }
        vista.getPanelGatos().revalidate();
        vista.getPanelGatos().repaint();
    }
}
