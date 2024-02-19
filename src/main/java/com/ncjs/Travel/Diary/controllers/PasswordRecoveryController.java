///EDITED: Hey so this page is used after for resetting password after the user
//enters their password after pressing "forgot password"
//They will be able to reset their password which will be hashed again.
//Conditional Setup:
//(1) Security questions must match their original answers or Error
//(2) Password reset and repeat new password must match
//(3) Password must be at least 1 character
package com.ncjs.Travel.Diary.controllers;
import com.ncjs.Travel.Diary.dto.PasswordRecoveryDTO;
import com.ncjs.Travel.Diary.dto.RegistrationFormDTO;
import com.ncjs.Travel.Diary.models.User;
import com.ncjs.Travel.Diary.data.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Optional;

//I wanted to create a page for my recovery page. This is what I have with the information I'm working with.
//currently thinking of more elegant solutions bc i'm not workingn on user controller, i have made their own password controller
//and we'll see if it will stay or go into usercontroller or somewhere else.
////password recovery can lead to here. get to display form and post to handle it. check if everything is correct
//    //and if not send back to account recovery. if you answer correctly, you can reset password --> log back in.
//do i want enum of security questions? or just pick 4 question for them to answer like it is set up. putting it in there.
//email-->in database connection--> answer preset que//post mapping would , error or correct form if we hit submit stions --> reset password in user model. resaving their password. 2 models.
//arraylist of questions, input fields and iterate through questions to clean up templates.

//controllor grouped by theme, all fall under recovery controller.
//need
//handler plans:
//get mapping for /recovery form asking for username
// (if you can't figure it out, seperate forms) TRICKY: post mapping process username form: redirect back to get mapping but change element to be true or false maybe?
    // would answering recovery questions html templates for same page /recovery, error or correct form if we hit submit
//get mapping form /new password as ex, for new password --> possible path parameter recovery?true or false? --> true on the page
//post mapping process new password form verify the passwords are the same
//redirect to login page

//Ask Cheri, peer programming suggestion: do you have a set password in user? new passwordencryption --> passing password back to user and setting password as an update.
//1:1 relationship in user
//add that one to one relationship in user that we did before for question answers

//walking through adding questions to registration forms
//I would ideally like to add these questions to registration forms that exist when recreating passwords and usernames
// idk, but maybe consider everyone having 1?idk


//adding link to recovery password on login form
//adding link to recovery password? link on login form will just require adding
// a th:ref in the template form and then adding redirection on the login controller

//assigning password to user in database after security cleared.
//1) find out how she's hashing passwords and what she does to set these passwords in the database
//then just replicate that process
@Controller
@SessionAttributes("submitUsername")
//@RequestMapping("/recovery")
public class PasswordRecoveryController {

    @Autowired
    private UserRepository userRepository;

    private User user;

    //ask for username form
    @GetMapping("recovery/ForgotPassword")
    public String displayForgotPasswordForm(Model model) {
        model.addAttribute("title", "Forgot Password?");
        return "recovery/ForgotPassword";
    }

    //processing request username form
    @PostMapping("recovery/ForgotPassword")
    public String processForgotPasswordForm(Model model, @RequestParam String submitUsername) {
        model.addAttribute("submitUsername", submitUsername);
        Optional<User> optUser = Optional.ofNullable(userRepository.findByUsername(submitUsername));
        if (optUser.isEmpty()) {
            return "redirect:recovery/ForgotPassword";
//            status.setComplete();
        } else {
            User user = optUser.get();
            model.addAttribute("user", user);
            //System.out.println("User is + " + user.getUsername() + " Input user is + " + submitUsername);
            return "redirect:./resetPassword";
        }
    }

    //new password form
    @GetMapping("recovery/resetPassword")
    public String displayResetPasswordForm(Model model, Error errors) {
        String currUsername = (String) model.getAttribute("submitUsername");
        Optional<User> optUser = Optional.ofNullable(userRepository.findByUsername(currUsername));
       // System.out.println("RESETPASSWORD User is + " + optUser.get().getUsername() + " Input user is + " + currUsername);
        model.addAttribute("user", user);
        model.addAttribute("title", "Reset Password");
        model.addAttribute("Error", "Invalid response");
        return "recovery/ResetPasswordWithSecurityQuestions";
    }
// verify that all answers are from the user we set before
    //verify that all of their security questions are answered correctly AKA compare to registration security questions already set in the userrepository
    //verify that the resetpassword and repeatnewpassword are the same --> make sure that it is changed

    //process new password form
    //errors make sure that things are valid
    //errors that we are talking about are in the model class of the variables --> if you don't have that, u don't need it. But if things don't match we can use the errors to makes a custom error
    // initalize error as a variable in this handler
    //validatation using string but ideally error --> set error messages

    @PostMapping("recovery/resetPassword")
    public String processResetPasswordForm(Model model, Error errors, @RequestParam String momMaidenName, @RequestParam String birthLocation, @RequestParam String firstKiss, @RequestParam String firstLocation, @RequestParam String firstWord, @RequestParam String resetPassword, @RequestParam String repeatNewPassword, SessionStatus status) {
        String currUsername = (String) model.getAttribute("submitUsername");
        Optional<User> optUser = Optional.ofNullable(userRepository.findByUsername(currUsername));
        User user = optUser.get();
//        model.addAttribute("user", user);
//        if (errors.hasErrors()) {
        if(errors.equals(1)) {
            //System.out.println("EQUALS1");
            return "recovery/ResetPasswordWithSecurityQuestions";
        }
        if (!user.getPasswordSecurityQuestions().getMomMaidenName().toLowerCase().equals(momMaidenName.toLowerCase()) ||
                !user.getPasswordSecurityQuestions().getBirthLocation().toLowerCase().equals(birthLocation.toLowerCase()) ||
                !user.getPasswordSecurityQuestions().getFirstKiss().toLowerCase().equals(firstKiss.toLowerCase()) ||
                !user.getPasswordSecurityQuestions().getFirstLocation().toLowerCase().equals(firstLocation.toLowerCase()) ||
                !user.getPasswordSecurityQuestions().getFirstWord().toLowerCase().equals(firstWord.toLowerCase())) {
            model.addAttribute("errorMsg", "Invalid Response");
            return "recovery/ResetPasswordWithSecurityQuestions";
        }
        if (!resetPassword.equals(repeatNewPassword)) {
//            errors.rejectValue(
//                    "password",
//                    "passwords.mismatch",
            System.out.println("Passwords do not match ***ADD TO THYMELEAF");
            return "recovery/ResetPasswordWithSecurityQuestions";
        }
        user.resetPassword(resetPassword);
        userRepository.save(user);
        status.setComplete();
        System.out.println("\n\n The current password hash for " + user + "is: " + user.getPwHash() + "\n\n");
        return "outside_index";
    }
}