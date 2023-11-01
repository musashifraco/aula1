package com.example.aula.dto;

import com.example.aula.models.Person;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PersonMinDTO {

    private Long id;

    private String firstName;

    private String personBio;

    public PersonMinDTO() {

    }

    public PersonMinDTO(Person entity) {
        id = entity.getId();
        firstName = entity.getFirstName();
        personBio = entity.getPersonBio();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPersonBio() {
        return personBio;
    }
}
