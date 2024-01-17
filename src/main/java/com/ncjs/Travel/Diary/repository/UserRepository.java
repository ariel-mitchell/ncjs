// This is used to save user information to the MySQL database.
package com.ncjs.Travel.Diary.repository;

import com.ncjs.Travel.Diary.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    // custom method
    User findByUsername(String username);

// TODO - I think this needs a save method
//    default User save(user); {
//        return null;
//    }

}
