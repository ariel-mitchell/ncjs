package com.ncjs.Travel.Diary.controllers;

import com.ncjs.Travel.Diary.data.UserRepository;
import com.ncjs.Travel.Diary.models.User;
//import com.ncjs.Travel.Diary.models.dto.profileFormDTO;
import com.ncjs.Travel.Diary.models.dto.ProfileFormDTO;
import com.ncjs.Travel.Diary.models.dto.RegistrationFormDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.Errors;

import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired  // Gives the user access to the database
    private UserRepository userRepository;

    // userSessionKey stores the user id
    // TODO - is this even close?
    private static final String userSessionKey = "user";


    // form processing
    // TODO - display user information in the form - HOW?
    @GetMapping("/profile/{id}")
    public String displayProfile(
            @PathVariable int id,
            Model model,
            HttpSession session) {
        // get user from session
        model.addAttribute(new ProfileFormDTO());
        // TODO - how do I populate the form?
        return "profile";
    }

//    @PostMapping("/profile/{id}")
//    public String updateProfile(
//            @PathVariable int id,
//            @ModelAttribute @Valid ProfileFormDTO profileFormDTO,
//            Errors errors,
//            HttpServletRequest request) {
//            // Send user back to form if errors are found
//            if (errors.hasErrors()) {
//                return "profile";
//            }
//
//            // TODO - How do I get the user id and other existing information?
//        Optional<User> optUser = userRepository.findById(session);
//        User existingUser = optUser.get();
//        // determine which fields have been changed and save those
//        // if username has been changed, save it.
//        String newUsername = profileFormDTO.getUsername();
//        String newPassword = profileFormDTO.getPassword();
//        String newVerifyPassword = profileFormDTO.getVerifyPassword();
//        if (!newPassword.equals(newVerifyPassword)) {
//            errors.rejectValue(
//                    "password",
//                    "passwords.mismatch",
//                    "Passwords do not match");
//            return "profile";
//        }
//
////        existingUser.setUsername(updatedUser.getUsername());
//        return "profile";
//    }

}
