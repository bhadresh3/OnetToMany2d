package com.system27.OnetToMany2d.Repo;

import com.system27.OnetToMany2d.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepo extends CrudRepository<Car, Integer> {
}
