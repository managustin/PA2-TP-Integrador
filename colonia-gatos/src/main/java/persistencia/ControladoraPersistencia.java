/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;
import modelo.Gato;
import modelo.HistorialMedico;
import modelo.Zona;

/**
 *
 * @author ms_ma
 */
public class ControladoraPersistencia {
    
    AdministradorJpaController AdminJpa = new AdministradorJpaController();
    GatoJpaController GatoJpa = new GatoJpaController();

    public ControladoraPersistencia() {
    }
    
    public void crearGato(Gato gato){
        GatoJpa.create(gato);
    }

    public List<Gato> traerGatos(){
        return GatoJpa.findGatoEntities();
    }
    
    
    //ZONAS
    
    ZonaJpaController ZonaJpa = new ZonaJpaController();
    
    public void crearZona(Zona zona){
        ZonaJpa.create(zona);
    }
    public List<Zona> traerZonas(){
        return ZonaJpa.findZonaEntities();
    }
    
    //  HISTORIAL MEDICO  
    
}
