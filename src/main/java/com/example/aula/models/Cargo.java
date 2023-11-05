package com.example.aula.models;

import com.example.aula.dto.CargoDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_cargo")
public class Cargo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cargo_name", nullable = false, length = 80)
    private String cargoName;

    @ManyToMany(mappedBy = "cargos", fetch = FetchType.EAGER)
    private List<Person> persons = new ArrayList<>();

    public Cargo() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return Objects.equals(id, cargo.id) && Objects.equals(cargoName,
                                                              cargo.cargoName) && Objects.equals(
                persons,
                cargo.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cargoName, persons);
    }
}
