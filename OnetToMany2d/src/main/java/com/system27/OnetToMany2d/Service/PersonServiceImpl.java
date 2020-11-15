package com.system27.OnetToMany2d.Service;

import com.system27.OnetToMany2d.Repo.CarRepo;
import com.system27.OnetToMany2d.Repo.PersonRepo;
import com.system27.OnetToMany2d.model.Car;
import com.system27.OnetToMany2d.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PesonService {
    private final CarRepo carRepo;
    private final PersonRepo personRepo;


    public List<Person> findAllPerson() {
        return (List<Person>) personRepo.findAll();
    }


    public Person savePerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    public Person saveCar(String id, Car car) {
         return personRepo.findById(Integer.parseInt(id)).map(person -> {
            car.setPerson(person);
            carRepo.save(car);
            return personRepo.findById(Integer.parseInt(id)).get();
        }).orElse(new Person());
    }

    public List<Car> findAllCar() {
        return (List<Car>) carRepo.findAll();
    }

    public Person deletecar(String id, String carId) {
         if(personRepo.existsById(Integer.parseInt(id))){
            carRepo.deleteById(Integer.parseInt(carId));
            return personRepo.findById(Integer.parseInt(id)).get();
         }
         return null;
    }
}
