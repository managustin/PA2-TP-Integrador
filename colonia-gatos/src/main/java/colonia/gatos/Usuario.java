/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colonia.gatos;

/**
 *
 * @author ms_ma
 */
public class Usuario {
    
    int id;
    String nombre, email, password;
    
    Usuario(int id, String nom, String email, String password){
        this.id = id;
        this.nombre = nom;
        this.email = email;
        this.password = password;
    }
    
    public int verId(){
        return this.id;
    }
    
    public String verNombre(){
        return this.nombre;
    }
}
