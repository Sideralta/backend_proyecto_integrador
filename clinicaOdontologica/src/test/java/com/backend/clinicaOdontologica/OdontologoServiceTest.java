package com.backend.clinicaOdontologica;

import com.backend.clinicaOdontologica.dto.OdontologoDto;
import com.backend.clinicaOdontologica.entity.Odontologo;
import com.backend.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.backend.clinicaOdontologica.service.impl.OdontologoService;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OdontologoServiceTest {
    OdontologoService odontologoService;

    @Autowired
    public OdontologoServiceTest(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @Test
    @Order(1)
    void deberiaAgregarUnOdontologo() {

        OdontologoDto odontologoDto1 = odontologoService.registrarOdontologo(new Odontologo("1235", "Jorge", "fernandez"));
        OdontologoDto odontologoDto2 = odontologoService.registrarOdontologo(new Odontologo("12345", "Peter", "Hernandez"));
        OdontologoDto odontologoDto3 = odontologoService.registrarOdontologo(new Odontologo("12345", "Juan", "Perez"));

        Assert.assertNotNull(odontologoDto1);
        Assert.assertNotNull(odontologoDto2);
        Assert.assertNotNull(odontologoDto3);
        Assert.assertEquals("1235", odontologoDto1.getNumeroMatricula());


    }

    @Test
    @Order(2)
    void deberiaListarOdontologos() {

        List<OdontologoDto> odontologoDtoList = odontologoService.listarOdontologos();

        Assert.assertFalse(odontologoDtoList.isEmpty());
        Assert.assertTrue(odontologoDtoList.size() > 2);


    }

    @Test
    @Order(3)
    void deberiaEliminarOdontologo() throws ResourceNotFoundException {


        odontologoService.eliminarOdontologo(1L);
        Assert.assertNull(odontologoService.buscarOdontologoPorId(1L));

    }

}
