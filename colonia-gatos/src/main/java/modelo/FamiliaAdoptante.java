/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.io.Serializable;

/**
 *
 * @author Mango
 */
@Entity
public class FamiliaAdoptante extends Usuario implements Serializable {

    private String direccion;
    
    @OneToMany (mappedBy="familia")
    private List<Adopcion> adopciones = new ArrayList<>();

    public FamiliaAdoptante() {
    }

    public FamiliaAdoptante(String direccion, int id_usuario, String nombre, String email, String password) {
        super(id_usuario, nombre, email, password);
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
