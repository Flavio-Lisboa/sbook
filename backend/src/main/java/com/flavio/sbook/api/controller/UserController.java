package com.flavio.sbook.api.controller;

import com.flavio.sbook.domain.enums.RoleName;
import com.flavio.sbook.domain.model.Role;
import com.flavio.sbook.domain.model.User;
import com.flavio.sbook.domain.service.RoleService;
import com.flavio.sbook.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable String id) {
        return userService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@Valid @RequestBody User user) {

        Role role = new Role();
        role.setId(roleService.getRoleID(RoleName.ROLE_USER));
        role.setRoleName(RoleName.ROLE_USER);
        user.setRoles(List.of(role));

        return userService.save(user);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @Valid @RequestBody User user) {
        if(userService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        user.setId(id);

        Role role = new Role();
        role.setId(roleService.getRoleID(RoleName.ROLE_USER));
        role.setRoleName(RoleName.ROLE_USER);
        user.setRoles(List.of(role));

        user = userService.save(user);

        return ResponseEntity.ok(user);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        if(userService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        userService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
