/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colonia.gatos;

/**
 *
 * @author Mango
 */
public class Voluntario extends Usuario {
    String zona;

    public Voluntario(String zona, String nom, String email, String password) {
        super(nom, email, password);
        this.zona = zona;
    }

    public Voluntario(String zona, int id, String nom, String email, String password) {
        super(id, nom, email, password);
        this.zona = zona;
    }
    
    
}
