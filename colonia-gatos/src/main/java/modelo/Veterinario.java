/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ms_ma
 */

@Entity
@DiscriminatorValue("VETERINARIO")
public class Veterinario extends Usuario implements Serializable {

    @OneToMany (mappedBy="vet")
    private List<RegistroMedico> registros = new ArrayList<>();
    
    @OneToMany (mappedBy="vet")
    private List<Gato> gatos = new ArrayList<>();    
    
    public Veterinario() {
    }

    public Veterinario(int id_usuario, String nombre, String email, String password, String telefono) {
        super(id_usuario, nombre, email, password, telefono);
    }
    
    public HistorialMedico accederHistorial(Gato g){
        return g.getHistorial();
    }
    public void crearRegistro(Gato g, RegistroMedico r){
        g.getHistorial().agregarRegistro(r);
    }
    public List<RegistroMedico> emitirCertificado(Gato g, String descripcion){
        return g.getHistorial().getRegistros();
    }
    
}
