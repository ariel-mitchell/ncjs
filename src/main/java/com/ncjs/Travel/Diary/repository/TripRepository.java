package com.ncjs.Travel.Diary.repository;

import com.ncjs.Travel.Diary.models.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends CrudRepository<Trip, Integer> {
}
