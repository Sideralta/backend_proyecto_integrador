package com.backend.clinicaOdontologica;

import com.backend.clinicaOdontologica.dto.PacienteDto;
import com.backend.clinicaOdontologica.entity.Domicilio;
import com.backend.clinicaOdontologica.entity.Paciente;
import com.backend.clinicaOdontologica.service.impl.PacienteService;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PacienteServiceTest {
    PacienteService pacienteService;


    @Autowired
    public PacienteServiceTest(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Test
    @Order(1)
    void deberiaAgregarPacientes() {

        Domicilio domicilio1 = new Domicilio("Guaviyu", 1359, "Montevideo", "Montevideo");
        Domicilio domicilio2 = new Domicilio("Jackson", 200, "Montevideo", "Montevideo");
        Domicilio domicilio3 = new Domicilio("Mercedes", 59, "Montevideo", "Montevideo");

        PacienteDto pacienteDto1 = pacienteService.guardarPaciente(new Paciente("Jose", "Rodriguez", "3205632", LocalDate.now(), domicilio1));
        PacienteDto pacienteDto2 = pacienteService.guardarPaciente(new Paciente("Santiago", "Hernandez", "3205632", LocalDate.now(), domicilio2));
        PacienteDto pacienteDto3 = pacienteService.guardarPaciente(new Paciente("Peter", "Hernandez", "3205632", LocalDate.now(), domicilio3));


        Assert.assertNotNull(pacienteService.buscarPacientePorId(pacienteDto1.getId()));
        Assert.assertNotNull(pacienteService.buscarPacientePorId(pacienteDto2.getId()));
        Assert.assertNotNull(pacienteService.buscarPacientePorId(pacienteDto3.getId()));

    }

    @Test
    @Order(2)
    void deberiaBuscarUnPacientePorId() {

        Assert.assertNotNull(pacienteService.buscarPacientePorId(2L));

    }

    @Test
    @Order(3)
    void deberiaListarTodosLosPacientes() {


        List<PacienteDto> pacienteDtos = pacienteService.listarPacientes();

        Assert.assertFalse(pacienteDtos.isEmpty());
        Assert.assertTrue(pacienteDtos.size() > 2);
    }
}
