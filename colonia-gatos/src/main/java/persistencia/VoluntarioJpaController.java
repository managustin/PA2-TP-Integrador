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
import modelo.Gato;
import java.util.ArrayList;
import java.util.List;
import modelo.Voluntario;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author ms_ma
 */
public class VoluntarioJpaController implements Serializable {

    public VoluntarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public VoluntarioJpaController() {
        emf = Persistence.createEntityManagerFactory("colonia-gatos_PU");
    }

    public void create(Voluntario voluntario) {
        if (voluntario.getGatosRegistrados() == null) {
            voluntario.setGatosRegistrados(new ArrayList<Gato>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Gato> attachedGatosRegistrados = new ArrayList<Gato>();
            for (Gato gatosRegistradosGatoToAttach : voluntario.getGatosRegistrados()) {
                gatosRegistradosGatoToAttach = em.getReference(gatosRegistradosGatoToAttach.getClass(), gatosRegistradosGatoToAttach.getId_gato());
                attachedGatosRegistrados.add(gatosRegistradosGatoToAttach);
            }
            voluntario.setGatosRegistrados(attachedGatosRegistrados);
            em.persist(voluntario);
            for (Gato gatosRegistradosGato : voluntario.getGatosRegistrados()) {
                Voluntario oldVolunOfGatosRegistradosGato = gatosRegistradosGato.getVolun();
                gatosRegistradosGato.setVolun(voluntario);
                gatosRegistradosGato = em.merge(gatosRegistradosGato);
                if (oldVolunOfGatosRegistradosGato != null) {
                    oldVolunOfGatosRegistradosGato.getGatosRegistrados().remove(gatosRegistradosGato);
                    oldVolunOfGatosRegistradosGato = em.merge(oldVolunOfGatosRegistradosGato);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Voluntario voluntario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Voluntario persistentVoluntario = em.find(Voluntario.class, voluntario.getId_usuario());
            List<Gato> gatosRegistradosOld = persistentVoluntario.getGatosRegistrados();
            List<Gato> gatosRegistradosNew = voluntario.getGatosRegistrados();
            List<Gato> attachedGatosRegistradosNew = new ArrayList<Gato>();
            for (Gato gatosRegistradosNewGatoToAttach : gatosRegistradosNew) {
                gatosRegistradosNewGatoToAttach = em.getReference(gatosRegistradosNewGatoToAttach.getClass(), gatosRegistradosNewGatoToAttach.getId_gato());
                attachedGatosRegistradosNew.add(gatosRegistradosNewGatoToAttach);
            }
            gatosRegistradosNew = attachedGatosRegistradosNew;
            voluntario.setGatosRegistrados(gatosRegistradosNew);
            voluntario = em.merge(voluntario);
            for (Gato gatosRegistradosOldGato : gatosRegistradosOld) {
                if (!gatosRegistradosNew.contains(gatosRegistradosOldGato)) {
                    gatosRegistradosOldGato.setVolun(null);
                    gatosRegistradosOldGato = em.merge(gatosRegistradosOldGato);
                }
            }
            for (Gato gatosRegistradosNewGato : gatosRegistradosNew) {
                if (!gatosRegistradosOld.contains(gatosRegistradosNewGato)) {
                    Voluntario oldVolunOfGatosRegistradosNewGato = gatosRegistradosNewGato.getVolun();
                    gatosRegistradosNewGato.setVolun(voluntario);
                    gatosRegistradosNewGato = em.merge(gatosRegistradosNewGato);
                    if (oldVolunOfGatosRegistradosNewGato != null && !oldVolunOfGatosRegistradosNewGato.equals(voluntario)) {
                        oldVolunOfGatosRegistradosNewGato.getGatosRegistrados().remove(gatosRegistradosNewGato);
                        oldVolunOfGatosRegistradosNewGato = em.merge(oldVolunOfGatosRegistradosNewGato);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = voluntario.getId_usuario();
                if (findVoluntario(id) == null) {
                    throw new NonexistentEntityException("The voluntario with id " + id + " no longer exists.");
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
            Voluntario voluntario;
            try {
                voluntario = em.getReference(Voluntario.class, id);
                voluntario.getId_usuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The voluntario with id " + id + " no longer exists.", enfe);
            }
            List<Gato> gatosRegistrados = voluntario.getGatosRegistrados();
            for (Gato gatosRegistradosGato : gatosRegistrados) {
                gatosRegistradosGato.setVolun(null);
                gatosRegistradosGato = em.merge(gatosRegistradosGato);
            }
            em.remove(voluntario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Voluntario> findVoluntarioEntities() {
        return findVoluntarioEntities(true, -1, -1);
    }

    public List<Voluntario> findVoluntarioEntities(int maxResults, int firstResult) {
        return findVoluntarioEntities(false, maxResults, firstResult);
    }

    private List<Voluntario> findVoluntarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Voluntario.class));
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

    public Voluntario findVoluntario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Voluntario.class, id);
        } finally {
            em.close();
        }
    }

    public int getVoluntarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Voluntario> rt = cq.from(Voluntario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
