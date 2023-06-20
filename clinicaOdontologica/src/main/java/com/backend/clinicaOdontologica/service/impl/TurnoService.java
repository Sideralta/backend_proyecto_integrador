package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.repository.IDao;
import com.backend.clinicaOdontologica.dto.TurnoDto;
import com.backend.clinicaOdontologica.entity.Turno;
import com.backend.clinicaOdontologica.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    private final IDao<Turno> turnoIDao;

    @Autowired
    public TurnoService(IDao<Turno> turnoIDao) {
        this.turnoIDao = turnoIDao;

    }

    @Override
    public TurnoDto guardarTurno(Turno turno) {

        return TurnoDto.fromTurno(turnoIDao.guardar(turno));
    }

    @Override
    public List<TurnoDto> listarTodos() {
        return turnoIDao.listarTodos().stream().map(TurnoDto::fromTurno).toList();
    }

    @Override
    public TurnoDto buscarTurnoPorId(Long id) {
        return TurnoDto.fromTurno(turnoIDao.buscarPorId(id));
    }

    @Override
    public TurnoDto actualizarTurno(Turno turno) {
        return TurnoDto.fromTurno(turnoIDao.actualizar(turno));
    }

    @Override
    public void eliminarTurno(int id) {
      turnoIDao.eliminar(id);
    }
}
