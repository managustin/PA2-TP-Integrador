/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colonia.gatos;

/**
 *
 * @author ms_ma
 */
public class Zona {
    
    private int id;
    private String nombre;
    
    Zona(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
}
