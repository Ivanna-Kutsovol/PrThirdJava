package com.prThird.prThird.service;

import com.prThird.prThird.model.User;
import com.prThird.prThird.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findUsers(String name, String email) {
        List<User> allUsers = userRepository.findAll();

        return allUsers.stream()
                .filter(user -> (name == null || user.getName().equalsIgnoreCase(name)) &&
                                (email == null || user.getEmail().equalsIgnoreCase(email)))
                .collect(Collectors.toList());
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(String id) {
        userRepository.delete(id);
    }
}
