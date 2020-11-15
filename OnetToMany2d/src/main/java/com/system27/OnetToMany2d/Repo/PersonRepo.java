package com.system27.OnetToMany2d.Repo;

import com.system27.OnetToMany2d.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends CrudRepository<Person, Integer> {
}
