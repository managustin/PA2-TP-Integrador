/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import modelo.Adopcion;
import modelo.EstadoAdopcion;
import modelo.FamiliaAdoptante;
import modelo.Gato;
import modelo.HistorialMedico;
import modelo.RegistroMedico;
import modelo.Tarea;
import modelo.TipoTarea;
import modelo.Usuario;
import modelo.Veterinario;
import modelo.Visita;
import modelo.Voluntario;
import modelo.Zona;

/**
 *
 * @author ms_ma
 */
public class ControladoraPersistencia {
    
    private AdministradorJpaController AdminJpa = new AdministradorJpaController();
    private GatoJpaController GatoJpa = new GatoJpaController();
    private TareaJpaController tareaJpa = new TareaJpaController();
    private FamiliaAdoptanteJpaController familiaJpa = new FamiliaAdoptanteJpaController();
    private UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    private AdopcionJpaController adopcionJpa = new AdopcionJpaController();
    private VisitaJpaController visitaJpa = new VisitaJpaController();
    private VeterinarioJpaController veterinarioJpa = new VeterinarioJpaController();
    private HistorialMedicoJpaController HistorialJpa = new HistorialMedicoJpaController();
    private RegistroMedicoJpaController RegistroJpa = new RegistroMedicoJpaController();
    private VoluntarioJpaController volJpa = new VoluntarioJpaController();

    public ControladoraPersistencia() {
    }
    
    // VETERINARIOS

    public void crearVeterinario(Veterinario veterinario){
        veterinarioJpa.create(veterinario);
    }

    public List<Veterinario> traerVeterinarios(){
        return veterinarioJpa.findVeterinarioEntities();
    }
    
    public void crearHistorial(HistorialMedico historial) {
        HistorialJpa.create(historial);
    }
    
    public List<RegistroMedico> traerRegistros(HistorialMedico historial) {
        EntityManager em = RegistroJpa.getEntityManager();
        List<RegistroMedico> lista = em.createQuery(
            "SELECT r FROM RegistroMedico r WHERE r.historial = :h", RegistroMedico.class)
            .setParameter("h", historial)
            .getResultList();

        return lista != null ? lista : List.of();
    }
    
    public void crearRegistroMedico(RegistroMedico reg) {
        RegistroJpa.create(reg);
    }    
            
    // USUARIOS
    
