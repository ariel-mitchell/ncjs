package com.ncjs.Travel.Diary.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class PersonalQuestions extends AbstractEntity {

        @Size(max = 100, message = "Please enter up to 100 characters")
        private String educationLevel;
        @Size(max = 100, message = "Please enter up to 100 characters")
        private String ethnicity;

        @Size(max = 100, message = "Please enter up to 100 characters")
        private String gender;

    @Size(max = 100, message = "Please enter up to 100 characters")
    private String generation;


    public  PersonalQuestions() {};


    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public PersonalQuestions(String educationLevel, String ethnicity, String gender, String generation
    ) {
            this.educationLevel = educationLevel;
            this.ethnicity = ethnicity;
            this.gender = gender;
            this.generation = generation;
        }

    }
