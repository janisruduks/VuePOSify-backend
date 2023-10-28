package com.example.posapp.service;

import com.example.posapp.entity.User;
import com.example.posapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return repository.save(user);
    }
}