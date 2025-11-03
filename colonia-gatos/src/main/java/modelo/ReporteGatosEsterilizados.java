/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ms_ma
 */
@Entity
public class ReporteGatosEsterilizados extends Reporte {

    public ReporteGatosEsterilizados(Date fechaGeneracion) {
        super(fechaGeneracion);
    }

    @OneToMany
    private List<Gato> gatosEsterilizados;
    
    @Override
    public void generar() {
        // lógica para obtener los gatos con esterilizado = true
    }
    
}
