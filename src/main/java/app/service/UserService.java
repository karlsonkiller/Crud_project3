package app.service;

import app.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User foundUser(Integer id);
    void save(User user);
    void updateUser(Integer id, User user);
    void deleteUser(Integer id);
}
