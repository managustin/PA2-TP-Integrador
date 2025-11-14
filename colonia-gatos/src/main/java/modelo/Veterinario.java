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
    
    public Veterinario() {
    }

    public Veterinario(int id_usuario, String nombre, String email, String password, String telefono) {
        super(id_usuario, nombre, email, password, telefono);
    }
    public void setRegistros(List<RegistroMedico> registros) {
        this.registros = registros;
    } 
    @Override
    public String toString() {
        return "ID " + getId_usuario() + " - " + getNombre() + " (Veterinario)";
    }

}
