package com.ncjs.Travel.Diary.models;
//package controllers;
//package data;
import jakarta.persistence.*;
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.sql.Blob;

@Entity
public class Trip extends AbstractEntity {

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private com.ncjs.Travel.Diary.models.User User;

    public Trip() {};
    // Initialize the id and value fields.
    public Trip(User anUser) {
        super();
        this.User = anUser;
    }

    public com.ncjs.Travel.Diary.models.User getUser() {
        return User;
    }

    public void setUser(com.ncjs.Travel.Diary.models.User user) {
        User = user;
    }

    public List<Tag> getTags() {
        return tags;
    }
public void addTag(Tag tag) {
        this.tags.add(tag);
}
public void removeTag(Tag tag) {
        this.tags.remove(tag);
}

//Nidia's Code for trip
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Blob image;

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    private boolean favorite;

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}

//    @ManyToOne(cascade = CascadeType.ALL)
//    @Valid
//    @NotNull
//
//}

// Does Trip Extend Abstract Entity if it has its own ID that is seperate from unique user ID?
//Ask Nidia --> Should be option to add photos or images. Presumably each trip has its own table which will
// have the options to add photos and tags to those photos along with the description --> connect to TripRepository
// will this be in trip controller or will it be an images controller
