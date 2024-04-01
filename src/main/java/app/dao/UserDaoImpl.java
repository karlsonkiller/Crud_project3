package app.dao;

import app.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            try {
                sessionFactory.openSession().getTransaction().rollback();
            } catch (HibernateException e2) {
                System.out.println(e2.getMessage());
            }
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void editUser(User user) {
        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            try {
                sessionFactory.openSession().getTransaction().rollback();
            } catch (HibernateException e2) {
                System.out.println(e2.getMessage());
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User getUserId(int id) {
        return null;
    }

    @Override
    public void deleteUser(int id) {
        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.load(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            try {
                sessionFactory.openSession().getTransaction().rollback();
            } catch (HibernateException e2) {
                System.out.println(e2.getMessage());
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
