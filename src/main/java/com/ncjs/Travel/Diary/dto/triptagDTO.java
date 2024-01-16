package com.ncjs.Travel.Diary.dto;

import com.ncjs.Travel.Diary.models.Tag;
import com.ncjs.Travel.Diary.models.Trip;
import jakarta.validation.constraints.NotNull;

public class triptagDTO {
    @NotNull
    private Tag tag;
    @NotNull
    private Trip trip;

    public triptagDTO() {};
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

}
