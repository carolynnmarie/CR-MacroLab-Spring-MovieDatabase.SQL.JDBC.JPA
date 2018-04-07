package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PersonService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addPerson(){ }

    public void updatePerson(){}

    public void removePerson(){ }

    public void removeListOfPeople(){}

    public Person findById(){}

    public List<Person> findAllWithFirstName(){}

    public List<Person> findAllWithLastName(){}

    public List<Person> findAllWithBirthday(){}

}
