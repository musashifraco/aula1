package com.example.aula.services;

import com.example.aula.dto.PersonDTO;
import com.example.aula.dto.PersonMinDTO;
import com.example.aula.models.Cargo;
import com.example.aula.models.Person;
import com.example.aula.repositories.CargoRepository;
import com.example.aula.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CargoRepository cargoRepository;


    public List<PersonDTO> findAll() {
        List<Person> resultsList = personRepository.findAll();
        return resultsList.stream().map(PersonDTO::new).toList();
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }
}
