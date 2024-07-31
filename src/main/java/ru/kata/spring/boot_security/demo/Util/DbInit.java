package ru.kata.spring.boot_security.demo.Util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class DbInit {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public DbInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void postConstruct() {
        Role admin = new Role("ROLE_ADMIN");
        Role user = new Role("ROLE_USER");


            roleService.saveRole(admin);


            roleService.saveRole(user);


        User userAdmin = new User("Artem", "Russia", (byte) 23, "user");
        User userUser = new User("Phil", "USA", (byte) 76, "admin");
        String[] rolesAdmin = {"ROLE_ADMIN", "ROLE_USER"};
        String[] rolesUser = {"ROLE_USER"};


            userService.add(userAdmin, "admin", rolesAdmin);


            userService.add(userUser, "user", rolesUser);

    }
}
