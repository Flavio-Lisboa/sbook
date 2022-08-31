package com.flavio.sbook.domain.service;

import com.flavio.sbook.domain.exception.DomainException;
import com.flavio.sbook.domain.model.User;
import com.flavio.sbook.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User save(User user) {
        boolean existEmail = userRepository.findByEmail(user.getEmail()).stream().anyMatch(existUser -> !existUser.equals(user));

        if(existEmail) {
            throw new DomainException("There is already a customer registered with this email.");
        }

        return userRepository.save(user);
    }

    @Transactional
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    public boolean existsById(UUID id) {
        return !userRepository.existsById(id);
    }
}
