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

//do i need a list controller? Everything Below Please Fix
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
    public String processSearch(Model model) {
        return "search/index";
    }
////This processes the searchbar bar form and displays the results @localhost:8080/search/index
    //it returns the template index html file which is in search folder
//    // TODO #3 - Create a handler to process a search request and render the updated search view.
    @PostMapping("/index")
    public String displaySearchResults(Model model, @RequestParam String searchTerm, @ModelAttribute @Valid triptagDTO tripTag, Trip trip){
        Iterable<Trip> trips;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            trips = tripRepository.findAll();
        } else {
            trips = (tagRepository.findByName(searchTerm)).getTrips();
            //trips = tagRepository.findById(searchTerm);
        }
        model.addAttribute("title", "Trips with " + searchTerm);
        model.addAttribute("trips", trips);

        return "search/index";
    }
}


//fix to my specifications: change all columns, we are only searching by name