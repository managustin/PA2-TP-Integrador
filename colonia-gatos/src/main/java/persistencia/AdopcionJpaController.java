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
import modelo.Adopcion;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author ms_ma
 */
public class AdopcionJpaController implements Serializable {

    public AdopcionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public AdopcionJpaController() {
        emf = Persistence.createEntityManagerFactory("colonia-gatos_PU");
    }

    public void create(Adopcion adopcion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(adopcion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Adopcion adopcion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            adopcion = em.merge(adopcion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = adopcion.getId_adopcion();
                if (findAdopcion(id) == null) {
                    throw new NonexistentEntityException("The adopcion with id " + id + " no longer exists.");
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
            Adopcion adopcion;
            try {
                adopcion = em.getReference(Adopcion.class, id);
                adopcion.getId_adopcion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The adopcion with id " + id + " no longer exists.", enfe);
            }
            em.remove(adopcion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Adopcion> findAdopcionEntities() {
        return findAdopcionEntities(true, -1, -1);
    }

    public List<Adopcion> findAdopcionEntities(int maxResults, int firstResult) {
        return findAdopcionEntities(false, maxResults, firstResult);
    }

    private List<Adopcion> findAdopcionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Adopcion.class));
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

    public Adopcion findAdopcion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Adopcion.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdopcionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Adopcion> rt = cq.from(Adopcion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
