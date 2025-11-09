/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ms_ma
 */
@Entity
public class Zona implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_zona;
    private String nombre;
    @OneToMany (mappedBy="zona")
    private List<Gato> gatos = new ArrayList<>();

    public Zona() {
    }

    public Zona(int id_zona, String nombre) {
        this.id_zona = id_zona;
        this.nombre = nombre;
    }

    public int getId_zona() {
        return id_zona;
    }
    
    public String getNombre(){
        return this.nombre;
    }

    public void setId_zona(int id_zona) {
        this.id_zona = id_zona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
