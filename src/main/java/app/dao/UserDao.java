package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    void addUser(User user);
    void editUser(User user);
    User getUserId(int id);
    void deleteUser(int id);
    List<User> getAllUsers();
}
