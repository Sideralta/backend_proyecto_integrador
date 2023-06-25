package com.backend.clinicaOdontologica;

import com.backend.clinicaOdontologica.dto.OdontologoDto;
import com.backend.clinicaOdontologica.dto.PacienteDto;
import com.backend.clinicaOdontologica.dto.TurnoDto;
import com.backend.clinicaOdontologica.entity.Domicilio;
import com.backend.clinicaOdontologica.entity.Odontologo;
import com.backend.clinicaOdontologica.entity.Paciente;
import com.backend.clinicaOdontologica.entity.Turno;

import com.backend.clinicaOdontologica.exceptions.BadRequestException;
import com.backend.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.backend.clinicaOdontologica.service.impl.OdontologoService;
import com.backend.clinicaOdontologica.service.impl.PacienteService;
import com.backend.clinicaOdontologica.service.impl.TurnoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TurnoServiceTest {
    TurnoService turnoService;
    OdontologoService odontologoService;
    PacienteService pacienteService;

    @Autowired
    public TurnoServiceTest(TurnoService turnoService, OdontologoService odontologoService, PacienteService pacienteService) {
        this.turnoService = turnoService;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }



    @Test
    void deberiaAgregarUnTurno() throws BadRequestException {

        /*TurnoDto turnoDto = null;
        PacienteDto paciente = pacienteService.buscarPacientePorId(turno.getPaciente().getId());
        OdontologoDto odontologo = odontologoService.buscarOdontologoPorId(turno.getOdontologo().getId());*/

        Domicilio domicilio = new Domicilio("Guaviyu", 1359, "Montevideo", "Montevideo");
        Paciente paciente = new Paciente("Jose", "Rodriguez", "3205632", LocalDate.now(), domicilio);
        Odontologo odontologo = new Odontologo("1235","Jorge","fernandez");



        PacienteDto pacienteDto = pacienteService.guardarPaciente(paciente);
        OdontologoDto odontologoDto = odontologoService.registrarOdontologo(odontologo);





        TurnoDto turnoDto = turnoService.guardarTurno(new Turno(paciente, odontologo, LocalDateTime.of(2025,4,2,10,10,30)));



        Assert.assertNotNull(turnoService.buscarTurnoPorId(turnoDto.getId()));
        Assert.assertEquals(LocalDateTime.of(2025,4,2,10,10,30), turnoDto.getFechaYHora());


    }

    @Test
    void deberiaEliminarTurno() throws BadRequestException, ResourceNotFoundException {
        Domicilio domicilio = new Domicilio("Guaviyu", 1359, "Montevideo", "Montevideo");
        Paciente paciente = new Paciente("Jose", "Rodriguez", "3205632", LocalDate.now(), domicilio);
        Odontologo odontologo = new Odontologo("1235","Jorge","fernandez");

        Domicilio domicilio2 = new Domicilio("Corumbe", 1359, "Montevideo", "Montevideo");
        Paciente paciente2 = new Paciente("Juan", "Perez", "3205652", LocalDate.now(), domicilio2);
        Odontologo odontologo2 = new Odontologo("4444","Fede","Dominguez");


        PacienteDto pacienteDto = pacienteService.guardarPaciente(paciente);
        OdontologoDto odontologoDto = odontologoService.registrarOdontologo(odontologo);

       PacienteDto pacienteDto2 = pacienteService.guardarPaciente(paciente2);
        OdontologoDto odontologoDto2 = odontologoService.registrarOdontologo(odontologo2);





        TurnoDto turnoDto = turnoService.guardarTurno(new Turno(paciente, odontologo, LocalDateTime.of(2025,4,2,10,10,30)));
        TurnoDto turnoDto2 = turnoService.guardarTurno(new Turno(paciente2, odontologo2, LocalDateTime.of(2026,7,2,10,10,30)));

        turnoService.eliminarTurno(turnoDto.getId());
        Assert.assertNull(turnoService.buscarTurnoPorId(turnoDto.getId()));

    }

    @Test
    void deberiaListarTodosLosTurnos() throws BadRequestException {
        Domicilio domicilio = new Domicilio("Guaviyu", 1359, "Montevideo", "Montevideo");
        Paciente paciente = new Paciente("Jose", "Rodriguez", "3205632", LocalDate.now(), domicilio);
        Odontologo odontologo = new Odontologo("1235","Jorge","fernandez");

        Domicilio domicilio2 = new Domicilio("Corumbe", 1359, "Montevideo", "Montevideo");
        Paciente paciente2 = new Paciente("Juan", "Perez", "3205652", LocalDate.now(), domicilio2);
        Odontologo odontologo2 = new Odontologo("4444","Fede","Dominguez");


        PacienteDto pacienteDto = pacienteService.guardarPaciente(paciente);
        OdontologoDto odontologoDto = odontologoService.registrarOdontologo(odontologo);

        PacienteDto pacienteDto2 = pacienteService.guardarPaciente(paciente2);
        OdontologoDto odontologoDto2 = odontologoService.registrarOdontologo(odontologo2);


        TurnoDto turnoDto = turnoService.guardarTurno(new Turno(paciente, odontologo, LocalDateTime.of(2025,4,2,10,10,30)));
        TurnoDto turnoDto2 = turnoService.guardarTurno(new Turno(paciente2, odontologo2, LocalDateTime.of(2026,7,2,10,10,30)));

        List<TurnoDto> turnos = new ArrayList<>(turnoService.listarTodos());

        Assert.assertFalse(turnos.isEmpty());
        Assert.assertTrue(turnos.size() > 1);



    }

}
