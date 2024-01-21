package com.ncjs.Travel.Diary.dto;

import com.ncjs.Travel.Diary.models.Tag;
import com.ncjs.Travel.Diary.models.Trip;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;

public class triptagDTO {
    @NotNull
    private Tag tag;
    @NotNull
    private Trip trip;

    public triptagDTO() {
    }

    ;

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }


    //    /**
//     * Search all Job fields for the given term.
//     *
//     * @param value The search term to look for.
//     * @param allJobs The list of jobs to search.
//     * @return      List of all jobs with at least one field containing the value.
//     */
//    public static ArrayList<Trip> findByValue(String value, Iterable<Trip> allTrips) {
//
//
//        ArrayList<Trip> results = new ArrayList<>();
//
//        for (Trip trip : allTrips) {
//
//            if (Trip.getName().toLowerCase().contains(value.toLowerCase())) {
//                results.add(trip);
//            } else if (trip.getTags().toString().toLowerCase().contains(value.toLowerCase())) {
//                results.add(trip);
////            } else if (trip.getSkills().toString().toLowerCase().contains(value.toLowerCase())) {
////                results.add(job);
////            }
//
//            }
//            return results;
//        }
//        return results;
//    }
}