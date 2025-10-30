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
public class Gato {
    private int id;
    private String nombre;
    private String color;
    private String caracteristicas;
    private String foto;
    private Zona zona;
    private EstadoSalud estadoSalud;
    private String qr;
    private boolean esterilizado;
    private List<Tarea> tareas = new ArrayList<>();
    private HistorialMedico historial = new HistorialMedico();
    
    public Gato(String nombre, String foto) {
        this.nombre = nombre;
        this.foto = foto;
    }
    
    public Gato(String nombre, String color, String caracteristicas, String foto, Zona zona, EstadoSalud estadoSalud, String qr, boolean esterilizado) {
        this.nombre = nombre;
        this.color = color;
        this.caracteristicas = caracteristicas;
        this.foto = foto;
        this.zona = zona;
        this.estadoSalud = estadoSalud;
        this.qr = qr;
        this.esterilizado = esterilizado;
    }
    
    public Gato(int id, String nombre, String color, String caracteristicas, String foto, Zona zona, EstadoSalud estadoSalud, String qr, boolean esterilizado) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.caracteristicas = caracteristicas;
        this.foto = foto;
        this.zona = zona;
        this.estadoSalud = estadoSalud;
        this.qr = qr;
        this.esterilizado = esterilizado;
    }

    
    // ----------------------------- Getters ----------------------------- 
    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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
