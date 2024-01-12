package com.ncjs.Travel.Diary.controllers;

import com.ncjs.Travel.Diary.models.User;
import com.ncjs.Travel.Diary.models.data.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

//    @Autowired
//    private UserRepository userRepository;

//    @Autowired
//    private TripRepository tripRepository;

//    @GetMapping("users/register")
//    public String displayAddUserForm(Model model) {
//        model.addAttribute("title", "New User Registration");
//        model.addAttribute(new User());
//        model.addAttribute("users", userRepository.findAll());
//        return "users/register";
//    }
//
//    @PostMapping("users/register")
//    public String processAddUserForm(@ModelAttribute @Valid User newUser,
//                                    Errors errors, Model model) {
////        @RequestParam int userId) {
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "New User Registration");
//            return "users/register";
//        }

//        // add user data from repository
//        User newUser =
//                userRepository.findById(userId).orElse(new User());

        return "redirect:";

    }

}
