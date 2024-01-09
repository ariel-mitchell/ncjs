package com.ncjs.Travel.Diary.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//import org.hibernate.annotations.Table;

@Entity
@Table(name = "trip")
public class Trip extends AbstractEntity {

    @ManyToOne
    private User users;

    private String title;

//    public Long getId( ) { return id; }
//
//    public void setId(Long id) { this.id = id; }

    public String getTitle( ) { return title; }

    public void setTitle(String title) { this.title = title; }

}
