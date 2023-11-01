package com.example.aula.repositories;

import com.example.aula.models.Cargo;
import com.example.aula.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

    @Query("SELECT * FROM tb_cargo WHERE tb_cargo.cargo_name = :nome")
    public Cargo findCargoByString(@Param("nome") String nome);
}
