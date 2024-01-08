package com.ncjs.Travel.Diary.data;

import com.ncjs.Travel.Diary.models.Trip;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TripsData {

    private static final Map<Integer, Trip> trips= new HashMap<>();

    public static void add(Trip trip) {
        trips.put(trip.getId(), trip);
    }

    public static Trip findById(int id) {
        return trips.get(id);
    }

    public static Collection<Trip> getAll() {
        return trips.values();
    }

    public static void remove(int id) {
        trips.remove(id);
    }

}
