package ar.edu.universidad.gestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.universidad.gestion.dto.CarreraDTO;
import ar.edu.universidad.gestion.repository.CarreraRepository;

@Service
public class CarreraService {
    @Autowired
    private CarreraRepository repository;

    public List<CarreraDTO> listarTodos() {
        return repository.findAll().stream().map(c -> {
            CarreraDTO dto = new CarreraDTO();
            dto.setId(c.getId());
            dto.setNombre(c.getNombre());
            dto.setDuracion(c.getDuracion());
            return dto;
        }).toList();
    }
}
