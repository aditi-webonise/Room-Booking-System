package com.webonise.rbs.controller;

import com.webonise.rbs.constants.RedirectStatus;
import com.webonise.rbs.entity.User;
import com.webonise.rbs.service.RoleService;
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

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String savePage (Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "users";
    }

    @PostMapping
    public String saveUser (@ModelAttribute("user") User user, final RedirectAttributes redirectAttributes) {
        if (userService.addUser(user) != null) {
            redirectAttributes.addFlashAttribute("saveUser", RedirectStatus.SUCCESS.getStatus());
        } else {
            redirectAttributes.addFlashAttribute("saveUser", RedirectStatus.FAILURE.getStatus());
        }
        return "redirect:/user";
    }

    @GetMapping(value = "/{id}")
    public String editUser (@PathVariable("id") Long id, Model model) {
        model.addAttribute("allRoles", roleService.getAllRoles());
        User editUser = userService.findById(id);
        if (editUser != null) {
            model.addAttribute("editUser", editUser);
            return "edituser";
        }
        return "redirect:/user";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser (@PathVariable("id") Long id, final RedirectAttributes redirectAttributes) {
        if (userService.deleteById(id)) {
            redirectAttributes.addFlashAttribute("deletion", RedirectStatus.SUCCESS.getStatus());
        } else {
            redirectAttributes.addFlashAttribute("deletion", RedirectStatus.FAILURE.getStatus());
        }
        return "redirect:/user";
    }

    @PutMapping
    public String updateUser (@ModelAttribute("editUser") User editUser, final RedirectAttributes redirectAttributes) {
        if (userService.editUser(editUser) != null) {
            redirectAttributes.addFlashAttribute("edit", RedirectStatus.SUCCESS.getStatus());
        } else {
            redirectAttributes.addFlashAttribute("edit", RedirectStatus.FAILURE.getStatus());
        }
        return "redirect:/user";
    }
}
