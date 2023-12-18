package com.ncjs.Travel.Diary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TripFolders {

  private static int nextId = 6;
  private static final Map< Integer, String > trips = new HashMap<>() {{
      put(1,"San Francisco");
      put(2,"Italy");
      put(3,"Greece");
      put(4,"Paris");
      put(5,"New York");
  }};

    @GetMapping("/")
    @ResponseBody
    public String displayHomePage() {
        StringBuilder tripsList = new StringBuilder();
        for(int tripId: trips.keySet()) {
            String trip = trips.get(tripId);
            tripsList.append("<li><a href ='/trips/").append(tripId).append("'>").append(trip).append("</a>");
        }


        return "<h1> Travel Diary </h1>" +
                "<h1> Trips </h1>" +
                "<ul>" +
                tripsList +
                "</ul>" +
                "<h2> + Add new <a href='/add-trips'>trip</a> </h2>";
    }

    @GetMapping("/add-trips")
    @ResponseBody
    public String addTripPage() {
        return "<h2> Add Trip title </h2>" +
                "<h2> Choose a cover photo! </h2>" +
                "<h2> Add description </h2>" +
                "<h2> + Add new photo </h2>";


    }

    @GetMapping("/trips/{tripId}")
    @ResponseBody
    public String displayTripDetails(@PathVariable int tripId){
        return "<h2> Trip: " + trips.get(tripId) + "</h2>";



    }

    }



