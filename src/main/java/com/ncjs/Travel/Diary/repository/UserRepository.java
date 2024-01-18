// This is used to save user information to the MySQL database.
package com.ncjs.Travel.Diary.repository;

import com.ncjs.Travel.Diary.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    // custom methods
    User findByUsername(String username);

}
