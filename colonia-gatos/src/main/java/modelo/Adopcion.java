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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ms_ma
 */
@Entity
public class Adopcion implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_adopcion;
    private TipoAdopcion tipo;
    private EstadoAdopcion estado;
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name="id_michi")
    private Gato michi;
    
    @ManyToOne
    @JoinColumn(name="id_familia")
    private FamiliaAdoptante familia;
    
    @OneToMany (mappedBy="adop")
    private List<Visita> visitas = new ArrayList<>();
    
    public Adopcion() {
    }

    public Adopcion(int id_adopcion, TipoAdopcion tipo, EstadoAdopcion estado, Date fechaInicio, Date fechaFin) {
        this.id_adopcion = id_adopcion;
        this.tipo = tipo;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getId_adopcion() {
        return id_adopcion;
    }

    public TipoAdopcion getTipo() {
        return tipo;
    }

    public EstadoAdopcion getEstado() {
        return estado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setId_adopcion(int id_adopcion) {
        this.id_adopcion = id_adopcion;
    }

    public void setTipo(TipoAdopcion tipo) {
        this.tipo = tipo;
    }

    public void setEstado(EstadoAdopcion estado) {
        this.estado = estado;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
}
