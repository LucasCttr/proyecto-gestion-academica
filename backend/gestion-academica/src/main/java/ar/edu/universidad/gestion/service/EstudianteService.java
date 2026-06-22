package ar.edu.universidad.gestion.service;

import ar.edu.universidad.gestion.dto.EstudianteDTO;
import ar.edu.universidad.gestion.model.Estudiante;
import ar.edu.universidad.gestion.repository.EstudianteRepository;
import ar.edu.universidad.gestion.dto.EstudianteMapper; // Importamos nuestro mapper
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository repository;

    public List<EstudianteDTO> listarTodos() {
        return repository.findAll().stream()
                .map(EstudianteMapper::toDTO) // Usamos el mapper aquí
                .collect(Collectors.toList());
    }

    public EstudianteDTO guardar(EstudianteDTO dto) {
        Estudiante e = new Estudiante();
        e.setNombre(dto.getNombre());
        e.setApellido(dto.getApellido());
        e.setLegajo(dto.getLegajo());
        repository.save(e);
        return dto;
    }

    public EstudianteDTO obtenerPorId(Long id) {
        Estudiante e = repository.findById(id).orElseThrow();
        return EstudianteMapper.toDTO(e); // Usamos el mapper acá
    }

    public EstudianteDTO actualizar(Long id, EstudianteDTO dto) {
        Estudiante e = repository.findById(id).orElseThrow();

        // Solo actualizamos si el campo del DTO no es nulo
        if (dto.getNombre() != null) e.setNombre(dto.getNombre());
        if (dto.getApellido() != null) e.setApellido(dto.getApellido());
        if (dto.getLegajo() != null) e.setLegajo(dto.getLegajo());

        repository.save(e);
        return EstudianteMapper.toDTO(e);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

