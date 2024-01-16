package com.ncjs.Travel.Diary.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
//Rethink Abstract Entity here
@Entity
public class Tag extends AbstractEntity {

    @Size(min =1, max=50)
    @NotBlank
    private String name;
@ManyToMany(mappedBy = "tags")
    private List<Trip> trips = new ArrayList<>();

    public Tag(String name) { this.name=name;}
    public Tag(){};

    public String getName() {
        return name;
    }
    public String getDisplayName() {
        return "#" + name + " ";
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Trip> getTrips() {
        return trips;
    }
}