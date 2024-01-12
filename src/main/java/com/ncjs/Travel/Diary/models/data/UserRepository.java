package com.ncjs.Travel.Diary.models.data;

import com.ncjs.Travel.Diary.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    // methods
    User findByUsername(String username);

}
