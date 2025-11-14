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
 * @author Mango
 */
@Entity
@DiscriminatorValue("VOLUNTARIO")
public class Voluntario extends Usuario implements Serializable {
    private String zona;
    
    @OneToMany(mappedBy = "volun")
    private List<Gato> gatosRegistrados = new ArrayList<>();
    
    @OneToMany(mappedBy = "volun")
    private List<Tarea> tareas = new ArrayList<>();

    @OneToMany(mappedBy = "volun")
    private List<Visita> visitas = new ArrayList<>();
    
    public Voluntario() {
    }

    public Voluntario(String zona, int id_usuario, String nombre, String email, String password, String telefono) {
        super(id_usuario, nombre, email, password, telefono);
        this.zona = zona;
    }

    // Getter

    public List<Tarea> getTareas() {
        return tareas;
    }

    public List<Visita> getVisitas() {
        return visitas;
    }
    
    public String getZona() {
        return zona;
    }

    public List<Gato> getGatosRegistrados() {
        return gatosRegistrados;
    }

    // Setter

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public void setVisitas(List<Visita> visitas) {
        this.visitas = visitas;
    }
    
    public void setZona(String zona) {
        this.zona = zona;
    }

    public void setGatosRegistrados(List<Gato> gatosRegistrados) {
        this.gatosRegistrados = gatosRegistrados;
    }
    
    // metodos    
    public void registrarGato(Gato g){
        this.gatosRegistrados.add(g);
    }
    
    public void registrarTarea(Gato g, Tarea t) throws Exception{
        if(!this.gatosRegistrados.contains(g)){
            throw new Exception("El voluntario no tiene el gato asignado.");
        }
        
        g.agregarTarea(t);
    }
    
    @Override
    public String toString() {
        return "ID " + getId_usuario() + " - " + getNombre() + " (Zona: " + zona + ")";
    }

}
