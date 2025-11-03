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
import modelo.ReporteGatosPorZona;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author ms_ma
 */
public class ReporteGatosPorZonaJpaController implements Serializable {

    public ReporteGatosPorZonaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public ReporteGatosPorZonaJpaController() {
        emf = Persistence.createEntityManagerFactory("colonia-gatos_PU");
    }

    public void create(ReporteGatosPorZona reporteGatosPorZona) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(reporteGatosPorZona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ReporteGatosPorZona reporteGatosPorZona) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            reporteGatosPorZona = em.merge(reporteGatosPorZona);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = reporteGatosPorZona.getId_reporte();
                if (findReporteGatosPorZona(id) == null) {
                    throw new NonexistentEntityException("The reporteGatosPorZona with id " + id + " no longer exists.");
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
            ReporteGatosPorZona reporteGatosPorZona;
            try {
                reporteGatosPorZona = em.getReference(ReporteGatosPorZona.class, id);
                reporteGatosPorZona.getId_reporte();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reporteGatosPorZona with id " + id + " no longer exists.", enfe);
            }
            em.remove(reporteGatosPorZona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ReporteGatosPorZona> findReporteGatosPorZonaEntities() {
        return findReporteGatosPorZonaEntities(true, -1, -1);
    }

    public List<ReporteGatosPorZona> findReporteGatosPorZonaEntities(int maxResults, int firstResult) {
        return findReporteGatosPorZonaEntities(false, maxResults, firstResult);
    }

    private List<ReporteGatosPorZona> findReporteGatosPorZonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ReporteGatosPorZona.class));
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

    public ReporteGatosPorZona findReporteGatosPorZona(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ReporteGatosPorZona.class, id);
        } finally {
            em.close();
        }
    }

    public int getReporteGatosPorZonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ReporteGatosPorZona> rt = cq.from(ReporteGatosPorZona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
