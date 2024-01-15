package com.ncjs.Travel.Diary.controllers;


import com.ncjs.Travel.Diary.data.TripRepository;
import com.ncjs.Travel.Diary.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class TripController {

    @Autowired
    private TripRepository tripRepository;
    private String description;

    @GetMapping("/trips")

    public String displayHomePage(Model model) {
        model.addAttribute("tripList", tripRepository.findAll());
        return "index";
    }

    @GetMapping("/trips/add")
    public String addTripPage() {
        return "form";
    }

    @PostMapping("/trips/add")

    public String addTrip(@ModelAttribute Trip tripName) {
        tripRepository.save(tripName);
        return "redirect:/trips";

    }


    @GetMapping("/trips/delete")
    public String displayDeleteForm(Model model) {
        model.addAttribute("tripList", tripRepository.findAll());
        return "delete";
    }

    @PostMapping("/trips/delete")
    public String processDeleteForm(@RequestParam(required = false) int[] tripId) {
        for(int id: tripId) {
            tripRepository.deleteById(id);
        }

        return "redirect:/trips";
    }


    @PostMapping("/trips/favorite")
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

    @GetMapping("/trips/edit/{id}")
    public String displayEditForm(@PathVariable int id, Model model) {
        Trip trip = tripRepository.findById(id).orElse(null);
        model.addAttribute("trip", trip);
        return "edit";
    }

//    @PostMapping("/trips/edit/{id}")
//    public String saveEditedTrip(@PathVariable String id, @RequestParam String tripName) {
//
//        int tripId = Integer.parseInt(id);
//
//        Optional<Trip> optionalTrip = tripRepository.findById(tripId);
//
//        if (optionalTrip.isPresent()) {
//            // Update the trip name
//            Trip trip = optionalTrip.get();
//            trip.setTripName(tripName);
//            trip.setDescription(description);
//            tripRepository.save(trip);
//        }
//
//        return "redirect:/trips";
//    }

    @PostMapping("/trips/edit/{id}")
    public String saveEditedTrip(@PathVariable int id, @ModelAttribute Trip updatedTrip) {
        Optional<Trip> optionalTrip = tripRepository.findById(id);

        if (optionalTrip.isPresent()) {
            Trip existingTrip = optionalTrip.get();

            // Update fields
            existingTrip.setTripName(updatedTrip.getTripName());
            existingTrip.setDescription(updatedTrip.getDescription());

            tripRepository.save(existingTrip);
        }

        return "redirect:/trips";
    }



}






