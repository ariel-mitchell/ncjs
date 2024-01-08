package com.ncjs.Travel.Diary.models;

public class Trip {

    private static int nextId = 1;
    private final int id;

    private String trip;

    public Trip(String trip) {
        this.id = nextId;
        this.trip = trip;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    @Override
    public String toString() {
        return trip;
    }

}
