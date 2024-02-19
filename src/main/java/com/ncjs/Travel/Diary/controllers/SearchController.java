package com.ncjs.Travel.Diary.controllers;

import com.ncjs.Travel.Diary.data.TagRepository;
import com.ncjs.Travel.Diary.data.TripRepository;
import com.ncjs.Travel.Diary.dto.triptagDTO;
import com.ncjs.Travel.Diary.models.Tag;
import com.ncjs.Travel.Diary.models.Trip;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//same page 1 get 1 post mapping. same page
//
@Controller
@RequestMapping("search")
public class SearchController {
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TagRepository tagRepository;

    //This pulls up the searchbar form @ localhost:8080/search
    //it returns the template search(html file) in search (folder)
    @GetMapping("")
    public String displaySearch(Model model) {
        model.addAttribute("title", "Search");
        return "search/search";
    }
    @PostMapping("")
    public String processSearch(Model model, @RequestParam String searchTerm) {
        List<Trip> allTrips = (List<Trip>) tripRepository.findAll();
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            model.addAttribute("trips", allTrips);
        } else {
            ArrayList<Trip> trips = new ArrayList<>();
            for (Trip trip : allTrips) {
                for(Tag tag: trip.getTags()) {
                    if (tag.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                        trips.add(trip);
                    }
                }
            }
            model.addAttribute("trips", trips);
        }
        model.addAttribute("All Trips", tripRepository.findAll());
        model.addAttribute("title", "Trips with " + searchTerm);
        return "search/index";
    }
////This processes the searchbar bar form and displays the results @localhost:8080/search/index
    //it returns the template index html file which is in search folder
}


//fix to my specifications: change all columns, we are only searching by name