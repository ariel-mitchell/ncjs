package com.ncjs.Travel.Diary.controllers;


import com.ncjs.Travel.Diary.data.TripsData;
import com.ncjs.Travel.Diary.models.Trip;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TripController {

    @GetMapping("/trips")

    public String displayHomePage(Model model) {
//        List <Trip> tripList = new ArrayList<>(trips.values());
        model.addAttribute("tripList", TripsData.getAll());
        return "index";
    }

    @GetMapping("/trips/add")
    public String addTripPage() {
        return "form";
    }

    @PostMapping("/trips/add")

    public String addTrip(@RequestParam String tripName) {
        Trip newTrip = new Trip(tripName);
        TripsData.add(newTrip);
        return "redirect:/trips";

    }


    @GetMapping("/trips/delete")
    public String displayDeleteForm(Model model) {
        model.addAttribute("tripList", TripsData.getAll());
        return "delete";
    }

    @PostMapping("/trips/delete")
    public String processDeleteForm(@RequestParam(required = false) int[] tripId) {
        for(int id: tripId) {
            TripsData.remove(id);
        }

        return "redirect:/trips";
    }

}






