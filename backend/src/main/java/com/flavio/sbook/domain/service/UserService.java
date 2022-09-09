package com.flavio.sbook.domain.service;

import com.flavio.sbook.domain.exception.DomainException;
import com.flavio.sbook.domain.model.User;
import com.flavio.sbook.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User save(User user) {
        boolean existEmail = userRepository.findByEmail(
                user.getEmail())
                .stream()
                .anyMatch(existUser -> !existUser.equals(user));

        if(existEmail) {
            throw new DomainException("There is already a customer registered with this email.");
        }

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encoder = passwordEncoder.encode(user.getPassword());
        user.setPassword(encoder);

        return userRepository.save(user);
    }

    @Transactional
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public boolean existsById(String id) {
        return !userRepository.existsById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                user.getAuthorities());
    }
}

