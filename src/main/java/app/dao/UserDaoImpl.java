package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUser() {
        return entityManager.createQuery("select user from User user ", User.class).getResultList();
    }

    @Override
    @Transactional
    public User foundUser(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(Integer id, User update_user) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            user.setFirstName(update_user.getFirstName());
            user.setLastName(update_user.getLastName());
            user.setAge(update_user.getAge());
            entityManager.merge(user);
        }
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
