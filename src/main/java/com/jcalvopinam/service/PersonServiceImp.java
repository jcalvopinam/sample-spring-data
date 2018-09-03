/*
 * MIT License
 *
 * Copyright (c) 2018. JUAN CALVOPINA M
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.jcalvopinam.service;

import com.jcalvopinam.model.Person;
import com.jcalvopinam.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 */
@Service
@Transactional
public class PersonServiceImp implements PersonService {

    private final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImp.class);

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImp(PersonRepository personRepository) {
        LOGGER.info("Autowiring PersonRepository");
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAll() {
        LOGGER.info("Retrieving people");
        return personRepository.findAll();
    }

    @Override
    public Person get(Long id) {
        LOGGER.info("Retrieving {} person", id);
        return personRepository.getOne(id);
    }

    @Override
    public Person create(Person person) {
        LOGGER.info("Creating a new person {}", person.toString());
        return personRepository.save(person);
    }

    @Override
    public String delete(Long id) {
        String message = "The person was deleted successfully";
        LOGGER.info("Deleting person {}", id);
        personRepository.deleteById(id);
        LOGGER.info(message + ": {}", id);
        return message;
    }

    @Override
    public Person update(Long id, Person person) {
        LOGGER.info("Updating person {}", id);
        person.setId(id);
        return personRepository.save(person);
    }

}
