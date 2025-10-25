/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author ms_ma
 */
public class RegistroMedico {
    private int id;
    private TipoRegistroMedico tipo;
    private LocalDate fecha;
    private String descripcion;
    private String archivoEstudio;

    public RegistroMedico(int id, TipoRegistroMedico tipo, LocalDate fecha, String descripcion, String archivoEstudio) {
        this.id = id;
        this.tipo = tipo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.archivoEstudio = archivoEstudio;
    }
}
