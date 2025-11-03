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
import modelo.FamiliaAdoptante;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author ms_ma
 */
public class FamiliaAdoptanteJpaController implements Serializable {

    public FamiliaAdoptanteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public FamiliaAdoptanteJpaController() {
        emf = Persistence.createEntityManagerFactory("colonia-gatos_PU");
    }

    public void create(FamiliaAdoptante familiaAdoptante) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(familiaAdoptante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FamiliaAdoptante familiaAdoptante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            familiaAdoptante = em.merge(familiaAdoptante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = familiaAdoptante.getId_usuario();
                if (findFamiliaAdoptante(id) == null) {
                    throw new NonexistentEntityException("The familiaAdoptante with id " + id + " no longer exists.");
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
            FamiliaAdoptante familiaAdoptante;
            try {
                familiaAdoptante = em.getReference(FamiliaAdoptante.class, id);
                familiaAdoptante.getId_usuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The familiaAdoptante with id " + id + " no longer exists.", enfe);
            }
            em.remove(familiaAdoptante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FamiliaAdoptante> findFamiliaAdoptanteEntities() {
        return findFamiliaAdoptanteEntities(true, -1, -1);
    }

    public List<FamiliaAdoptante> findFamiliaAdoptanteEntities(int maxResults, int firstResult) {
        return findFamiliaAdoptanteEntities(false, maxResults, firstResult);
    }

    private List<FamiliaAdoptante> findFamiliaAdoptanteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FamiliaAdoptante.class));
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

    public FamiliaAdoptante findFamiliaAdoptante(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FamiliaAdoptante.class, id);
        } finally {
            em.close();
        }
    }

    public int getFamiliaAdoptanteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FamiliaAdoptante> rt = cq.from(FamiliaAdoptante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
