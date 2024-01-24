package com.ncjs.Travel.Diary.controllers;

import com.ncjs.Travel.Diary.data.UserRepository;
import com.ncjs.Travel.Diary.models.User;
import com.ncjs.Travel.Diary.models.dto.LoginFormDTO;
import com.ncjs.Travel.Diary.models.dto.RegistrationFormDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("")
public class AuthenticationController {

    @Autowired  // Gives the user access to the database
    private UserRepository userRepository;

    // userSessionKey stores the user id
    private static final String userSessionKey = "user";

    // stores key-value pair of userSessionKey and userId
    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

    // handles session creation and lookup
    // locates the user object in the database
    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) { return null; }
        // holds the user object IF one exists
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) { return null; }
        return userOpt.get();
    }

    // form processing
    // registration authentication
    @GetMapping("/register")
    public String displayRegistrationForm(Model model, HttpSession session) {
        model.addAttribute(new RegistrationFormDTO());
        // send value of loggedIn to fragments.html
        model.addAttribute(
                "LoggedIn",
                session.getAttribute(userSessionKey) != null);
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationForm(
            @ModelAttribute @Valid RegistrationFormDTO registrationFormDTO,
            Errors errors,
            HttpServletRequest request) {
       // Send user back to form if errors are found
       if (errors.hasErrors()) {
           return "register";
       }

       User existingUser =
               userRepository.findByUsername(registrationFormDTO.getUsername());

       if (existingUser != null) {
           errors.rejectValue(
                   "username",
                   "username.alreadyExists",
                   "A user with that username already exists");
           return "register";
       }

       String password = registrationFormDTO.getPassword();
       String verifyPassword = registrationFormDTO.getVerifyPassword();
       if (!password.equals(verifyPassword)) {
           errors.rejectValue(
                   "password",
                   "passwords.mismatch",
                   "Passwords do not match");
           return "register";
       }

        // Save new username & password, start a new session, and redirect to home page
        User newUser = new User(
                registrationFormDTO.getUsername(),
                registrationFormDTO.getPassword());
       userRepository.save(newUser);
       // since the user has just registered, no need to make them login
       // just set up the session
       setUserInSession(request.getSession(),  newUser);
        // TODO: modify this redirect to send user to where they can add/view trips?
        // return "redirect:/trips";
       return "redirect:";
    }

    // login authentication
    @GetMapping("/login")
    public String displayLoginForm(Model model, HttpSession session) {
        model.addAttribute(new LoginFormDTO());
        // send value of loggedIn to fragments.html
        model.addAttribute(
                "LoggedIn",
                session.getAttribute(userSessionKey) != null);
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(
            @ModelAttribute @Valid LoginFormDTO loginFormDTO,
            Errors errors,
            HttpServletRequest request) {
        if (errors.hasErrors()) {
            return "login";
        }

        User theUser = userRepository.findByUsername(loginFormDTO.getUsername());

        String password = loginFormDTO.getPassword();

        // See if password the user just gave us matches what is in the database
        if (theUser == null || !theUser.isMatchingPassword(password)) {
            errors.rejectValue(
                    "password",
                    "login.invalid",
                    "Credentials invalid. Please try again with correct username/password combination."
            );
            return "login";
        }

        setUserInSession(request.getSession(), theUser);
        // TODO: modify this redirect to send user to where they can add/view trips?
        // return "redirect:/trips";
        return "redirect:";

    }

    // Logging out
    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";   // send back to login form
    }

}
