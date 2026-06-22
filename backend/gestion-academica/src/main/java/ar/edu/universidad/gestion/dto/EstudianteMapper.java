package ar.edu.universidad.gestion.dto;

import ar.edu.universidad.gestion.model.Estudiante;

public class EstudianteMapper {
    public static EstudianteDTO toDTO(Estudiante e) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(e.getId());
        dto.setNombre(e.getNombre());
        dto.setApellido(e.getApellido());
        dto.setNombreCompleto(e.getNombre() + " " + e.getApellido());
        dto.setLegajo(e.getLegajo());
        return dto;
    }
}