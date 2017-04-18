package com.jcalvopinam.service;

import com.jcalvopinam.Domain.Person;

import java.util.List;

/**
 * Created by juanca on 4/15/17.
 */

public interface PersonService {

    List<Person> getAll();

    Person get(Long id);

    Person create(Person person);

    String delete(Long id);

    Person update(Long id, Person person);

}
