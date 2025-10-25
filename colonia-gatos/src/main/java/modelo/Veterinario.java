/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;

/**
 *
 * @author ms_ma
 */
public class Veterinario extends Usuario {

    
    
    public Veterinario(String nom, String email, String password) {
        super(nom, email, password);
    }

    public Veterinario(int id, String nom, String email, String password) {
        super(id, nom, email, password);
    }
    
    
    public HistorialMedico accederHistorial(Gato g){
        return g.getHistorial();
    }
    public void crearRegistro(Gato g, RegistroMedico r){
        g.getHistorial().agregarRegistro(r);
    }
    public List<RegistroMedico> emitirCertificado(Gato g, String descripcion){
        return g.getHistorial().getRegistros();
    }
    
}
