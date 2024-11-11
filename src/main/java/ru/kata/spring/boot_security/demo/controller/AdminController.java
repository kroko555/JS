/*
package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    private final RoleService roleService;

    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AdminController(UserService userService, RoleService roleService, PasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("user")
    public String user(Model model, Principal principal) {
        User user = userService.findUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "useradmin";
    }

    @GetMapping()
    public String users(Model model, Principal principal) {
        User user = userService.findUserByUsername(principal.getName());
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("user", user);
        return "test";
    }

    @GetMapping("addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/addUser")
    public String createUser(@ModelAttribute("user") User user,
                             BindingResult bindingResult,
                             @RequestParam(value = "roles") String[] roles,
                             @ModelAttribute("password") String password,
                             @ModelAttribute("username") String username) {
        System.out.println("Метод addUser был вызван");
        if (bindingResult.hasErrors()) {
            return "/new";
        }
        userService.add(user, password, roles, username);
        return "redirect:/admin";
    }

    @GetMapping("edit/{id}")
    public String editUser(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "test";
    }

    @PostMapping("edit/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable Long id, @RequestParam(value = "roles") String[] roles) {
        System.out.println("Начало метода обновления");
        User actualUser = userService.getUserById(id);
        actualUser.setUsername(user.getUsername());
        actualUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<Role> roleList = new ArrayList<>();
        for (String roleName : roles) {
            Role role = roleService.getRole(roleName);
            if (role != null) {
                roleList.add(role);
            }
        }
        actualUser.setRoles(roleList);
        actualUser.setAge(user.getAge());
        actualUser.setCountry(user.getCountry());
        actualUser.setName(user.getName());
        userService.update(actualUser);
        System.out.println("Конец метода обновления");
        return "redirect:/admin";
    }

    @PostMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
*/
