package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.entity.Odontologo;

import java.util.List;

public interface IOdontologoService {
    Odontologo buscarOdontologo(int id);
    List<Odontologo> listarOdontologos();

    Odontologo registrarOdontologo(Odontologo odontologo);
    Odontologo actualizarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(int id);
}
