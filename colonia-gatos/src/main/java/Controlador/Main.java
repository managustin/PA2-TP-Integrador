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
import modelo.EstadoSalud;
import modelo.FamiliaAdoptante;
import modelo.Gato;
import modelo.HistorialMedico;
import modelo.Zona;
import persistencia.ControladoraPersistencia;
import persistencia.HistorialMedicoJpaController;
import persistencia.ZonaJpaController;
import vista.VentanaInicioSesion;
/**
 *
 * @author ms_ma
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de la colonia de gatos");
        /*
        Usuario u1 = new Usuario(1, "Juan", "correo@correo.com", "conTrasenia");
        System.out.println("El usuario u1 tiene el id " + u1.verId()+ " y el nombre es " + u1.verNombre());
        
        TipoTarea tipo1 = TipoTarea.ALIMENTACION;
        LocalDate fechaHoy = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        Tarea t1 = new Tarea(tipo1, fechaHoy, horaActual, "Calle 1", "Se observan observaciones");
        t1.setObservaciones("Se observan más observaciones");
        
        System.out.println(t1.getObservaciones());
        */
        
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        ZonaJpaController zonaJpa = new ZonaJpaController();
        HistorialMedicoJpaController historialJpa = new HistorialMedicoJpaController();
        
            // Cargar gatos de prueba si no hay ninguno en la base
        if (controlPersis.traerGatos().isEmpty()) {
            System.out.println("No hay gatos, creando gatos de prueba...");

            Zona zonaCentro = new Zona();
            zonaCentro.setNombre("Centro");
            zonaJpa.create(zonaCentro);
            
            // Crear historial y persistirlo
            HistorialMedico hist1 = new HistorialMedico();
            historialJpa.create(hist1);
                     
            Gato g1 = new Gato();
            g1.setNombre("Michi");
            g1.setColor("Blanco");
            g1.setCaracteristicas("Tranquilo y sociable");
            g1.setFoto("gato1.jpg");
            g1.setQr("QR001");
            g1.setEsterilizado(true);
            g1.setEstadoSalud(EstadoSalud.SANO);
            g1.setZona(zonaCentro); 
            g1.setHistorial(hist1);

            
            Zona zonaNorte = new Zona();
            zonaNorte.setNombre("Norte");
            zonaJpa.create(zonaNorte);
            
            // historial 2
            HistorialMedico hist2 = new HistorialMedico();
            historialJpa.create(hist2);
            
            Gato g2 = new Gato();
            g2.setNombre("Negra");
            g2.setColor("Negro");
            g2.setCaracteristicas("Curiosa y activa");
            g2.setFoto("gato2.jpg");
            g2.setQr("QR002");
            g2.setEsterilizado(false);
            g2.setEstadoSalud(EstadoSalud.EN_TRATAMIENTO);
            g2.setZona(zonaNorte);
            g2.setHistorial(hist2);

            // Persistir
            controlPersis.crearGato(g1);
            controlPersis.crearGato(g2);

            System.out.println("Gatos insertados en la base de datos.");
        } else {
            System.out.println("Ya hay gatos en la base, no se insertan de nuevo.");
        }
        
        SwingUtilities.invokeLater(() -> {
            VentanaInicioSesion v = new VentanaInicioSesion();
            LoginControlador ctrl = new LoginControlador(v);
            v.setLocationRelativeTo(null); // centra en pantalla
            v.setVisible(true);
        });
        
        
    }
}
