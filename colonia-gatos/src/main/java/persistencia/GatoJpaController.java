/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import modelo.Voluntario;
import modelo.Tarea;
import java.util.ArrayList;
import java.util.List;
import modelo.Gato;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author ms_ma
 */
public class GatoJpaController implements Serializable {

    public GatoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public GatoJpaController() {
        emf = Persistence.createEntityManagerFactory("colonia-gatos_PU");
    }

    public void create(Gato gato) {
        if (gato.getTareas() == null) {
            gato.setTareas(new ArrayList<Tarea>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Voluntario volun = gato.getVolun();
            if (volun != null) {
                volun = em.getReference(volun.getClass(), volun.getId_usuario());
                gato.setVolun(volun);
            }
            List<Tarea> attachedTareas = new ArrayList<Tarea>();
            for (Tarea tareasTareaToAttach : gato.getTareas()) {
                tareasTareaToAttach = em.getReference(tareasTareaToAttach.getClass(), tareasTareaToAttach.getId_tarea());
                attachedTareas.add(tareasTareaToAttach);
            }
            gato.setTareas(attachedTareas);
            em.persist(gato);
            if (volun != null) {
                volun.getGatosRegistrados().add(gato);
                volun = em.merge(volun);
            }
            for (Tarea tareasTarea : gato.getTareas()) {
                Gato oldMichiOfTareasTarea = tareasTarea.getMichi();
                tareasTarea.setMichi(gato);
                tareasTarea = em.merge(tareasTarea);
                if (oldMichiOfTareasTarea != null) {
                    oldMichiOfTareasTarea.getTareas().remove(tareasTarea);
                    oldMichiOfTareasTarea = em.merge(oldMichiOfTareasTarea);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Gato gato) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gato persistentGato = em.find(Gato.class, gato.getId_gato());
            Voluntario volunOld = persistentGato.getVolun();
            Voluntario volunNew = gato.getVolun();
            List<Tarea> tareasOld = persistentGato.getTareas();
            List<Tarea> tareasNew = gato.getTareas();
            if (volunNew != null) {
                volunNew = em.getReference(volunNew.getClass(), volunNew.getId_usuario());
                gato.setVolun(volunNew);
            }
            List<Tarea> attachedTareasNew = new ArrayList<Tarea>();
            for (Tarea tareasNewTareaToAttach : tareasNew) {
                tareasNewTareaToAttach = em.getReference(tareasNewTareaToAttach.getClass(), tareasNewTareaToAttach.getId_tarea());
                attachedTareasNew.add(tareasNewTareaToAttach);
            }
            tareasNew = attachedTareasNew;
            gato.setTareas(tareasNew);
            gato = em.merge(gato);
            if (volunOld != null && !volunOld.equals(volunNew)) {
                volunOld.getGatosRegistrados().remove(gato);
                volunOld = em.merge(volunOld);
            }
            if (volunNew != null && !volunNew.equals(volunOld)) {
                volunNew.getGatosRegistrados().add(gato);
                volunNew = em.merge(volunNew);
            }
            for (Tarea tareasOldTarea : tareasOld) {
                if (!tareasNew.contains(tareasOldTarea)) {
                    tareasOldTarea.setMichi(null);
                    tareasOldTarea = em.merge(tareasOldTarea);
                }
            }
            for (Tarea tareasNewTarea : tareasNew) {
                if (!tareasOld.contains(tareasNewTarea)) {
                    Gato oldMichiOfTareasNewTarea = tareasNewTarea.getMichi();
                    tareasNewTarea.setMichi(gato);
                    tareasNewTarea = em.merge(tareasNewTarea);
                    if (oldMichiOfTareasNewTarea != null && !oldMichiOfTareasNewTarea.equals(gato)) {
                        oldMichiOfTareasNewTarea.getTareas().remove(tareasNewTarea);
                        oldMichiOfTareasNewTarea = em.merge(oldMichiOfTareasNewTarea);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = gato.getId_gato();
                if (findGato(id) == null) {
                    throw new NonexistentEntityException("The gato with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gato gato;
            try {
                gato = em.getReference(Gato.class, id);
                gato.getId_gato();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gato with id " + id + " no longer exists.", enfe);
            }
            Voluntario volun = gato.getVolun();
            if (volun != null) {
                volun.getGatosRegistrados().remove(gato);
                volun = em.merge(volun);
            }
            List<Tarea> tareas = gato.getTareas();
            for (Tarea tareasTarea : tareas) {
                tareasTarea.setMichi(null);
                tareasTarea = em.merge(tareasTarea);
            }
            em.remove(gato);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Gato> findGatoEntities() {
        return findGatoEntities(true, -1, -1);
    }

    public List<Gato> findGatoEntities(int maxResults, int firstResult) {
        return findGatoEntities(false, maxResults, firstResult);
    }

    private List<Gato> findGatoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Gato.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Gato findGato(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gato.class, id);
        } finally {
            em.close();
        }
    }

    public int getGatoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Gato> rt = cq.from(Gato.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
