package com.ncjs.Travel.Diary.controllers;

import com.ncjs.Travel.Diary.models.User;
import com.ncjs.Travel.Diary.repository.UserRepository;
import com.ncjs.Travel.Diary.web.dto.LoginFormDTO;
import com.ncjs.Travel.Diary.web.dto.RegisterFormDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    // password encoder
    public static final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    // userSessionKey stores user IDs
    private static final String userSessionKey = "user";

    // handles session creation and lookup
    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

    // form processing
    // registration authentication
    @GetMapping("/register")
    public String displayRegistrationForm(Model model, HttpSession session) {
        model.addAttribute(new RegisterFormDTO());
        model.addAttribute("title", "Register");
        model.addAttribute("loggedIn",
            session.getAttribute(userSessionKey) != null);
        return "users/register";
    }

    @PostMapping("/register")
    public String processRegistrationForm(
//    public ResponseEntity<?> processRegistrationForm(
            @RequestBody @Valid RegisterFormDTO registerFormDTO,
//    @ModelAttribute @Valid RegisterFormDTO registerFormDTO,
            Errors errors,
            HttpServletRequest request,
            Model model) {

        if (errors.hasErrors()) {
//            model.addAttribute("title", "Register");
            System.out.println(errors.getAllErrors());
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return "users/register";
        }

        User existingUser =
            userRepository.findByUsername(registerFormDTO.getUsername());

        if (existingUser != null) {
//            return new ResponseEntity<String>(
//                    "Username already exists",
//                    HttpStatus.CONFLICT);
            errors.rejectValue(
                    "username",
                    "username.already-exists",
                    "A user with that username already exists");
            model.addAttribute("title", "Register");
            return "users/register";
        }

        String password = registerFormDTO.getPassword();
        String verifyPassword = registerFormDTO.getConfirmPassword();
        if (!password.equals(verifyPassword)) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            errors.rejectValue("password",
                    "passwords.mismatch",
                    "Passwords do not match");
//            model.addAttribute("title", "Register");
            return "users/register";
        }

        // At this point, the given username does NOT already exist
        // and the rest of the form data is valid.
        // Now create the user object, store it in the DB and create session.
        User newUser = new User(
                registerFormDTO.getUsername(),
                encoder.encode(password),
                registerFormDTO.getEmail()
        );

        userRepository.save(newUser);

        setUserInSession(request.getSession(), newUser);

        // return to the users/registration page with a Success message
//        return "redirect:users/register?success";
//        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        // send user to the next location
//        return "redirect:/login";
        return "redirect:/users/register";
    }

    // login authentication
    @GetMapping("/login")
    public String displayLoginForm(Model model, HttpSession session) {
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Log In");
        model.addAttribute("loggedIn",
                session.getAttribute(userSessionKey) != null);
        return "users/login";
    }

    @PostMapping("/login")
    public String processLoginForm(
            @ModelAttribute @Valid LoginFormDTO loginFormDTO,
            Errors errors, HttpServletRequest request,
            Model model) {

// TODO ask re: attributeName "title"
        if (errors.hasErrors()) {
//            model.addAttribute("title", "Log In");
            return "users/login";
        }

        User theUser =
            userRepository.findByUsername(loginFormDTO.getUsername());

        if (theUser == null) {
            errors.rejectValue(
                    "username",
                    "user.invalid",
                    "The given username does not exist");
            model.addAttribute("title", "Log In");
            return "users/login";
        }

        String password = loginFormDTO.getPassword();

        if (!theUser.isMatchingPassword(password)) {
            errors.rejectValue(
                    "password",
                    "password.invalid",
                    "Credentials invalid. Please try again with correct username/password combination.");
            model.addAttribute("title", "Log In");
            return "users/login";
        }

        setUserInSession(request.getSession(), theUser);

        return "redirect:";
    }

    // Logging out
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login";
    }

}
