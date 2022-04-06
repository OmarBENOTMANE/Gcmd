package org.backend.gdc.web;

import org.backend.gdc.entity.User;
import org.backend.gdc.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    //autowired injection dependence with it is deprecated
    private final UserRepository userRepository;

    //so we generate a constructor with param
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/users")//requete http
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/users/{id}")//requete http
    public User getUser(@PathVariable(name = "id") Long code) {//affecter id a code
        return userRepository.findById(code).get();
    }

    @PostMapping(path = "/users")//requete http
    public User save(@RequestBody User user) {//resevoir des information sur le user
        return userRepository.save(user);
    }

    @PutMapping(path = "/users/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping(path = "/users/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
