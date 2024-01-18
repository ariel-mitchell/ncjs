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

    //basic trip set up
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TagRepository tagRepository;
    @GetMapping("/")
    public String displayHomePage(Model model) {
        model.addAttribute("tripList", tripRepository.findAll());
       // model.addAttribute("tagList", tagRepository.findAll());
        return "trip/index";
    }

//    @GetMapping("/")
//    public String displayHomePage(Model model) {
//        Iterable<Trip> trips = tripRepository.findAll();
//        for (Trip trip : trips) {
//            // Fetch tags for each trip to avoid lazy loading issues
//            trip.getTags().size(); // This triggers the loading of tags
//        }
//        model.addAttribute("tripList", trips);
//        return "trip/index";
//    }

//Nidia's add trip form
    @GetMapping("add")
    public String addTripPage() {
        return "trip/form";
    }

    @PostMapping("add")
    public String renderTripDescription(@ModelAttribute Trip trip) {
        tripRepository.save(trip);
        return "redirect:";
    }
//Nidia's delete trip form
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
    @GetMapping("add-tag")
    public String displayAddTagForm(@RequestParam Integer tripId, Model model){
        Optional<Trip> result = tripRepository.findById(tripId);
        Trip trip = result.get();
        model.addAttribute("title", "Add Tag to: " + trip.getName());
        model.addAttribute("tags", tagRepository.findAll());
//        model.addAttribute("trip", trip);
        //model.addAttribute("tripTag", new triptagDTO());
        triptagDTO tripTag = new triptagDTO();
     tripTag.setTrip(trip);
         model.addAttribute("tripTag", tripTag);
        return "trip/add-tag.html";
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
    //idk where to redirectbut I'm getting to the index or add trip?
    return "redirect:trips?tripId=" + trip.getId();
}
return "redirect:add-tag";
    }
}
//mapping is when we are redirecting,
// //when we return redirect we are returning to the url which is read through the get and post request mapping
//when returning something like index or add, it will return the templates