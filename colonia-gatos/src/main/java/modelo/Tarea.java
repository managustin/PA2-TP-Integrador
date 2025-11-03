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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ms_ma
 */
@Entity
public class Tarea implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_tarea;
    private TipoTarea tipoTarea;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Temporal(TemporalType.TIME)
    private Date hora;
    private String ubicacion;
    private String observaciones;
    @ManyToOne
    @JoinColumn(name="id_volun")
    private Voluntario volun;
    
    @ManyToOne
    @JoinColumn(name="id_michi")
    private Gato michi;

    public Tarea() {
    }

    public Tarea(int id_tarea, TipoTarea tipoTarea, Date fecha, Date hora, String ubicacion, String observaciones, Voluntario volun) {
        this.id_tarea = id_tarea;
        this.tipoTarea = tipoTarea;
        this.fecha = fecha;
        this.hora = hora;
        this.ubicacion = ubicacion;
        this.observaciones = observaciones;
        this.volun = volun;
    }
    
    // ----------------------------- Getters ----------------------------- 

    public int getId_tarea() {
        return id_tarea;
    }

    public TipoTarea getTipoTarea() {
        return tipoTarea;
    }

    public Date getFecha() {
        return fecha;
    }

    public Date getHora() {
        return hora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Voluntario getVolun() {
        return volun;
    }

    public Gato getMichi() {
        return michi;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public void setTipoTarea(TipoTarea tipoTarea) {
        this.tipoTarea = tipoTarea;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setVolun(Voluntario volun) {
        this.volun = volun;
    }

    public void setMichi(Gato michi) {
        this.michi = michi;
    }

   
    
    
    
    public void setObservaciones(String observaciones) {
        this.observaciones += "\n" + observaciones;
    }
    
}
