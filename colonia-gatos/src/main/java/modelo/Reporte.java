/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ms_ma
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Reporte implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reporte;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGeneracion;

    public Reporte(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }
    
    public abstract void generar(); // cada subclase implementa cómo se genera

    public int getId_reporte() {
        return id_reporte;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setId_reporte(int id_reporte) {
        this.id_reporte = id_reporte;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }
    
    
    
}
