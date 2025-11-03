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
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author ms_ma
 */
@Entity
public class Visita implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_visita;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Temporal(TemporalType.TIME)
    private Date hora;
    private String observaciones;
    private String resultado;
    
    @ManyToOne
    @JoinColumn(name="id_adop")
    private Adopcion adop;
    
    @ManyToOne
    @JoinColumn(name="id_volun")
    private Voluntario volun;

    public Visita() {
    }

    public Visita(int id_visita, Date fecha, Date hora, String observaciones, String resultado) {
        this.id_visita = id_visita;
        this.fecha = fecha;
        this.hora = hora;
        this.observaciones = observaciones;
        this.resultado = resultado;
    }

    public int getId_visita() {
        return id_visita;
    }

    public Date getFecha() {
        return fecha;
    }

    public Date getHora() {
        return hora;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getResultado() {
        return resultado;
    }

    public void setId_visita(int id_visita) {
        this.id_visita = id_visita;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
}
