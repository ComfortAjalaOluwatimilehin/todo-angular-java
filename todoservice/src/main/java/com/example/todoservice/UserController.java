package com.example.todoservice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

class LoginPayload {
    String username;
    String password;
}

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/users")
    @CrossOrigin(origins = "*")
    public List<User> findUsers(){
        return (List<User>) userRepository.findAll();
    }


    @CrossOrigin(origins = "*")
    @PostMapping(value = "/login")
    public boolean postMethodName(@RequestBody LoginPayload payload) {
        Optional<User> useroOptional = userRepository.findByUsername(payload.username);
        if (useroOptional.isEmpty())
            throw new UserNotFoundException();
        User user = useroOptional.get();
        return this.compareUsers(user, payload);

    }
    @CrossOrigin(origins = "*")
    @PostMapping(value="/users")
    public User createUser(@RequestBody User body){
        return userRepository.save(body);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(value="/users/{id}")
    public boolean deleteUser(@RequestParam Long id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()) throw new UserNotFoundException();
        User user = userOptional.get();
        userRepository.delete(user);
        return true;
    }
    private boolean compareUsers(User user, LoginPayload body) {
        if (user.getUsername() != body.username)
            throw new UserIsInvalidException();
        if (user.getPassword() != body.password)
            throw new UserIsInvalidException();
        return true;
    }

}
