package com.example.aula.repositories;

import com.example.aula.models.Cargo;
import com.example.aula.models.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

    @Query(value = "SELECT * FROM tb_cargo WHERE tb_cargo.cargo_name = :nome", nativeQuery = true)
    Cargo findCargoByString(@Param("nome") String nome);
}
