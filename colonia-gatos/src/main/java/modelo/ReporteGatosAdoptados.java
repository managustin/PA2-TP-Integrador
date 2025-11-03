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
public class ReporteGatosAdoptados extends Reporte {

    public ReporteGatosAdoptados(Date fechaGeneracion) {
        super(fechaGeneracion);
    }

    @OneToMany
    private List<Gato> gatosAdoptados;

    @Override
    public void generar() {
        // lógica para obtener gatos con adopciones activas o finalizadas
    }
    
}
