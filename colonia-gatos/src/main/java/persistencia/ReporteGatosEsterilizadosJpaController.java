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
import modelo.ReporteGatosEsterilizados;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author ms_ma
 */
public class ReporteGatosEsterilizadosJpaController implements Serializable {

    public ReporteGatosEsterilizadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public ReporteGatosEsterilizadosJpaController() {
        emf = Persistence.createEntityManagerFactory("colonia-gatos_PU");
    }

    public void create(ReporteGatosEsterilizados reporteGatosEsterilizados) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(reporteGatosEsterilizados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ReporteGatosEsterilizados reporteGatosEsterilizados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            reporteGatosEsterilizados = em.merge(reporteGatosEsterilizados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = reporteGatosEsterilizados.getId_reporte();
                if (findReporteGatosEsterilizados(id) == null) {
                    throw new NonexistentEntityException("The reporteGatosEsterilizados with id " + id + " no longer exists.");
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
            ReporteGatosEsterilizados reporteGatosEsterilizados;
            try {
                reporteGatosEsterilizados = em.getReference(ReporteGatosEsterilizados.class, id);
                reporteGatosEsterilizados.getId_reporte();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reporteGatosEsterilizados with id " + id + " no longer exists.", enfe);
            }
            em.remove(reporteGatosEsterilizados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ReporteGatosEsterilizados> findReporteGatosEsterilizadosEntities() {
        return findReporteGatosEsterilizadosEntities(true, -1, -1);
    }

    public List<ReporteGatosEsterilizados> findReporteGatosEsterilizadosEntities(int maxResults, int firstResult) {
        return findReporteGatosEsterilizadosEntities(false, maxResults, firstResult);
    }

    private List<ReporteGatosEsterilizados> findReporteGatosEsterilizadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ReporteGatosEsterilizados.class));
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

    public ReporteGatosEsterilizados findReporteGatosEsterilizados(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ReporteGatosEsterilizados.class, id);
        } finally {
            em.close();
        }
    }

    public int getReporteGatosEsterilizadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ReporteGatosEsterilizados> rt = cq.from(ReporteGatosEsterilizados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
