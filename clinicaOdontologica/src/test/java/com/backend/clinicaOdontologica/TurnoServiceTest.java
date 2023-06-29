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
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(1)
    void deberiaAgregarTurnos() throws BadRequestException {

        Domicilio domicilio = new Domicilio("Guaviyu", 1359, "Montevideo", "Montevideo");
        Paciente paciente = new Paciente("Jose", "Rodriguez", "3205632", LocalDate.now(), domicilio);
        Odontologo odontologo = new Odontologo("1235","Jorge","fernandez");

        Domicilio domicilio2 = new Domicilio("Corumbe", 1359, "Montevideo", "Montevideo");
        Paciente paciente2 = new Paciente("Juan", "Perez", "3205652", LocalDate.now(), domicilio2);
        Odontologo odontologo2 = new Odontologo("4444","Fede","Dominguez");

        Domicilio domicilio3 = new Domicilio("Jackson", 1359, "Montevideo", "Montevideo");
        Paciente paciente3 = new Paciente("Sofia", "Mendez", "565656", LocalDate.now(), domicilio3);
        Odontologo odontologo3 = new Odontologo("3333","Federico","Dominguez");


        PacienteDto pacienteDto = pacienteService.guardarPaciente(paciente);
        OdontologoDto odontologoDto = odontologoService.registrarOdontologo(odontologo);

        PacienteDto pacienteDto2 = pacienteService.guardarPaciente(paciente2);
        OdontologoDto odontologoDto2 = odontologoService.registrarOdontologo(odontologo2);

        PacienteDto pacienteDto3 = pacienteService.guardarPaciente(paciente3);
        OdontologoDto odontologoDto3 = odontologoService.registrarOdontologo(odontologo3);


        TurnoDto turnoDto = turnoService.guardarTurno(new Turno(paciente, odontologo, LocalDateTime.of(2025,4,2,10,10,30)));
        TurnoDto turnoDto2 = turnoService.guardarTurno(new Turno(paciente2, odontologo2, LocalDateTime.of(2026,7,2,10,10,30)));
        TurnoDto turnoDto3 = turnoService.guardarTurno(new Turno(paciente3, odontologo3, LocalDateTime.of(2025,4,2,11,10,30)));


        Assert.assertNotNull(turnoService.buscarTurnoPorId(turnoDto.getId()));
        Assert.assertNotNull(turnoService.buscarTurnoPorId(turnoDto2.getId()));
        Assert.assertNotNull(turnoService.buscarTurnoPorId(turnoDto3.getId()));
        Assert.assertEquals(LocalDateTime.of(2026,7,2,10,10,30), turnoDto2.getFechaYHora());


    }

    @Test
    @Order(2)
    void deberiaEliminarTurno() throws BadRequestException, ResourceNotFoundException {

        turnoService.eliminarTurno(1L);
        Assert.assertNull(turnoService.buscarTurnoPorId(1L));

    }

    @Test
    @Order(3)
    void deberiaListarTodosLosTurnos() throws BadRequestException {


        List<TurnoDto> turnos = new ArrayList<>(turnoService.listarTodos());

        Assert.assertFalse(turnos.isEmpty());
        Assert.assertTrue(turnos.size() > 1);



    }

}
