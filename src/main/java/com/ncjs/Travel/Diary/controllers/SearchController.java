package com.ncjs.Travel.Diary.controllers;

import com.ncjs.Travel.Diary.data.TagRepository;
import com.ncjs.Travel.Diary.data.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//do i need a list controller? Everything Below Please Fix
//
@Controller
@RequestMapping("search")
public class SearchController {
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TagRepository tagRepository;

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("title", "Search");
        return "search";
    }

////
////    // TODO #3 - Create a handler to process a search request and render the updated search view.
//    @PostMapping("index")
//    public String displaySearchResults(Model model, @RequestParam String ){
//        Iterable<Trip> trips;
//        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
//            trips = tripRepository.findAll();
//        } else {
//            trips = tripRespository.findById(searchType, searchTerm, jobRepository.findAll());
//        }
//        model.addAttribute("columns", columnChoices);
//        model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
//        model.addAttribute("trips", trips);
//
//        return "search";
//    }
}


//fix to my specifications: change all columns, we are only searching by name