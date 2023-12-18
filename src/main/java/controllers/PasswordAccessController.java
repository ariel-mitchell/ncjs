package controllers;
import com.ncjs.Travel.Diary.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Controller
@RequestMapping("passwordAccess")
public class PasswordAccessController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String passwordAccess(Model model) {
        model.addAttribute("employers",employerRepository.findAll());
        return "passwordAccess/passwordAccess";
    }
}
