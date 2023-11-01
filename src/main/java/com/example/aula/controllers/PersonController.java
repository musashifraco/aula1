package com.example.aula.controllers;

import com.example.aula.dto.PersonDTO;
import com.example.aula.dto.PersonMinDTO;
import com.example.aula.models.Person;
import com.example.aula.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonDTO> findAll() {
        List<PersonDTO> result = personService.findAll();
        return result;
    }

    @PostMapping
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        PersonDTO result = personService.create(personDTO);
        return result;
    }
}
