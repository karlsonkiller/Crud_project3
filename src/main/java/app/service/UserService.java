package app.service;

import app.model.User;
import app.repositories.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional()
public class UserService {

    private final UserRepos userRepo;

    @Autowired
    public UserService(UserRepos userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public User foundUser(Integer id) {
        Optional<User> foundUser = userRepo.findById(id);
        return foundUser.orElse(null);
    }

    @Transactional
    public void save(User user) {
        userRepo.save(user);
    }

    @Transactional
    public void updateUser(Integer id, User user){
        user.setId(id);
        userRepo.save(user);
    }

    @Transactional
    public void deleteUser(Integer id) {
        userRepo.deleteById(id);
    }

}