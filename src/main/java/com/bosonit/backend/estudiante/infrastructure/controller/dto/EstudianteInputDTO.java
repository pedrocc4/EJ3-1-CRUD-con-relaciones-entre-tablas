package com.bosonit.backend.estudiante.infrastructure.controller.dto;

import com.bosonit.backend.persona.domain.Persona;
import lombok.Data;

@Data
public class EstudianteInputDTO {
    private int num_hours_week;
    private String comments;
    private String branch;
    private Persona id_persona;
}