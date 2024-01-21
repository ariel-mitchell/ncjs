package com.ncjs.Travel.Diary.data;

import com.ncjs.Travel.Diary.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
Tag findByName(String name);
}
