/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import modelo.FamiliaAdoptante;
import modelo.Gato;
import modelo.HistorialMedico;
import modelo.Tarea;
import modelo.TipoTarea;
import modelo.Usuario;
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

    public ControladoraPersistencia() {
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

    public List<Usuario> traerUsuarios(){
        return usuarioJpa.findUsuarioEntities();
    }
    
    
    // GATOS
    public void crearGato(Gato gato){
        GatoJpa.create(gato);
    }

    public List<Gato> traerGatos(){
        return GatoJpa.findGatoEntities();
    }
    

    // VOLUNTARIOS
    
    public Voluntario buscarVoluntarioPorNombre(String nombre) {
        VoluntarioJpaController volJpa = new VoluntarioJpaController();
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
    
}
