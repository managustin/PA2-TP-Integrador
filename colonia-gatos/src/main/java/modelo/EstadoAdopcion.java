/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo;

/**
 *
 * @author ms_ma
 */
public enum EstadoAdopcion {
    PENDIENTE,
    ACTIVA,
    CANCELADA;

    @Override
    public String toString() {
        return name();
    }
}