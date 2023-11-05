package com.example.aula.services;

import com.example.aula.dto.CargoDTO;
import com.example.aula.dto.PersonDTO;
import com.example.aula.models.Cargo;
import com.example.aula.models.Person;
import com.example.aula.repositories.CargoRepository;
import com.example.aula.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    public List<CargoDTO> findAll() {
        List<Cargo> resultsList = cargoRepository.findAll();
        return resultsList.stream().map(CargoDTO::new).toList();
    }

    public CargoDTO findById(Long id) {
        Cargo cargo = cargoRepository.findById(id).orElseThrow();
        return new CargoDTO(cargo);
    }

    public CargoDTO create(CargoDTO cargoDTO) {
        Cargo cargo = new Cargo(cargoDTO);
        return new CargoDTO(cargoRepository.save(cargo));
    }

    public CargoDTO update(CargoDTO cargoDTO) {
        Cargo cargo = cargoRepository.findById(cargoDTO.getId()).orElseThrow();
        cargo.setCargoName(cargoDTO.getCargoName());
        return new CargoDTO(cargoRepository.save(cargo));
    }

    public void delete(Long id) {
        Cargo cargo = cargoRepository.findById(id).orElseThrow();
        cargoRepository.delete(cargo);
    }
}
