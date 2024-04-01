package app.service;

import app.model.User;
import app.repositories.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepos userService;

    @Autowired
    public UserService(UserRepos userService) {
        this.userService = userService;
    }

    public List<User> getAllUser() {
        return userService.findAll();
    }

    public User foundUser(Integer id) {
        Optional<User> foundUser = userService.findById(id);
        return foundUser.orElse(null);
    }

    @Transactional
    public void save(User user) {
        userService.save(user);
    }

    @Transactional
    public void updateUser(Integer id, User user){
        user.setId(id);
        userService.save(user);
    }

    @Transactional
    public void deleteUser(Integer id) {
        userService.deleteById(id);
    }

}
