package com.example.aula.controllers;

import com.example.aula.dto.CargoDTO;
import com.example.aula.models.Cargo;
import com.example.aula.models.Person;
import com.example.aula.services.CargoService;
import com.example.aula.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cargos")
public class CargoController {
    @Autowired
    private CargoService cargoService;

    @GetMapping(value = "/{id}")
    public CargoDTO findById(@PathVariable(value = "id") Long id) {
        return cargoService.findById(id);
    }

    @GetMapping
    public List<CargoDTO> findAll() {
        List<CargoDTO> result = cargoService.findAll();
        return result;
    }

    @PostMapping
    public CargoDTO create(@RequestBody CargoDTO cargoDTO) {
        return cargoService.create(cargoDTO);
    }

    @PutMapping
    public CargoDTO update(@RequestBody CargoDTO cargoDTO) {
        return cargoService.update(cargoDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        cargoService.delete(id);
    }
}
