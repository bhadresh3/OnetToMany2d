package com.system27.OnetToMany2d.Controller;

import com.system27.OnetToMany2d.Service.PersonServiceImpl;
import com.system27.OnetToMany2d.model.Car;
import com.system27.OnetToMany2d.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonServiceImpl personService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> findAllPerson(){
        return personService.findAllPerson();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person saveUser(@RequestBody Person person){
        return personService.savePerson(person);
    }

    @PostMapping
    @RequestMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Person saveCar(@PathVariable("id") String id, @RequestBody Car car){
        return personService.saveCar(id, car);
    }

    @GetMapping
    @RequestMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> findAllCar(){
        return personService.findAllCar();
    }

    @DeleteMapping
    @RequestMapping("/{id}/{carId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Person deleteCar(@PathVariable("id") String id, @PathVariable("carId") String carId){
        return personService.deletecar(id, carId);
    }

}
