package org.backend.gdc.web;

import org.backend.gdc.entity.UserEntity;
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
    public List<UserEntity> listUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/users/{id}")//requete http
    public UserEntity getUserEntity(@PathVariable(name = "id") Long code) {//affecter id a code
        return userRepository.findById(code).get();
    }

    @PostMapping(path = "/users")//requete http
    public UserEntity save(@RequestBody UserEntity user) {//resevoir des information sur le user
        return userRepository.save(user);
    }

    @PutMapping(path = "/users/{id}")
    public UserEntity update(@PathVariable Long id, @RequestBody UserEntity user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping(path = "/users/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
