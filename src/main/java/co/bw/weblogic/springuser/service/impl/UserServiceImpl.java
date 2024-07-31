package co.bw.weblogic.springuser.service.impl;

import co.bw.weblogic.springuser.model.User;
import co.bw.weblogic.springuser.repository.UserRepository;
import co.bw.weblogic.springuser.service.UserService;
import co.bw.weblogic.springuser.util.HttpResponse;
import co.bw.weblogic.springuser.util.UsernameExistException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static co.bw.weblogic.springuser.util.UserImplConstant.USERNAME_ALREADY_EXISTS;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public HttpResponse<User> save(User user) {
        User existing = userRepository.findByUsername(user.username).orElse(null);

        if (existing != null) {
            return new HttpResponse<>(
                    HttpStatus.CONFLICT,
                    USERNAME_ALREADY_EXISTS,
                    null
            );
        }

        User savedUser = userRepository.save(user);
        return new HttpResponse<>(
                HttpStatus.CREATED,
                savedUser
        );
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

}
