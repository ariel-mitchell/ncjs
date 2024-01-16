package com.ncjs.Travel.Diary.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ncjs.Travel.Diary.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}