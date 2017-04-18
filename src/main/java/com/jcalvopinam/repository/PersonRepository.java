package com.jcalvopinam.repository;

import com.jcalvopinam.Domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by juanca on 4/15/17.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
