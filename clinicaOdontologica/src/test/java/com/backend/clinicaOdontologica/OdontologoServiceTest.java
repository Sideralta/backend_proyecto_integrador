package com.backend.clinicaOdontologica;

import com.backend.clinicaOdontologica.dto.OdontologoDto;
import com.backend.clinicaOdontologica.entity.Odontologo;
import com.backend.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.backend.clinicaOdontologica.service.impl.OdontologoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OdontologoServiceTest {
    OdontologoService odontologoService;
    @Autowired
    public OdontologoServiceTest(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @Test
    void deberiaAgregarUnOdontologo() {

        OdontologoDto odontologo1 = odontologoService.registrarOdontologo(new Odontologo("1235","Jorge","fernandez"));

        Assert.assertNotNull(odontologo1);
        Assert.assertEquals("1235", odontologo1.getNumeroMatricula());


    }

    @Test
    void deberiaListarOdontologos(){
        OdontologoDto odontologoDto1 = odontologoService.registrarOdontologo(new Odontologo("12345", "Santiago","Hernandez"));
        OdontologoDto odontologoDto2 = odontologoService.registrarOdontologo(new Odontologo("12345", "Peter","Hernandez"));
        OdontologoDto odontologoDto3 = odontologoService.registrarOdontologo(new Odontologo("12345", "Juan","Perez"));

        List<OdontologoDto> odontologoDtoList = odontologoService.listarOdontologos();

        Assert.assertFalse(odontologoDtoList.isEmpty());
        Assert.assertTrue(odontologoDtoList.size() > 2);



    }

    @Test
    void deberiaEliminarOdontologo() throws ResourceNotFoundException {
        OdontologoDto odontologoDto1 = odontologoService.registrarOdontologo(new Odontologo("12345", "Santiago","Hernandez"));
        OdontologoDto odontologoDto2 = odontologoService.registrarOdontologo(new Odontologo("12345", "Peter","Hernandez"));
        OdontologoDto odontologoDto3 = odontologoService.registrarOdontologo(new Odontologo("12345", "Juan","Perez"));


         odontologoService.eliminarOdontologo(odontologoDto1.getId());
         Assert.assertNull(odontologoService.buscarOdontologoPorId(odontologoDto1.getId()));

    }

}
