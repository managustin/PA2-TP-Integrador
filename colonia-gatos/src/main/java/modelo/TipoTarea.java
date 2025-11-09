/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo;

/**
 *
 * @author ms_ma
 */
public enum TipoTarea {
    ALIMENTACION,
    CAPTURA_PARA_CASTRACION,
    CONTROL_VETERINARIO,
    TRANSPORTE_A_HOGAR_TRANSITORIO;
    
    @Override
    public String toString() {
        return name().replace("_", " ").toLowerCase(); // o formateo que quieras
    }
}
