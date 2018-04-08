package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class personController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/people/",)
}
