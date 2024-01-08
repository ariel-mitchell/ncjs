package com.ncjs.Travel.Diary.controllers;

import com.ncjs.Travel.Diary.models.User;
import com.ncjs.Travel.Diary.models.data.UserRepository;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users/")
public class UserController {
//public class RegistrationController extends TravelDiaryApplication {


    @Autowired
    private UserRepository userRepository;

// handle home page request
    @GetMapping("/index")
    public String home() { return "index"; }

// handler for user registration form
    @GetMapping("register")
    public String displayAddUserForm(Model model) {
        // create model object to store form data
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

    // handler for login form
    @GetMapping("login")
    public String displayLoginForm(Model model) {
        // create model object to store form data
//        model.addAttribute(new User());
        return "users/login";
    }

//    @PostMapping("login")
//    public String processLoginForm(@ModelAttribute @Valid User newUser,
//                                     Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            return "users/login";
//        }
//        userRepository.save(newUser);
//        return "redirect:";
//    }

//    @GetMapping("view/{userId}")
//    public String displayViewUser(Model model, @PathVariable int userId) {
//        Optional optUser = userRepository.findById(userId);
//        if (optUser.isPresent()) {
//            Users user = (Users) optUser.get();
//            model.addAttribute("user", user);
//            return "users/register";
//        } else {
//            return "redirect:../";
//        }
//
//    }

}
