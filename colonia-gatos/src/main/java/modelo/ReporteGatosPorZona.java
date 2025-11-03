/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import java.util.Date;

/**
 *
 * @author ms_ma
 */
@Entity
public class ReporteGatosPorZona extends Reporte {

    public ReporteGatosPorZona(Date fechaGeneracion) {
        super(fechaGeneracion);
    }
    
    // este ejemplo guarda el resultado en texto
    @Lob
    private String resultados;

    @Override
    public void generar() {
        // lógica para generar el reporte (p.ej., consulta a la DB)
    }
    
}
