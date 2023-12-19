package com.ncjs.Travel.Diary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        return "<form action='/add-trips' method='post'>" +
                "<label for='tripTitle'>Trip:</label>" +
                "<input type='text' id='tripTitle' name='tripTitle' required><br>" +
                "<input type='submit' value='Add Trip'>" +
                "</form>";
    }

    @PostMapping("/add-trips")
    @ResponseBody
    public String addTrip(@RequestParam String tripTitle) {
        trips.put(nextId, tripTitle);
        nextId++;
        return "<h2> Trip added successfully: " + tripTitle + "</h2>";
    }


    @GetMapping("/trips/{tripId}")
    @ResponseBody
    public String displayTripDetails(@PathVariable int tripId){
        return "<h2> Trip: " + trips.get(tripId) + "</h2>" +
               "<h2> ID: " + tripId + "</h2>";



    }

    }



