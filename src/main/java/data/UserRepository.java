package data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ncjs.Travel.Diary.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}