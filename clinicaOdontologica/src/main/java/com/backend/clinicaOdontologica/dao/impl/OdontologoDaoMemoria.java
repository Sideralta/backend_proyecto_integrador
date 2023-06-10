package com.backend.clinicaOdontologica.dao.impl;


import com.backend.clinicaOdontologica.dao.IDao;
import com.backend.clinicaOdontologica.entity.Odontologo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoMemoria implements IDao<Odontologo> {

    private static final Logger LOGGER = LoggerFactory.getLogger(OdontologoDaoMemoria.class);

    private List<Odontologo> odontologoRepository = new ArrayList<>();


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologoRepository.add(odontologo);
        LOGGER.info("Odontologo guardado: " + odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        LOGGER.info("listado de todos los odontologos: \n" + odontologoRepository);
        return odontologoRepository;
    }

    @Override
    public Odontologo buscarPorId(int id) {
        return null;
    }

    @Override
    public Odontologo buscarPorCriterio(String dni) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        return null;
    }
}
