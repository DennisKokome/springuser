package co.bw.weblogic.springuser.service;

import co.bw.weblogic.springuser.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User findByUsername(String username);
    User findById(UUID id);
    void deleteById(UUID id);
}
