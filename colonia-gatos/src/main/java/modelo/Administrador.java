/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jakarta.persistence.Entity;
import java.io.Serializable;

/**
 *
 * @author ms_ma
 * 
 * La idea de esta clase es dar alta, baja y modificación de roles internos (otros administradores, voluntarios, veterinarios 
 * y en casos raros de familias adoptantes.
 * 
 * Forma en que supongo resolver esto es que solo un usuario instanceof Administrador pueda acceder a ciertas ventanas de la vista 
 * , esto lo comprobaría el controlador
 */
@Entity
public class Administrador extends Usuario implements Serializable{

    public Administrador() {
    }

    public Administrador(int id_usuario, String nombre, String email, String password) {
        super(id_usuario, nombre, email, password);
    }
}

