/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Controlador;

import modelo.Tarea;
import modelo.TipoTarea;
import modelo.Usuario;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.SwingUtilities;
import vista.VentanaInicioSesion;
/**
 *
 * @author ms_ma
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de la colonia de gatos");
        
        Usuario u1 = new Usuario(1, "Juan", "correo@correo.com", "conTrasenia");
        System.out.println("El usuario u1 tiene el id " + u1.verId()+ " y el nombre es " + u1.verNombre());
        
        TipoTarea tipo1 = TipoTarea.ALIMENTACION;
        LocalDate fechaHoy = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        Tarea t1 = new Tarea(tipo1, fechaHoy, horaActual, "Calle 1", "Se observan observaciones");
        t1.setObservaciones("Se observan más observaciones");
        
        System.out.println(t1.getObservaciones());
        
        
        SwingUtilities.invokeLater(() -> {
            VentanaInicioSesion v = new VentanaInicioSesion();
            v.setLocationRelativeTo(null); // centra en pantalla
            v.setVisible(true);
        });
    }
}
