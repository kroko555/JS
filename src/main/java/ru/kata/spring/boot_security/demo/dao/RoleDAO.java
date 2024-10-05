package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;

public interface RoleDAO {
    void saveRole(Role role);

    Role getRole(String role);
}
