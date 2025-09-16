/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colonia.gatos;

/**
 *
 * @author ms_ma
 */
public class Administrador extends Usuario{
    
    Administrador(String nombre, String email, String password){
        super(nombre, email, password);
    }
    
    public Usuario registrarUsuario(String nombre, String email, String password){
        
        return new Usuario(nombre, email, password);
    }
}
