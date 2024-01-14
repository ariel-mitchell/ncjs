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
    public String passwordAccessform(Model model) {
        model.addAttribute("user",UserRepository.findAll());
        return "passwordAccess/passwordAccess";
    }

    @GetMapping("addAnswers")
    public String displayAddAnswerForm(Model model) {
        model.addAttribute(new Employer());
        return "passwordAccess/addAnswers";
    }

    //not new user figure this one out?
    @PostMapping("add")
    public String processAddAnswersForm(@ModelAttribute @Valid User newUser,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "passwordAccess/addAnswers";
        }
        UserRepository.save(newUser);
        return "redirect:";
    }

}
