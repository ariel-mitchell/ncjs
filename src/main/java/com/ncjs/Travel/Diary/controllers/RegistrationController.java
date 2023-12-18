package com.ncjs.Travel.Diary.controllers;

import com.ncjs.Travel.Diary.TravelDiaryApplication;
import com.ncjs.Travel.Diary.models.User;
import com.ncjs.Travel.Diary.models.data.UserRepository;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("users/")
public class RegistrationController {
//public class RegistrationController extends TravelDiaryApplication {


    @Autowired
    private UserRepository userRepository;

//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("title", "All Users");
//        model.addAttribute("users",userRepository.findAll());
//        return "users/index";
//    }

    @GetMapping("register")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "users/register";
    }

    @PostMapping("register")
    public String processAddUserForm(@ModelAttribute @Valid User newUser,
                                         Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "users/register";
        }
        userRepository.save(newUser);
        return "redirect:";
    }

    @GetMapping("view/{userId}")
    public String displayViewUser(Model model, @PathVariable int userId) {
        Optional optUser = userRepository.findById(userId);
        if (optUser.isPresent()) {
            User user = (User) optUser.get();
            model.addAttribute("user", user);
            return "users/register";
        } else {
            return "redirect:../";
        }

    }
}
