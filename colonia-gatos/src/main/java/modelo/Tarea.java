/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author ms_ma
 */
public class Tarea {

    private int id;
    private TipoTarea tipoTarea;
    private LocalDate fecha;
    private LocalTime hora;
    private String ubicacion;
    private String observaciones;

    public Tarea(TipoTarea tipoTarea, LocalDate fecha, LocalTime hora, String ubicacion, String observaciones) {
        this.tipoTarea = tipoTarea;
        this.fecha = fecha;
        this.hora = hora;
        this.ubicacion = ubicacion;
        this.observaciones = observaciones;
    }

    public Tarea(int id, TipoTarea tipoTarea, LocalDate fecha, LocalTime hora, String ubicacion, String observaciones) {
        this.id = id;
        this.tipoTarea = tipoTarea;
        this.fecha = fecha;
        this.hora = hora;
        this.ubicacion = ubicacion;
        this.observaciones = observaciones;
    }
    
    // ----------------------------- Getters ----------------------------- 

    public int getId() {
        return id;
    }

    public TipoTarea getTipoTarea() {
        return tipoTarea;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getObservaciones() {
        return observaciones;
    }
    
    // ----------------------------- Setters ----------------------------- 

    public void setObservaciones(String observaciones) {
        this.observaciones += "\n" + observaciones;
    }
    
}
