package ar.edu.universidad.gestion.repository;

import ar.edu.universidad.gestion.model.Estudiante;

import java.lang.foreign.Linker.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Optional<Estudiante> findByLegajo(String legajo);

    
}