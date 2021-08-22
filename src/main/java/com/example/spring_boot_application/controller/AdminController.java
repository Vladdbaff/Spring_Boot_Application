package com.example.spring_boot_application.controller;


import com.example.spring_boot_application.model.Role;
import com.example.spring_boot_application.model.User;
import com.example.spring_boot_application.service.RoleService;
import com.example.spring_boot_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping()
    //@ResponseBody
    public String mainPage(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "main";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        String roleAdmin = null;
        model.addAttribute("user", new User());

        model.addAttribute("roleAdmin", roleAdmin);
        return "newUser";
    }

    @PostMapping
    public String createUser(
            @ModelAttribute(value = "roleAdmin") String roleAdmin,
            @ModelAttribute("user") @Valid User user, BindingResult result) {

        if (result.hasErrors()) {
            return "newUser";
        }

        Set<Role> setRole = new HashSet<>();
        if (roleAdmin.contains("on")) {
            setRole.add(roleService.getRoleById(1));
            setRole.add(roleService.getRoleById(2));
        } else {
            setRole.add(roleService.getRoleById(2));
        }
        user.setRoles(setRole);
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("user") @Valid User user,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "editUser";
        }

        userService.updateUser(user, id);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @GetMapping("{id}")
    public String user(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "userPage";
    }




}
