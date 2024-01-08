package com.ncjs.Travel.Diary.controllers;


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

//    private static int nextId = 6;
    private static final Map< Integer, Trip> trips = new HashMap<>() {{
        put(1, new Trip("Canada"));
        put(2, new Trip("Italy"));
//        put(3,"Greece");
//        put(4,"Paris");
//        put(5,"New York");
    }};

    @GetMapping("/trips")

    public String displayHomePage(Model model) {
        List <Trip> tripList = new ArrayList<>(trips.values());
        model.addAttribute("tripList", tripList);
        return "index";
    }

    @GetMapping("/trips/add")
    public String addTripPage() {
        return "form";
    }

    @PostMapping("/trips/add")

    public String addTrip(@RequestParam String tripName) {
        Trip newTrip = new Trip(tripName);
        trips.put(newTrip.getId(), newTrip);
        return "redirect:/trips";

    }


    @GetMapping("/trips/{tripId}")
    @ResponseBody
    public String displayTripDetails(@PathVariable int tripId){
        return "<h2> Trip: " + trips.get(tripId) + "</h2>" +
                "<h2> ID: " + tripId + "</h2>";



    }

}






