package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.entity.Person;
import io.zipcoder.persistenceapp.service.jdbc.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/people/", method = RequestMethod.POST)
    public ResponseEntity<?> createPerson(@RequestBody Person person) {
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(person.getId())
                .toUri();
        responseHeaders.setLocation(newPollUri);
        return new ResponseEntity<>(personService.addPerson(person), responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePerson(@PathVariable Integer id, @RequestBody Person person){
        return new ResponseEntity<>(personService.updatePerson(person, id),HttpStatus.OK);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getWithId(@PathVariable Integer id){
        return new ResponseEntity<>(personService.findById(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getAllPeople(){
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/surname/{lastName}", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getAllLastName(@PathVariable String lastName){
        return new ResponseEntity<>(personService.findAllWithLastName(lastName),HttpStatus.OK);
    }

    @RequestMapping(value = "/people/firstname/stats", method = RequestMethod.GET)
    public ResponseEntity<Map<String,Long>> getFirstNameStats(){
        return new ResponseEntity<>(personService.mapFirstNameOccurrences(),HttpStatus.OK);
    }

    @RequestMapping(value = "/people/reverselookup/{mobileNumber}", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getByMobile(@PathVariable String mobileNumber){
        return new ResponseEntity<>(personService.findAllWithMobile(mobileNumber), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/surname", method = RequestMethod.GET)
    public ResponseEntity<Map<String,List<Person>>> getSurnameMapping(){
        return new ResponseEntity<>(personService.mapSurnames(), HttpStatus.OK);
    }

}
