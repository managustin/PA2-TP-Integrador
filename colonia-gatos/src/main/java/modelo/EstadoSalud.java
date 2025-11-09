/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo;

/**
 *
 * @author Mango
 */
public enum EstadoSalud {
    
    ENFERMO,
    SANO,
    EN_TRATAMIENTO;
    
    @Override
    public String toString() {
        return name();
    }
}
