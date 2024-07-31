package co.bw.weblogic.springuser.service;

import co.bw.weblogic.springuser.model.User;
import co.bw.weblogic.springuser.util.HttpResponse;
import co.bw.weblogic.springuser.util.UsernameExistException;

import java.util.List;
import java.util.UUID;

public interface UserService {
    HttpResponse<User> save(User user) throws UsernameExistException;
    List<User> findAll();
    User findByUsername(String username);
    User findById(UUID id);
    void deleteById(UUID id);
}
