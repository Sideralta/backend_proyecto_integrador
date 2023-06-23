package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.dto.OdontologoDto;
import com.backend.clinicaOdontologica.entity.Odontologo;

import java.util.List;

public interface IOdontologoService {
    OdontologoDto buscarOdontologo(Long id);
    OdontologoDto buscarOdontologoPorId(Long id);
    List<OdontologoDto> listarOdontologos();

    OdontologoDto registrarOdontologo(Odontologo odontologo);
    OdontologoDto actualizarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(Long id);
}
