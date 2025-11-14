/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Controlador;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.SwingUtilities;
import modelo.EstadoSalud;
import modelo.FamiliaAdoptante;
import modelo.Gato;
import modelo.HistorialMedico;
import modelo.Veterinario;
import persistencia.ControladoraPersistencia;
import vista.VentanaInicioSesion;

import com.formdev.flatlaf.FlatDarkLaf;
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
        
         /*   // Cargar gatos de prueba si no hay ninguno en la base - DESCOMENTAR Y MODIFICAR RUTAS PARA PONER IMAGENES DE GATOS DE PRUEBA, QUE COINCIDAN CON LOS NOMBRES
        if (controlPersis.traerGatos().isEmpty()) {
            System.out.println("No hay gatos, creando gatos de prueba...");

            Zona zonaCentro = new Zona();
            zonaCentro.setNombre("Centro");
            controlPersis.crearZona(zonaCentro);
            
            // Crear historial y persistirlo
            HistorialMedico hist1 = new HistorialMedico();
            historialJpa.create(hist1);
                     
            Gato g1 = new Gato();
            g1.setNombre("Michi");
            g1.setColor("Blanco");
            g1.setCaracteristicas("Tranquilo y sociable");
            
            
            byte[] bytes1  = null;
            try {
                Path path = Paths.get("C:\\Datos\\Ingeniería\\2025\\Segundo Cuatrimestre\\Programación Avanzada II\\TP Final 2025\\PA2-TP-Integrador\\imagenes\\gato1.jpg");
                if (!Files.exists(path)) {
                    System.out.println("NO ENCUENTRA LA IMAGEN");
                }
                bytes1  = Files.readAllBytes(path);
            } catch (IOException e) {
                e.printStackTrace();
                // Podés decidir qué hacer: dejar null, tirar una runtime, etc.
            }
            System.out.println("\n\n\n\nBytes leídos: " + bytes1.length + "\n\n\n\n");
            g1.setFoto(bytes1);

            g1.setQr("QR001");
            g1.setEsterilizado(true);
            g1.setEstadoSalud(EstadoSalud.SANO);
            g1.setZona(zonaCentro); 
            g1.setHistorial(hist1);

            
            Zona zonaNorte = new Zona();
            zonaNorte.setNombre("Norte");
            controlPersis.crearZona(zonaNorte);
            
            // historial 2
            HistorialMedico hist2 = new HistorialMedico();
            historialJpa.create(hist2);
            
            Gato g2 = new Gato();
            g2.setNombre("Negra");
            g2.setColor("Negro");
            g2.setCaracteristicas("Curiosa y activa");
            
            byte[] bytes2  = null;
            try {
                Path path = Paths.get("C:\\Datos\\Ingeniería\\2025\\Segundo Cuatrimestre\\Programación Avanzada II\\TP Final 2025\\PA2-TP-Integrador\\imagenes\\gato2.jpg");
                bytes2  = Files.readAllBytes(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            g2.setFoto(bytes2);
            
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
            System.out.println("\n\n\n\n\n\n\nYa hay gatos en la base, no se insertan de nuevo.\n\n\n\n\n");
        }*/
        
        
        // Cargar veterinarios si no hay ninguno
        if (controlPersis.traerVeterinarios().isEmpty()) {

            System.out.println("No hay veterinarios, creando veterinarios de prueba...");

            Veterinario v1 = new Veterinario();
            v1.setNombre("Dr. López");
            v1.setEmail("drlopez@example.com");
            v1.setPassword("1234");
            v1.setTelefono("111-222");

            // Como Usuario usa SINGLE_TABLE, JPA se encarga de poner DTYPE=VETERINARIO
            controlPersis.crearVeterinario(v1);

            Veterinario v2 = new Veterinario();
            v2.setNombre("Dra. Pérez");
            v2.setEmail("draperez@example.com");
            v2.setPassword("abcd");
            v2.setTelefono("333-444");

            controlPersis.crearVeterinario(v2);
        }else {
            System.out.println("\n\n\n\n\n\n\nYa hay veterinarios en la base, no se insertan de nuevo.\n\n\n\n\n");
        }

        
        
        SwingUtilities.invokeLater(() -> {
            FlatDarkLaf.setup();
            VentanaInicioSesion v = new VentanaInicioSesion();
            LoginControlador ctrl = new LoginControlador(v);
            v.setLocationRelativeTo(null); // centra en pantalla
            v.setVisible(true);
        });
        
        
    }
}
