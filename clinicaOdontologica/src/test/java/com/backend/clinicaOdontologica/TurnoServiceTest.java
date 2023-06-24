package com.backend.clinicaOdontologica;

import com.backend.clinicaOdontologica.dto.OdontologoDto;
import com.backend.clinicaOdontologica.dto.PacienteDto;
import com.backend.clinicaOdontologica.dto.TurnoDto;
import com.backend.clinicaOdontologica.entity.Domicilio;
import com.backend.clinicaOdontologica.entity.Odontologo;
import com.backend.clinicaOdontologica.entity.Paciente;
import com.backend.clinicaOdontologica.entity.Turno;

import com.backend.clinicaOdontologica.service.impl.OdontologoService;
import com.backend.clinicaOdontologica.service.impl.PacienteService;
import com.backend.clinicaOdontologica.service.impl.TurnoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    void deberiaAgregarUnTurno()   {


        Domicilio domicilio = new Domicilio("Guaviyu", 1359, "Montevideo","Montevideo");
        Paciente paciente = new Paciente("Jose", "Rodriguez", "3205632", LocalDate.now(), domicilio);
        Odontologo odontologo = new Odontologo("1235","Jorge","fernandez");
        //PacienteDto pacienteDto = pacienteService.guardarPaciente();
        //OdontologoDto odontologo1 = odontologoService.registrarOdontologo();



        PacienteDto pacienteDto = pacienteService.guardarPaciente(paciente);
        OdontologoDto odontologoDto = odontologoService.registrarOdontologo(odontologo);




        TurnoDto turnoDto = turnoService.guardarTurno(new Turno(paciente, odontologo, LocalDateTime.now()));

        Assert.assertNotNull(turnoService.buscarTurnoPorId(turnoDto.getId()));
       // Assert.assertEquals(LocalDateTime.now(), turnoDto.getFechaYHora());


    }

}