    public Usuario validarLogin(String email, String password) {
        List<Usuario> usuarios = usuarioJpa.findUsuarioEntities();

        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public void crearUsuario(Usuario usuario) {
        usuarioJpa.create(usuario);
    }
    public void crearVoluntario(Voluntario voluntario) {
        usuarioJpa.create(voluntario);
    }

    public List<Usuario> traerUsuarios(){
        return usuarioJpa.findUsuarioEntities();
    }
    
    public void eliminarUsuario(int id) {
        try {
            usuarioJpa.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar usuario: " + e.getMessage(), e);
        }
    }
   
    // ADOPCIONES
    
    public List<Adopcion> traerAdopciones() {
        return adopcionJpa.findAdopcionEntities();
    }   

    public void crearAdopcion(Adopcion adopcion) {
        adopcionJpa.create(adopcion);
    }
    public boolean existePostulacion(Gato gato, FamiliaAdoptante familia) {
        List<Adopcion> adopciones = adopcionJpa.findAdopcionEntities();

        for (Adopcion a : adopciones) {
            if (a.getMichi().getId_gato() == gato.getId_gato() // comparar por id
                    && a.getFamilia().getId_usuario() == familia.getId_usuario()
                    && a.getEstado() == EstadoAdopcion.PENDIENTE) {
                return true;
            }
        }
        return false;
    }
    
    public List<Adopcion> traerPostulacionesPendientesPorGato(Gato gato) {
        List<Adopcion> adopciones = adopcionJpa.findAdopcionEntities();
        List<Adopcion> pendientes = new ArrayList<>();

        for (Adopcion a : adopciones) {
            if (a.getMichi().getId_gato() == gato.getId_gato()
                    && a.getEstado() == EstadoAdopcion.PENDIENTE) {
                pendientes.add(a);
            }
        }

        return pendientes;
    }

    public void actualizarAdopcion(Adopcion adopcion) {
        try {
            adopcionJpa.edit(adopcion);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Adopcion traerAdopcionAceptada(Gato gato) {
        List<Adopcion> adopciones = adopcionJpa.findAdopcionEntities();

        for (Adopcion a : adopciones) {
            if (a.getMichi().getId_gato() == gato.getId_gato() 
                    && a.getEstado() == EstadoAdopcion.ACTIVA) {
                return a;
            }
        }
        return null;
    }
    
    public boolean tieneAdopcionActiva(Gato gato) {
        return traerAdopcionAceptada(gato) != null;
    }

    public boolean tienePostulacionesPendientes(Gato gato) {
        return !traerPostulacionesPendientesPorGato(gato).isEmpty();
    }

    // GATOS
    public void crearGato(Gato gato){
        GatoJpa.create(gato);
    }

    public List<Gato> traerGatos(){
        return GatoJpa.findGatoEntities();
    }
    
    // VISITAS
    
    // Traer todas las visitas de seguimiento de un gato

    public List<Visita> traerVisitasPorGato(Gato gato) {
        EntityManager em = visitaJpa.getEntityManager();
        try {
            TypedQuery<Visita> query = em.createQuery(
                "SELECT v FROM Visita v WHERE v.adop.michi.id_gato = :idGato",
                Visita.class
            );
            query.setParameter("idGato", gato.getId_gato());
            return query.getResultList();
        } finally {
            em.close();
        }
    }


    // Crear una nueva visita
    public void crearVisita(Visita visita) {
        visitaJpa.create(visita); 
    }


    // VOLUNTARIOS
    
    public List<Voluntario> traerVoluntarios() {
        return volJpa.findVoluntarioEntities();
    }
    
    public Voluntario buscarVoluntarioPorNombre(String nombre) {
        
        EntityManager em = volJpa.getEntityManager();
        try {
            TypedQuery<Voluntario> query = em.createQuery(
                "SELECT v FROM Voluntario v WHERE v.nombre = :nombre",
                Voluntario.class
            );
            query.setParameter("nombre", nombre);
            List<Voluntario> resultado = query.getResultList();

            return resultado.isEmpty() ? null : resultado.get(0);
        } finally {
            em.close();
        }
    }



    
    // TAREAS POR GATO
    
    public List<Tarea> traerTareasPorGato(int idGato) {
    return tareaJpa.findTareaEntities()
                   .stream()
                   .filter(t -> t.getMichi().getId_gato() == idGato)
                   .toList();
    }
    
    public void crearTarea(Tarea tarea){
    tareaJpa.create(tarea);
    }
    
    
    //ZONAS
    
    ZonaJpaController ZonaJpa = new ZonaJpaController();
    
    public void crearZona(Zona zona){
        ZonaJpa.create(zona);
    }
    public List<Zona> traerZonas(){
        return ZonaJpa.findZonaEntities();
    }
    
    //  FAMILIA ADOPTANTE
    public void crearFamiliaAdoptante(FamiliaAdoptante familia) {
        familiaJpa.create(familia);
    }

    public List<FamiliaAdoptante> traerFamilias() {
        return familiaJpa.findFamiliaAdoptanteEntities();
    }
    
    public Zona buscarZonaPorNombre(String nombre) {
        EntityManager em = ZonaJpa.getEntityManager();
        try {
            TypedQuery<Zona> query = em.createQuery(
                    "SELECT z FROM Zona z WHERE z.nombre = :n",
                    Zona.class);
            query.setParameter("n", nombre);
            List<Zona> res = query.getResultList();
            return res.isEmpty() ? null : res.get(0);
        } finally {
            em.close();
        }
    }
    
    public void eliminarZona(Zona zona) {
        try {
            ZonaJpa.destroy(zona.getId_zona());
        } catch (Exception e) {

            // Si la causa es una constraint (zona usada por gatos)
            if (e.getCause() != null && e.getCause().getCause() instanceof java.sql.SQLIntegrityConstraintViolationException) {
                throw new RuntimeException("NO_SE_PUEDE_ELIMINAR_ZONA_REFERENCIADA");
            }

            // Cualquier otro error real
            throw new RuntimeException(e);
        }
    }



    
}
