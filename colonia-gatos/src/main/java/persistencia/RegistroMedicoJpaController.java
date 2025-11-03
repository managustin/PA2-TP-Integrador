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
import java.util.List;
import modelo.HistorialMedico;
import modelo.RegistroMedico;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author ms_ma
 */
public class RegistroMedicoJpaController implements Serializable {

    public RegistroMedicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public RegistroMedicoJpaController() {
        emf = Persistence.createEntityManagerFactory("colonia-gatos_PU");
    }

    public void create(RegistroMedico registroMedico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistorialMedico historial = registroMedico.getHistorial();
            if (historial != null) {
                historial = em.getReference(historial.getClass(), historial.getId_historial());
                registroMedico.setHistorial(historial);
            }
            em.persist(registroMedico);
            if (historial != null) {
                historial.getRegistros().add(registroMedico);
                historial = em.merge(historial);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RegistroMedico registroMedico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RegistroMedico persistentRegistroMedico = em.find(RegistroMedico.class, registroMedico.getId_rm());
            HistorialMedico historialOld = persistentRegistroMedico.getHistorial();
            HistorialMedico historialNew = registroMedico.getHistorial();
            if (historialNew != null) {
                historialNew = em.getReference(historialNew.getClass(), historialNew.getId_historial());
                registroMedico.setHistorial(historialNew);
            }
            registroMedico = em.merge(registroMedico);
            if (historialOld != null && !historialOld.equals(historialNew)) {
                historialOld.getRegistros().remove(registroMedico);
                historialOld = em.merge(historialOld);
            }
            if (historialNew != null && !historialNew.equals(historialOld)) {
                historialNew.getRegistros().add(registroMedico);
                historialNew = em.merge(historialNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = registroMedico.getId_rm();
                if (findRegistroMedico(id) == null) {
                    throw new NonexistentEntityException("The registroMedico with id " + id + " no longer exists.");
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
            RegistroMedico registroMedico;
            try {
                registroMedico = em.getReference(RegistroMedico.class, id);
                registroMedico.getId_rm();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The registroMedico with id " + id + " no longer exists.", enfe);
            }
            HistorialMedico historial = registroMedico.getHistorial();
            if (historial != null) {
                historial.getRegistros().remove(registroMedico);
                historial = em.merge(historial);
            }
            em.remove(registroMedico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RegistroMedico> findRegistroMedicoEntities() {
        return findRegistroMedicoEntities(true, -1, -1);
    }

    public List<RegistroMedico> findRegistroMedicoEntities(int maxResults, int firstResult) {
        return findRegistroMedicoEntities(false, maxResults, firstResult);
    }

    private List<RegistroMedico> findRegistroMedicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RegistroMedico.class));
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

    public RegistroMedico findRegistroMedico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RegistroMedico.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegistroMedicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RegistroMedico> rt = cq.from(RegistroMedico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
