package com.webonise.rbs.controller;

import com.webonise.rbs.entity.User;
import com.webonise.rbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String savePage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allUsers", userService.getAllUsers());
        return "users";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user, final RedirectAttributes redirectAttributes) {
        if (userService.addUser(user) != null) {
            redirectAttributes.addFlashAttribute("saveUser", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveUser", "failure");
        }
        return "redirect:/user";
    }

    @GetMapping(value = "/{id}")
    public String editUser(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes, Model model) {
        User editUser = userService.findById(id);
        if (editUser != null) {
            model.addAttribute("editUser", editUser);
            return "edituser";
        } else {
            redirectAttributes.addFlashAttribute("status", "notfound");
        }
        return "redirect:/user";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes, Model model) {
        if (userService.deleteById(id)) {
            redirectAttributes.addFlashAttribute("deletion", "success");
        } else {
            redirectAttributes.addFlashAttribute("deletion", "failure");
        }
        return "redirect:/user";
    }

    @PutMapping
    public String updateUser(@ModelAttribute("editUser") User editUser, final RedirectAttributes redirectAttributes) {
        if (userService.editUser(editUser) != null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "failure");
        }
        return "redirect:/user";
    }
}
