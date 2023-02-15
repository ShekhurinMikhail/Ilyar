package web.DAO;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;
@Repository
public class UserDaoHiberImpl implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<User> showAllUsers() {
        TypedQuery<User> query= sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u ", User.class);
        return query.getResultList();
    }

    @Override
    public User showUserId(int id) {
        TypedQuery<User> query= sessionFactory
                .getCurrentSession()
                .createQuery("FROM User WHERE id=:id", User.class);
        query.setParameter("id",id);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(int id, User updateuser) {
        TypedQuery<User> query= sessionFactory
                .getCurrentSession()
                .createQuery("FROM User WHERE id=:id", User.class);
        query.setParameter("id",id);
        query.getResultList();
        sessionFactory.getCurrentSession().merge(updateuser);
    }

    @Override
    public void deleteUser(int id) {
        TypedQuery<User> query= sessionFactory
                .getCurrentSession()
                .createQuery("DELETE FROM User WHERE id=:id", User.class);
        query.setParameter("id",id);
    }
}
