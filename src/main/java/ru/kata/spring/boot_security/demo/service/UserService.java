package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void add(User user);

    void add(User user, String password, String[] roles, String username);

    void update(User user);

    void delete(Long id);

    User getUserById(Long id);

    User findUserByUsername(String username);

}
