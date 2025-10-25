/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colonia.gatos;

/**
 *
 * @author Mango
 */
public class Gato {
    private int id;
    private String nombre;
    private String color;
    private String caracteristicas;
    private String foto;
    private String zona;
    private EstadoSalud estadoSalud;
    private String qr;
    private boolean esterilizado;

    public Gato(int id, String nombre, String color, String caracteristicas, String foto, String zona, EstadoSalud estadoSalud, String qr, boolean esterilizado) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.caracteristicas = caracteristicas;
        this.foto = foto;
        this.zona = zona;
        this.estadoSalud = estadoSalud;
        this.qr = qr;
        this.esterilizado = esterilizado;
    }
    
    public void actualizarEstado(EstadoSalud salud){
        this.estadoSalud = salud;
    }
}
