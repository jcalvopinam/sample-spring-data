package com.jcalvopinam.Controller;

import com.jcalvopinam.Domain.Person;
import com.jcalvopinam.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by juanca on 4/15/17.
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public List<Person> getPersons() {
        return personService.getAll();
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable("id") Long id) {
        return personService.get(id);
    }

    @PostMapping(value = "/persons")
    public Person createPerson(@RequestBody Person person) {
        return personService.create(person);
    }

    @DeleteMapping("/persons/{id}")
    public String deletePerson(@PathVariable Long id) {
        return personService.delete(id);
    }

    @PutMapping("/persons/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return personService.update(id, person);
    }

}
