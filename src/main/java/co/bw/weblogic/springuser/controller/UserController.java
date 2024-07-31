package co.bw.weblogic.springuser.controller;

import co.bw.weblogic.springuser.model.User;
import co.bw.weblogic.springuser.service.UserService;
import co.bw.weblogic.springuser.util.HttpResponse;
import co.bw.weblogic.springuser.util.UsernameExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<HttpResponse<User>> saveUser(@RequestBody User user) throws UsernameExistException {
        HttpResponse<User> response = userService.save(user);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getHttpStatusCode()));
    }

//    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
//        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),
//                message), httpStatus);
//    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable UUID id) {
        return userService.findById(id);
    }

    @GetMapping("/find-user/{username}")
    public User findUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable UUID id) {
        userService.deleteById(id);
    }

}
