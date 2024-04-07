package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public List<User> foundUser(Integer id) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void updateUser(Integer id, User user) {

    }

    @Override
    public void deleteUser(Integer id) {

    }
}
