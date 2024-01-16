//this Controller asks for Username after Pressing "Forgot Password?" Button on LoginController page
//Meant to enact the "find Username" capability that Cheri has coded already
//the form for this should be able to be accessed later
package com.ncjs.Travel.Diary.controllers;

import com.ncjs.Travel.Diary.models.User;
import com.ncjs.Travel.Diary.data.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsernameQuestionController {
    @Autowired
    private UserRepository userRepository;
    private String resetterUsername;

    @PostMapping("")
    public String processSubmitUsername(@RequestParam String submitUsername) {
        if (userRepository.findByUsername(submitUsername.toLowerCase()) == null) {
            return "redirect:../";
        } else {
            resetterUsername = submitUsername;
            return "recovery/ResetPasswordWithSecurityQuestions";
        }
    }

    @PostMapping("recovery/ResetPasswordWithSecurityQuestions")
    public String passwordresetform(Model model,@RequestParam String momMaidenName, @RequestParam String birthLocation, @RequestParam String firstKiss,@RequestParam String firstLocation, @RequestParam String firstWord) {
        return "recovery/ForgotPassword";
    }

    @GetMapping("addAnswers")
    public String displayAddAnswerForm(Model model) {
        //  model.addAttribute(new User());
        return "recovery/ResetPasswordWithSecurityQuestions";
    }

    //not new user figure this one out?
    @PostMapping("add")
    public String processAddAnswersForm(@ModelAttribute @Valid User newUser,
                                        Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "recovery/ResetPasswordWithSecurityQuestions";
        }
//        UserRepository.save(newUser);
        return "redirect:";
    }

}



