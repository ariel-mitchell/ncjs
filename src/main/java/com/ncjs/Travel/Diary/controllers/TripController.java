package com.ncjs.Travel.Diary.controllers;

import com.ncjs.Travel.Diary.repository.TripRepository;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("trips/")
public class TripController {

    @Autowired
    private TripRepository TripRepository;

}
