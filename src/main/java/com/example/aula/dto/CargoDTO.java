package com.example.aula.dto;

import com.example.aula.models.Cargo;
import com.example.aula.models.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

public class CargoDTO {
    private Long id;

    private String cargoName;

    private List<Person> persons;

    public CargoDTO(Cargo entity) {
        id = entity.getId();
        cargoName = entity.getCargoName();
        persons = entity.getPersons();
    }

    public Long getId() {
        return id;
    }

    public String getCargoName() {
        return cargoName;
    }

    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoDTO cargoDTO = (CargoDTO) o;
        return Objects.equals(id, cargoDTO.id) && Objects.equals(cargoName,
                                                                 cargoDTO.cargoName) && Objects.equals(
                persons,
                cargoDTO.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cargoName, persons);
    }
}
