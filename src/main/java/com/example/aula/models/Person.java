package com.example.aula.models;
import com.example.aula.dto.PersonDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_person")
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 80)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;

    @Column(name = "person_bio", nullable = false, length = 80)
    private String personBio;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "person_cargo",
            joinColumns = {
                    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "person_id", referencedColumnName = "id")
            })
    private List<Cargo> cargos = new ArrayList<>();


    @Column( nullable = false, length = 100)
    private String address;

    @Column( nullable = false, length = 6)
    private String gender;

    public Person() {}

    public Person(PersonDTO personDTO) {
        this.id = personDTO.getId();
        this.firstName = personDTO.getFirstName();
        this.lastName = personDTO.getLastName();
        this.personBio = personDTO.getPersonBio();
        this.address = personDTO.getAddress();
        this.gender = personDTO.getGender();
    }
    public Person(List<Cargo> cargos) {
        this.cargos = cargos;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonBio() {
        return personBio;
    }

    public void setPersonBio(String personBio) {
        this.personBio = personBio;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos.clear();
        this.cargos.addAll(cargos);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(firstName,
                                                               person.firstName) && Objects.equals(
                lastName,
                person.lastName) && Objects.equals(personBio,
                                                   person.personBio) && Objects.equals(cargos,
                                                                                       person.cargos) && Objects.equals(
                address,
                person.address) && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, personBio, cargos, address, gender);
    }
}