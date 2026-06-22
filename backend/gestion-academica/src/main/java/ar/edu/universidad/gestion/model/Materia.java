package ar.edu.universidad.gestion.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer nivel;

    @ManyToMany
    @JoinTable(name = "materia_profesor", joinColumns = @JoinColumn(name = "materia_id"), inverseJoinColumns = @JoinColumn(name = "profesor_id"))
    private Set<Profesor> profesores;
}