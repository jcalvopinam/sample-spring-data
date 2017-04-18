package com.jcalvopinam.service;

import com.jcalvopinam.Domain.Person;
import com.jcalvopinam.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by juanca on 4/15/17.
 */
@Service
@Transactional
public class PersonServiceImp implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person get(Long id) {
        return personRepository.getOne(id);
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    public String delete(Long id) {
        personRepository.delete(id);
        return "The person was deleted successfully";
    }

    @Override
    public Person update(Long id, Person person) {
        person.setId(id);
        return personRepository.save(person);
    }

}
