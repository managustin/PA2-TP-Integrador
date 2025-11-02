/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;

/**
 *
 * @author Mango
 */
@Entity
public class FamiliaAdoptante extends Usuario {

    private String direccion;

    public FamiliaAdoptante() {
    }

    public FamiliaAdoptante(String direccion, String nom, String email, String password) {
        super(nom, email, password);
        this.direccion = direccion;
    }
    
    public List<Gato> verPerfilesGatos(){
        // Según la clase UML debería retornar una lista de gatos,
        //pero capaz no sea la mejor opción poner acá un método que haría lo mismo que otras funciones en todo el tpi.
        // pero según la profe sí 
        // acá hago una lista dummy para probar antes de agregar db
        
        List<Gato> gatos = new ArrayList<>();
        gatos.add(new Gato());
        return gatos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
