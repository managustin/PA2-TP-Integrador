/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ms_ma
 */
public class HistorialMedico {
    private List<RegistroMedico> registros = new ArrayList<>();
    
    public void agregarRegistro(RegistroMedico r){
        this.registros.add(r);
    }

    public List<RegistroMedico> getRegistros() {
        return registros;
    }
}
