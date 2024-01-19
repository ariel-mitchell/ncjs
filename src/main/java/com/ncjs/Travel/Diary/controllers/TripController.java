package com.ncjs.Travel.Diary.controllers;

import com.ncjs.Travel.Diary.models.Tag;
import com.ncjs.Travel.Diary.models.Trip;
import com.ncjs.Travel.Diary.dto.triptagDTO;
import com.ncjs.Travel.Diary.data.TagRepository;
import com.ncjs.Travel.Diary.data.TripRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping ("trips")
public class TripController {

    //basic trips set up
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TagRepository tagRepository;
    @GetMapping("")
    public String displayHomePage(Model model) {
       // model.addAttribute("title", "All trips");
        model.addAttribute("tripList", tripRepository.findAll());
       // model.addAttribute("tagList", tagRepository.findAll());
        return "trips/index";
    }

//    @GetMapping("/")
//    public String displayHomePage(Model model) {
//        Iterable<Trip> trips = tripRepository.findAll();
//        for (Trip trips : trips) {
//            // Fetch tags for each trips to avoid lazy loading issues
//            trips.getTags().size(); // This triggers the loading of tags
//        }
//        model.addAttribute("tripList", trips);
//        return "trips/index";
//    }

//Nidia's add trips form
    @GetMapping("add")
    public String addTripPage(Model model) {
        model.addAttribute("title"," Add Trip");
       model.addAttribute(new Trip());
        return "trips/form";
    }
    @PostMapping("/add")
    public String processCreateTripForm(@ModelAttribute @Valid Trip trip,
                                       Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Trip");
            model.addAttribute(trip);
            return "trips/add";
        }
        tripRepository.save(trip);
        return "trips/index";
    }
//    @PostMapping("add")
//        public String renderTripDescription(@ModelAttribute Trip trips) {
//        tripRepository.save(trips);
//        return "redirect:/trips";



//    public String processCreateTagForm(@ModelAttribute @Valid Trip trips,
//                                       Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Create Trip");
//            model.addAttribute(trips);
//            return "trips/form";
//        }
//        tripRepository.save(new Trip(trips.getName));
//        return "trips/index";

//Nidia's delete trips form
    @GetMapping("delete")
    public String displayDeleteForm(Model model) {
        model.addAttribute("tripList", tripRepository.findAll());
        return "delete";
    }
    // Nidia's process delete form
    //delete by id and find by id respository --> accesses crud methods
    @PostMapping("delete")
    public String processDeleteForm(@RequestParam(required = false) int[] tripId) {
        for(int id: tripId) {
            tripRepository.deleteById(id);
        }

        return "redirect:/trips";
    }
//Nidia's Favorite Trips
    @PostMapping("favorite")
    public String updateFavorites(@RequestParam(required = false) int[] tripId) {
        if (tripId != null) {
            for (int id : tripId) {
                Trip trip = tripRepository.findById(id).orElse(null);
                if (trip != null) {
                    // Toggle the favorite status
                    trip.setFavorite(!trip.isFavorite());
                    tripRepository.save(trip);
                }
            }
        }

        return "redirect:/trips";

    }

//Jess's Add tag within Trip Controller
    //responds to /trips/add-tag?tripId=24
    @GetMapping("add-tag/{tripId}")
    public String displayAddTagForm(Model model, @PathVariable int tripId){
        Optional<Trip> result = tripRepository.findById(tripId);
        Trip trip = result.get();
        model.addAttribute("title", "Add Tag to: " + trip.getName());
        model.addAttribute("tags", tagRepository.findAll());
        model.addAttribute("trips", trip);
        triptagDTO tripTag = new triptagDTO();
     tripTag.setTrip(trip);
         model.addAttribute("tripTag", tripTag);
        return "trips/add-tag";
    }
    @PostMapping("add-tag")
    public String processAddTagForm(@ModelAttribute @Valid triptagDTO tripTag,
                                    Errors errors,
                                    Model model){
if (!errors.hasErrors()) {
    Trip trip = tripTag.getTrip();
    Tag tag = tripTag.getTag();
    if (!trip.getTags().contains(tag)){
        trip.addTag(tag);
        tripRepository.save(trip);
    }
    //idk where to redirectbut I'm getting to the index or add trips?
    return "redirect:/trips";
}
return "redirect:/trips";
    }
}
//mapping is when we are redirecting,
// //when we return redirect we are returning to the url which is read through the get and post request mapping
//when returning something like index or add, it will return the templates