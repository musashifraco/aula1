package com.example.aula.dto;

import com.example.aula.models.Cargo;
import com.example.aula.models.Person;

import java.util.List;
import java.util.Objects;

public class PersonDTO {
        private Long id;
        private String firstName;
        private String lastName;
        private String personBio;
        private List<String> cargos;
        private String address;
        private String gender;

        public PersonDTO(Person entity) {
            id = entity.getId();
            firstName = entity.getFirstName();
            lastName = entity.getLastName();
            personBio = entity.getPersonBio();
            cargos = entity.getCargos().stream().map(Cargo::getCargoName).toList();
            address = entity.getAddress();
            gender = entity.getGender();

        }

        public Long getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getPersonBio() {
            return personBio;
        }

        public List<String> getCargos() {
            return cargos;
        }

        public String getAddress() {
            return address;
        }

        public String getGender() {
            return gender;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(id, personDTO.id) && Objects.equals(firstName,
                                                                  personDTO.firstName) && Objects.equals(
                lastName,
                personDTO.lastName) && Objects.equals(personBio, personDTO.personBio) && Objects.equals(
                cargos,
                personDTO.cargos) && Objects.equals(address,
                                                    personDTO.address) && Objects.equals(gender,
                                                                                         personDTO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, personBio, cargos, address, gender);
    }
}
