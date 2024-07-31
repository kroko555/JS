package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String users(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/addUser")
    public String createUser(@ModelAttribute("user")  User user,
                             BindingResult bindingResult,
                             @RequestParam(value = "rolesList") String[] roles,
                             @ModelAttribute("pass") String pass) {
        if (bindingResult.hasErrors()) {
            return "/new";
        }
        userService.add(user, pass, roles);
        return "redirect:/admin";
    }

    @GetMapping("/edit")
    public String editUser(Model model, @RequestParam Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user")  User user,
                             @RequestParam(value = "rolesList") String[] roles,
                             @ModelAttribute("pass") String pass) {
        userService.update(user, roles);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(Model model, @RequestParam Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
