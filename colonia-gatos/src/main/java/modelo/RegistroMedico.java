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
public class RegistroMedico implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_rm;
    private TipoRegistroMedico tipo;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private String descripcion;
    private String archivoEstudio;
    
    @ManyToOne
    @JoinColumn(name="id_historial")
    private HistorialMedico historial;
    
    @ManyToOne
    @JoinColumn(name="id_vet")
    private Veterinario vet;

    public RegistroMedico(int id_rm, TipoRegistroMedico tipo, Date fecha, String descripcion, String archivoEstudio, HistorialMedico historial) {
        this.id_rm = id_rm;
        this.tipo = tipo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.archivoEstudio = archivoEstudio;
        this.historial = historial;
    }

    public int getId_rm() {
        return id_rm;
    }

    public TipoRegistroMedico getTipo() {
        return tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getArchivoEstudio() {
        return archivoEstudio;
    }

    public HistorialMedico getHistorial() {
        return historial;
    }

    public void setId_rm(int id_rm) {
        this.id_rm = id_rm;
    }

    public void setTipo(TipoRegistroMedico tipo) {
        this.tipo = tipo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setArchivoEstudio(String archivoEstudio) {
        this.archivoEstudio = archivoEstudio;
    }

    public void setHistorial(HistorialMedico historial) {
        this.historial = historial;
    }

    
}
