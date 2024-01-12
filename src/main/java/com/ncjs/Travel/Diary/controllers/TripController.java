package com.ncjs.Travel.Diary.controllers;


import com.ncjs.Travel.Diary.data.TripRepository;
import com.ncjs.Travel.Diary.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TripController {

    @Autowired
    private TripRepository tripRepository;
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


}






