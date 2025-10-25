/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colonia.gatos;

/**
 *
 * @author Mango
 */
public class FamiliaAdoptante extends Usuario {

    private String direccion;

    public FamiliaAdoptante(String direccion, String nom, String email, String password) {
        super(nom, email, password);
        this.direccion = direccion;
    }

    public FamiliaAdoptante(String direccion, int id, String nom, String email, String password) {
        super(id, nom, email, password);
        this.direccion = direccion;
    }
    
    public void verPerfilesGatos(){
        // Según la clase UML debería retornar una lista de gatos,
        //pero capaz no sea la mejor opción poner acá un método que haría lo mismo que otras funciones en todo el tpi.
    }
    
}
