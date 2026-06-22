package ar.edu.universidad.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.universidad.gestion.model.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

}
