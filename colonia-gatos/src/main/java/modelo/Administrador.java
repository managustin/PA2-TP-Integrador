/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jakarta.persistence.Entity;

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
public class Administrador extends Usuario{

    public Administrador() {
    }

    public Administrador(String nom, String email, String password) {
        super(nom, email, password);
    }
}

