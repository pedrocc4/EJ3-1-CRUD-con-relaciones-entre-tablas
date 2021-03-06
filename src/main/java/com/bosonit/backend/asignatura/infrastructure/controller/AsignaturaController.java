package com.bosonit.backend.asignatura.infrastructure.controller;

import com.bosonit.backend.asignatura.infrastructure.controller.dto.AsignaturaInputDTO;
import com.bosonit.backend.asignatura.infrastructure.controller.dto.AsignaturaOutputDTO;
import com.bosonit.backend.asignatura.service.AsignaturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class AsignaturaController {
    @Autowired
    private AsignaturaService service;

    @PostMapping("asignatura")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<AsignaturaOutputDTO> addAsignatura(@RequestBody AsignaturaInputDTO asignaturaInputDTO) {
        log.info("Intentando agregar: " + asignaturaInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addAsignatura(asignaturaInputDTO));

    }

    @GetMapping("asignatura/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<AsignaturaOutputDTO> getAsignatura(@PathVariable String id) {
        log.info("Intentando obtener asignatura con id: " + id);
        return ResponseEntity.status(HttpStatus.OK).body(service.getAsignatura(id));

    }

    @PutMapping("asignatura/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<AsignaturaOutputDTO> actAsignatura(
            @PathVariable String id,
            @RequestBody AsignaturaInputDTO asignaturaInputDTO) {
        log.info("Intentando modificar asignatura con id: " + id + ", con " + asignaturaInputDTO);
        return ResponseEntity.status(HttpStatus.OK).body(service.actAsignatura(id, asignaturaInputDTO));

    }

    @DeleteMapping("asignatura/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Void> delAsignatura(
            @PathVariable String id) {
        log.info("Intentando borrar asignatura con id: " + id);
        service.delAsignatura(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
