package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
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
                             @RequestParam(value = "rolesList", required = false) String[] roles,
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
        return "edit";
    }

    @PostMapping("edit/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        System.out.println("Начало метода обновления");
        userService.update(user);
        System.out.println("Конец метода обновления");
        return "redirect:/admin";
    }

    @PostMapping("delete")
    public String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
