package ar.edu.universidad.gestion.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer duracion;

    @OneToMany(mappedBy = "carrera")
    private List<Estudiante> estudiantes;
}
