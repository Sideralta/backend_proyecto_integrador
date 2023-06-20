package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.dto.TurnoDto;
import com.backend.clinicaOdontologica.entity.Turno;

import java.util.List;

public interface ITurnoService {
    TurnoDto guardarTurno(Turno turno);
    List<TurnoDto> listarTodos();

    TurnoDto buscarTurnoPorId(int id);
    TurnoDto actualizarTurno(Turno turno);
    void eliminarTurno(int id);

}
