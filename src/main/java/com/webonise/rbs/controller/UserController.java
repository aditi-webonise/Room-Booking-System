package com.webonise.rbs.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.webonise.rbs.entity.User;
import com.webonise.rbs.repository.UserRepository;
import com.webonise.rbs.service.UserService;
import com.webonise.rbs.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = "/",produces = MediaType.TEXT_HTML_VALUE)
    public String savePage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allUsers", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user, final RedirectAttributes redirectAttributes) {

        if(userService.addUser(user)!=null) {
            redirectAttributes.addFlashAttribute("saveUser", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveUser", "unsuccess");
        }
        return "redirect:/user/";
    }

    @GetMapping(value = "/{operation}/{id}")
    public String editRemoveUser(@PathVariable("operation") String operation, @PathVariable("id") Long id, final RedirectAttributes redirectAttributes, Model model) {

        if(operation.equals("delete")) {
            if(userService.deleteById(id)) {
                redirectAttributes.addFlashAttribute("deletion", "success");
            } else {
                redirectAttributes.addFlashAttribute("deletion", "unsuccess");
            }
        } else if(operation.equals("edit")){
            User editUser = userService.findById(id);
            if(editUser!=null) {
                model.addAttribute("editUser", editUser);
                return "editUsers";
            } else {
                redirectAttributes.addFlashAttribute("status","notfound");
            }
        }

        return "redirect:/user/";
    }

    @PostMapping(value = "/update")
    public String updateUser(@ModelAttribute("editUser") User editUser, final RedirectAttributes redirectAttributes) {

        if(userService.editUser(editUser)!=null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/user/";
    }
}

