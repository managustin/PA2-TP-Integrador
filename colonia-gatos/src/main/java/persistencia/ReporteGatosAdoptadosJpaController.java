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
import modelo.ReporteGatosAdoptados;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author ms_ma
 */
public class ReporteGatosAdoptadosJpaController implements Serializable {

    public ReporteGatosAdoptadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public ReporteGatosAdoptadosJpaController() {
        emf = Persistence.createEntityManagerFactory("colonia-gatos_PU");
    }

    public void create(ReporteGatosAdoptados reporteGatosAdoptados) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(reporteGatosAdoptados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ReporteGatosAdoptados reporteGatosAdoptados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            reporteGatosAdoptados = em.merge(reporteGatosAdoptados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = reporteGatosAdoptados.getId_reporte();
                if (findReporteGatosAdoptados(id) == null) {
                    throw new NonexistentEntityException("The reporteGatosAdoptados with id " + id + " no longer exists.");
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
            ReporteGatosAdoptados reporteGatosAdoptados;
            try {
                reporteGatosAdoptados = em.getReference(ReporteGatosAdoptados.class, id);
                reporteGatosAdoptados.getId_reporte();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reporteGatosAdoptados with id " + id + " no longer exists.", enfe);
            }
            em.remove(reporteGatosAdoptados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ReporteGatosAdoptados> findReporteGatosAdoptadosEntities() {
        return findReporteGatosAdoptadosEntities(true, -1, -1);
    }

    public List<ReporteGatosAdoptados> findReporteGatosAdoptadosEntities(int maxResults, int firstResult) {
        return findReporteGatosAdoptadosEntities(false, maxResults, firstResult);
    }

    private List<ReporteGatosAdoptados> findReporteGatosAdoptadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ReporteGatosAdoptados.class));
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

    public ReporteGatosAdoptados findReporteGatosAdoptados(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ReporteGatosAdoptados.class, id);
        } finally {
            em.close();
        }
    }

    public int getReporteGatosAdoptadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ReporteGatosAdoptados> rt = cq.from(ReporteGatosAdoptados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
