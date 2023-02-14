package web.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import web.model.User;
@Repository
public class UserDaolmpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<User> showAllUsers() {
        TypedQuery<User> query= entityManager.createQuery("FROM User ", User.class);
        return query.getResultList();
    }
    @Override
    public List<User> showUserId(int id) {
        TypedQuery<User> query= entityManager.createQuery("FROM User WHERE id=:id", User.class);
        return query.getResultList();
    }
    @Override
    public void saveUser(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }
    @Override
    public void updateUser(int id, User updateUser) {
        EntityManager em = getEntityManager();
        User user = em.find(User.class, id);
        em.detach(user);
        em.getTransaction().begin();
        entityManager.merge(updateUser);
        em.getTransaction().commit();
    }

    @Override
    public void deleteUser(int id) {
        entityManager.createQuery("DELETE FROM User WHERE id=:id", User.class);
    }
}
