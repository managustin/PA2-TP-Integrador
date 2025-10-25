/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mango
 */
public class Voluntario extends Usuario {
    private String zona;
    private List<Gato> gatosRegistrados = new ArrayList<>();

    public Voluntario(String zona, String nom, String email, String password) {
        super(nom, email, password);
        this.zona = zona;
    }

    public Voluntario(String zona, int id, String nom, String email, String password) {
        super(id, nom, email, password);
        this.zona = zona;
    }

    // Getter
    public String getZona() {
        return zona;
    }

    public List<Gato> getGatosRegistrados() {
        return gatosRegistrados;
    }

    // Setter
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
}
