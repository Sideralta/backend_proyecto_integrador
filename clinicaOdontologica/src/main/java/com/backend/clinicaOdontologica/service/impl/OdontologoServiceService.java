package com.backend.clinicaOdontologica.service.impl;



import com.backend.clinicaOdontologica.dao.IDao;
import com.backend.clinicaOdontologica.entity.Odontologo;
import com.backend.clinicaOdontologica.service.IOdontologoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoServiceService implements IOdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoServiceService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoIDao.guardar(odontologo);
    }

    @Override
    public Odontologo buscarOdontologo(int id) {
        return odontologoIDao.buscarPorId(id);
    }

    public List<Odontologo> listarOdontologos() {
        return odontologoIDao.listarTodos();
    }

    @Override
    public Odontologo registrarOdontologo(Odontologo odontologo) {
        return odontologoIDao.guardar(odontologo);
    }

    @Override
    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        return odontologoIDao.actualizar(odontologo);
    }

    @Override
    public void eliminarOdontologo(int id) {
         odontologoIDao.eliminar(id);

    }


}
