package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.OdontologoDto;
import com.backend.clinicaOdontologica.dto.PacienteDto;
import com.backend.clinicaOdontologica.entity.Odontologo;
import com.backend.clinicaOdontologica.entity.Paciente;
import com.backend.clinicaOdontologica.repository.IDao;
import com.backend.clinicaOdontologica.dto.TurnoDto;
import com.backend.clinicaOdontologica.entity.Turno;
import com.backend.clinicaOdontologica.repository.PacienteRepository;
import com.backend.clinicaOdontologica.repository.TurnoRepository;
import com.backend.clinicaOdontologica.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.backend.clinicaOdontologica.utils.JsonPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TurnoService.class);
    private final TurnoRepository turnoRepository;
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoRepository = turnoRepository;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }





    @Override
    public TurnoDto guardarTurno(Turno turno) {

        PacienteDto paciente =  pacienteService.buscarPacientePorId(turno.getPaciente().getId());
        OdontologoDto odontologo = odontologoService.buscarOdontologoPorId(turno.getOdontologo().getId());
        TurnoDto turnoDto = TurnoDto.fromTurno(turnoRepository.save(turno));
        LOGGER.info("Nuevo turno registrado con exito: {}", turnoDto);
        return turnoDto;
    }

    @Override
    public List<TurnoDto> listarTodos() {

        List<Turno> turnos = turnoRepository.findAll();
        List<TurnoDto> turnoDtoList = turnos.stream()
                .map(TurnoDto::fromTurno)
                .toList();
        LOGGER.info("Lista de todos los turnos: {}", JsonPrinter.toString(turnoDtoList));
        return turnoDtoList;
    }

    @Override
    public TurnoDto buscarTurnoPorId(Long id) {
        Turno turnoBuscado = turnoRepository.findById(id).orElse(null);
        TurnoDto turnoDto = null;
        if (turnoBuscado != null){
            turnoDto = TurnoDto.fromTurno(turnoBuscado);
            LOGGER.info("Turno encontrado: {}", JsonPrinter.toString(turnoDto));
        }else LOGGER.info("El id no se encuentra registrado en la base de datos");
        return turnoDto;
    }

    @Override
    public TurnoDto actualizarTurno(Turno turno) {
        Turno turnoActualizar = turnoRepository.findById(turno.getId()).orElse(null);
        TurnoDto turnoActulizarDto = null;
        if (turnoActualizar != null){
            turnoActualizar = turno;
            turnoRepository.save(turnoActualizar);
            turnoActulizarDto = TurnoDto.fromTurno(turnoActualizar);
            LOGGER.warn("Turno actualizado con exito: {}", JsonPrinter.toString(turnoActulizarDto));
        } else LOGGER.error("No se realizo actualizacion ya que no se encontro el turno");
        return turnoActulizarDto;
    }

    @Override
    public void eliminarTurno(Long id) {
        if (buscarTurnoPorId(id) != null){
            turnoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el turno con id: {}", id);

        } else{
            LOGGER.error("No se ah encontrado paciente con el id " + id);
        }
    }
}
