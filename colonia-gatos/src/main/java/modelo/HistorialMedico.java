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
public class HistorialMedico implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_historial;
    
    @OneToMany (mappedBy="historial")
    private List<RegistroMedico> registros = new ArrayList<>();

    public HistorialMedico() {
    }

    public HistorialMedico(int id_historial) {
        this.id_historial = id_historial;
    }

    public int getId_historial() {
        return id_historial;
    }

    public void setId_historial(int id_historial) {
        this.id_historial = id_historial;
    }

    public void setRegistros(List<RegistroMedico> registros) {
        this.registros = registros;
    }    
    
    public void agregarRegistro(RegistroMedico r){
        this.registros.add(r);
    }

    public List<RegistroMedico> getRegistros() {
        return registros;
    }
    
    
}
