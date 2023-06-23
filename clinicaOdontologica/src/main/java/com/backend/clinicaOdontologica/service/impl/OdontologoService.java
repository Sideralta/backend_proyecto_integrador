package com.backend.clinicaOdontologica.service.impl;



import com.backend.clinicaOdontologica.dto.OdontologoDto;
import com.backend.clinicaOdontologica.entity.Odontologo;
import com.backend.clinicaOdontologica.repository.OdontologoRepository;
import com.backend.clinicaOdontologica.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class OdontologoService implements IOdontologoService {
    private final Logger LOGGER = LoggerFactory.getLogger(OdontologoService.class);
    private final ObjectMapper objectMapper;
    private final OdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(ObjectMapper objectMapper, OdontologoRepository odontologoRepository) {
        this.objectMapper = objectMapper;
        this.odontologoRepository = odontologoRepository;
    }




    public OdontologoDto buscarOdontologoPorId(Long id) {
        Odontologo odontologoBuscado = odontologoRepository.findById(id).orElse(null);
        OdontologoDto odontologoDto = null;
        if (odontologoBuscado != null){
            odontologoDto = objectMapper.convertValue(odontologoBuscado, OdontologoDto.class);
            LOGGER.info("Odontologo encontrado: {}", JsonPrinter.toString(odontologoDto));
        } else {
            LOGGER.info("El id no se encuentra registrado en la base de datos");
        }
        return odontologoDto;
    }

    @Override
    public Odontologo buscarOdontologo(Long id) {
        return null;
    }



    public List<OdontologoDto> listarOdontologos() {
        List<OdontologoDto> odontologos = odontologoRepository.findAll().stream()
                .map(o -> objectMapper.convertValue(o, OdontologoDto.class)).toList();
        LOGGER.info("Listado de todos los odontologos: {}", JsonPrinter.toString(odontologos));
        return odontologos;
    }

    @Override
    public OdontologoDto registrarOdontologo(Odontologo odontologo) {
        return objectMapper.convertValue(odontologoIDao.guardar(odontologo), OdontologoDto.class);
    }

    @Override
    public OdontologoDto actualizarOdontologo(Odontologo odontologo) {
        return objectMapper.convertValue(odontologoIDao.actualizar(odontologo), OdontologoDto.class);
    }

    @Override
    public void eliminarOdontologo(Long id) {

    }

    public void eliminarOdontologo(int id) {
        odontologoIDao.eliminar(id);
    }


}
