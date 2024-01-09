package com.ncjs.Travel.Diary.controllers;

import com.ncjs.Travel.Diary.models.User;
import com.ncjs.Travel.Diary.models.data.TripRepository;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("trips/")
public class TripController {

    @Autowired
    private TripRepository TripRepository;

}
