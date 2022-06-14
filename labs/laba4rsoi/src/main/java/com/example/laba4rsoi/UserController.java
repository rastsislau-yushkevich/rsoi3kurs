package com.example.laba4rsoi;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    CollectionModel<EntityModel<User>> all() {

        List<EntityModel<User>> employees = repository.findAll().stream()
                .map(employee -> EntityModel.of(employee,
                        linkTo(methodOn(UserController.class).one(employee.getId())).withSelfRel(),
                        linkTo(methodOn(UserController.class).all()).withRel("users")))
                .collect(Collectors.toList());

        return CollectionModel.of(employees, linkTo(methodOn(UserController.class).all()).withSelfRel());
    }

    @GetMapping("/users/{id}")
    EntityModel<User> one(@PathVariable Long id) {
        User user = repository.findById(id) //
                .orElseThrow(() -> new UserNotFoundException(id));
        return EntityModel.of(user,
                linkTo(methodOn(UserController.class).one(id)).withSelfRel(),
                linkTo(methodOn(UserController.class).all()).withRel("users"));
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

        return repository.findById(id)
                .map(user -> {
                    user.setSurname(newUser.getSurname());
                    user.setName(newUser.getName());
                    user.setFatherName(newUser.getFatherName());
                    user.setDateOfBirth(newUser.getDateOfBirth());
                    user.setSex(newUser.getSex());
                    user.setPassport(newUser.getPassport());
                    user.setEmail(newUser.getEmail());
                    user.setPosition(newUser.getPosition());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
