package com.flavio.sbook.api.controller;

import com.flavio.sbook.domain.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class UserController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/users")
    public List<User> getAll() {
        return  entityManager.createQuery("from User", User.class).getResultList();
    }
}
