package com.ncjs.Travel.Diary.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//
//import com.ncjs.Travel.Diary.models.Tag;
//import com.ncjs.Travel.Diary.models.Trip;
//import com.ncjs.Travel.Diary.models.User;
//import data.TagRepository;
//import data.TripRepository;
//import data.UserRepository;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
@Controller
@RequestMapping("")
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
//    @Autowired
//    private TripRepository tripRepository;
//    @Autowired
//    private TagRepository tagRepository;
//    @Autowired
//    private UserRepository userRepository;
//    @RequestMapping("/")
//    public String index(Model model) {
//
//        model.addAttribute("trips", tripRepository.findAll());
//
//        return "index";
//    }
//
//    @GetMapping("add")
//    public String displayAddTripForm(Model model) {
//        model.addAttribute("title", "Add Trip");
//        model.addAttribute(new Trip());
//        model.addAttribute("tags",tagRepository.findAll());
//        return "add";
//    }
//
//    @PostMapping("add")
//    public String processAddJobForm(@ModelAttribute @Valid Trip newTrip,
//                                    Errors errors, Model model, @RequestParam int userId, @RequestParam List<Integer> tags) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Trip");
//            return "add";
//        }
//        User user = userRepository.findById(userId).orElse(new User());
//        newTrip.setUser(user);
////        List<Tag> tagObjs = (List<Tag>) tagRepository.findAllById(tags);
////        newTrip.setTags(tagObjs);
//        tripRepository.save(new User());
//        return "redirect:";
//    }
//
////    @GetMapping("view/{jobId}")
////    public String displayViewJob(Model model, @PathVariable int jobId) {
////        Optional optJob = jobRepository.findById(jobId);
////        if (optJob.isPresent()) {
////            Job job = (Job) optJob.get();
////            model.addAttribute("job", job);
////            return "view";
////        } else {
////            return "redirect:../";
////        }
//    }
