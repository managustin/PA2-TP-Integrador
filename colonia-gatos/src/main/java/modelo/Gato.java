/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mango
 */
@Entity
public class Gato implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_gato;
    private String nombre;
    private String color;
    private String caracteristicas;
    private String foto;
    
    @ManyToOne
    @JoinColumn(name="id_zona")
    private Zona zona;
    private EstadoSalud estadoSalud;
    private String qr;
    private boolean esterilizado;
    
    @OneToMany (mappedBy="michi")
    private List<Tarea> tareas = new ArrayList<>();
    @OneToOne
    private HistorialMedico historial = new HistorialMedico();
    
    @ManyToOne
    @JoinColumn(name="id_volun")
    private Voluntario volun;
    
    @OneToMany (mappedBy="michi")
    private List<Adopcion> adopciones = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name="id_vet")
    private Veterinario vet;

    public Gato() {
    }

    public Gato(int id_gato, String nombre, String color, String caracteristicas, String foto, Zona zona, EstadoSalud estadoSalud, String qr, boolean esterilizado, Voluntario volun) {
        this.id_gato = id_gato;
        this.nombre = nombre;
        this.color = color;
        this.caracteristicas = caracteristicas;
        this.foto = foto;
        this.zona = zona;
        this.estadoSalud = estadoSalud;
        this.qr = qr;
        this.esterilizado = esterilizado;
        this.volun = volun;
    }
    
    
    
    public int getId_gato() {
        return id_gato;
    }

    public Voluntario getVolun() {
        return volun;
    }

    public List<Adopcion> getAdopciones() {
        return adopciones;
    }

    // ----------------------------- Getters -----------------------------
    public Veterinario getVet() {
        return vet;
    }

    public int getIdGato() {
        return id_gato;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public String getFoto() {
        return foto;
    }

    public Zona getZona() {
        return zona;
    }

    public EstadoSalud getEstadoSalud() {
        return estadoSalud;
    }

    public String getQr() {
        return qr;
    }

    public boolean isEsterilizado() {
        return esterilizado;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public HistorialMedico getHistorial() {
        return historial;
    }
    // ----------------------------- Setters ----------------------------- 

    public void setId_gato(int id_gato) {
        this.id_gato = id_gato;
    }

    public void setHistorial(HistorialMedico historial) {
        this.historial = historial;
    }

    public void setVolun(Voluntario volun) {
        this.volun = volun;
    }

    public void setAdopciones(List<Adopcion> adopciones) {
        this.adopciones = adopciones;
    }

    public void setVet(Veterinario vet) {
        this.vet = vet;
    }
    
    

    public void setId(int id_gato) {
        this.id_gato = id_gato;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public void setEstadoSalud(EstadoSalud estadoSalud) {
        this.estadoSalud = estadoSalud;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public void setEsterilizado(boolean esterilizado) {
        this.esterilizado = esterilizado;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
    
    
    // ----------------------------- Otros métodos ----------------------------- 
    
    public void actualizarEstado(EstadoSalud salud){
        this.estadoSalud = salud;
    }
    
    public void agregarTarea(Tarea t){
        this.tareas.add(t);
    }
}
