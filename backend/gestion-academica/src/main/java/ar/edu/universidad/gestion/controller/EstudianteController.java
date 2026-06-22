package ar.edu.universidad.gestion.controller;

import ar.edu.universidad.gestion.dto.EstudianteDTO;
import ar.edu.universidad.gestion.service.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService service;

    @Operation(summary = "Obtiene todos los estudiantes")
    @ApiResponse(responseCode = "200", description = "Lista de estudiantes obtenida con éxito")
    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> obtenerTodos() {
        return new ResponseEntity<>(service.listarTodos(), HttpStatus.OK);
    }

    @Operation(summary = "Crea un nuevo estudiante")
    @ApiResponse(responseCode = "201", description = "Estudiante creado con éxito")
    @PostMapping
    public ResponseEntity<EstudianteDTO> crear(@RequestBody EstudianteDTO dto) {
        EstudianteDTO nuevo = service.guardar(dto);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene un estudiante por su ID")
    @ApiResponse(responseCode = "200", description = "Estudiante obtenido con éxito")
    public ResponseEntity<EstudianteDTO> obtenerPorId(@PathVariable Long id) {
        EstudianteDTO estudiante = service.obtenerPorId(id);
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza un estudiante existente")
    @ApiResponse(responseCode = "200", description = "Estudiante actualizado con éxito")
    public ResponseEntity<EstudianteDTO> actualizar(@PathVariable Long id, @RequestBody EstudianteDTO dto) {
        EstudianteDTO estudianteActualizado = service.actualizar(id, dto);
        return new ResponseEntity<>(estudianteActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un estudiante")
    @ApiResponse(responseCode = "204", description = "Estudiante eliminado con éxito")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}