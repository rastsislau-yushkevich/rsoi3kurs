package com.example.laba4;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/users")
    List<User> all() {
        return repo.findAll();
    }

    @PostMapping("/users")
    User newEmployee(@RequestBody User newEmployee) {
        return repo.save(newEmployee);
    }

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

        return repo.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setSurname(newUser.getSurname());
                    user.setFathername(newUser.getFathername());
                    user.setBirthdate(newUser.getBirthdate());
                    user.setPassport(newUser.getPassport());
                    user.setProducer(newUser.getProducer());
                    user.setProductiondate(newUser.getProductiondate());
                    user.setPhone(newUser.getPhone());
                    user.setEmail(newUser.getEmail());
                    user.setWorkplace(newUser.getWorkplace());
                    user.setPosition(newUser.getPosition());
                    return repo.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repo.save(newUser);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

}
