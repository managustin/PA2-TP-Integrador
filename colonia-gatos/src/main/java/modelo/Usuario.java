/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ms_ma
 */
public class Usuario {
    
    private int id;
    private String nombre, email, password;
    
    public Usuario(String nom, String email, String password){
        this.nombre = nom;
        this.email = email;
        this.password = password;
    }
    
    public Usuario(int id, String nom, String email, String password){
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
