package com.backend.clinicaOdontologica;

import com.backend.clinicaOdontologica.dto.PacienteDto;
import com.backend.clinicaOdontologica.entity.Domicilio;
import com.backend.clinicaOdontologica.entity.Paciente;
import com.backend.clinicaOdontologica.service.impl.PacienteService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class PacienteServiceTest {
    PacienteService pacienteService;


    @Autowired
    public PacienteServiceTest(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Test
    void deberiaAgregarUnPaciente(){

        Domicilio domicilio = new Domicilio("Guaviyu", 1359, "Montevideo","Montevideo");

        PacienteDto pacienteDto  = pacienteService.guardarPaciente(new Paciente("Jose", "Rodriguez", "3205632", LocalDate.now(), domicilio));

        Assert.assertNotNull(pacienteService.buscarPacientePorId(pacienteDto.getId()));

    }

    @Test
    void deberiaBuscarUnPacientePorId(){
        Domicilio domicilio = new Domicilio("Guaviyu", 1359, "Montevideo","Montevideo");

        PacienteDto pacienteDto  = pacienteService.guardarPaciente(new Paciente("Jose", "Rodriguez", "3205632", LocalDate.now(), domicilio));

        Assert.assertNotNull(pacienteService.buscarPacientePorId(pacienteDto.getId()));

    }

    @Test
    void deberiaListarTodosLosPacientes(){
        Domicilio domicilio1 = new Domicilio("Guaviyu", 1359, "Montevideo","Montevideo");
        Domicilio domicilio2 = new Domicilio("Jackson", 200, "Montevideo","Montevideo");
        Domicilio domicilio3 = new Domicilio("Mercedes", 59, "Montevideo","Montevideo");

        PacienteDto pacienteDto1 = pacienteService.guardarPaciente(new Paciente("Jose", "Rodriguez", "3205632", LocalDate.now(), domicilio1));
        PacienteDto pacienteDto2 = pacienteService.guardarPaciente(new Paciente("Santiago", "Hernandez", "3205632", LocalDate.now(), domicilio2));
        PacienteDto pacienteDto3 = pacienteService.guardarPaciente(new Paciente("Peter", "Hernandez", "3205632", LocalDate.now(), domicilio3));

        List<PacienteDto> pacienteDtos = pacienteService.listarPacientes();

        Assert.assertFalse(pacienteDtos.isEmpty());
        Assert.assertTrue(pacienteDtos.size() > 2);
    }
}
