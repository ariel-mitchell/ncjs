package com.ncjs.Travel.Diary.models.data;

import com.ncjs.Travel.Diary.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {
}
