///EDITED: Hey so this page is used after for resetting password after the user
//enters their password after pressing "forgot password"
//They will be able to reset their password which will be hashed again.
//Conditional Setup:
//(1) Security questions must match their original answers or Error
//(2) Password reset and repeat new password must match
//(3) Password must be at least 1 character
package com.ncjs.Travel.Diary.controllers;
//import com.ncjs.Travel.Diary.models.PasswordError;
import com.ncjs.Travel.Diary.models.User;
import com.ncjs.Travel.Diary.data.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping ("recovery/ForgotPassword")
    public String processForgotPasswordForm(@RequestParam String submitUsername, Model model) {
        Optional<User> optUser = Optional.ofNullable(userRepository.findByUsername(submitUsername));
        if (optUser.isEmpty()) {
            return "redirect:recovery/ForgotPassword";
        } else {
            User user = optUser.get();
            model.addAttribute("user",user);
            return "recovery/ResetPasswordWithSecurityQuestions";
        }
    }
    //new password form
    @GetMapping("recovery/resetPassword")
    public String displayResetPasswordForm(Model model) {
        model.addAttribute("title", "Reset Password");
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


    //try (Scanner file = new Scanner(new File(fileName))) {
    //    if (file.hasNextLine()) {
    //        return file.nextLine();
    //    } else {
    //        throw new IllegalArgumentException("Non readable file");
    //    }
    //} catch (FileNotFoundException err) {
    //    if (!isCorrectFileName(fileName)) {
    //        throw new IncorrectFileNameException(
    //          "Incorrect filename : " + fileName , err);
    //    }
    //    custom error! Make sure the thymeleaf error name is the same as the variable in this controller
//    @PostMapping("recovery/resetPassword")
//    public String processResetPasswordForm(@RequestParam String momMaidenName, @RequestParam String birthLocation, @RequestParam String firstKiss,
//                                           @RequestParam String firstLocation, @RequestParam String firstWord, @RequestParam String resetPassword, @RequestParam String repeatNewPassword,
//                                           PasswordError error, Model model) {
//        try
//        {
//            if(user.PasswordSecurityQuestions.momMaidenName = )
//            {
//                throw new PasswordError("Not a valid response.");
//            }
//        }
//        catch(PasswordError )
//        {
//            // Process message however you would like
//        }
    }
//        error
//        if (errors.hasErrors()) {
//            return "recovery/ResetPasswordWithSecurityQuestions";
//        }
////        UserRepository.save(submitUsername);
//        return "redirect:";
//    }
