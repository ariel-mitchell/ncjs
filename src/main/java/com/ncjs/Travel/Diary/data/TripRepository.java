package com.ncjs.Travel.Diary.data;

import com.ncjs.Travel.Diary.models.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends CrudRepository<Trip,Integer> {

}