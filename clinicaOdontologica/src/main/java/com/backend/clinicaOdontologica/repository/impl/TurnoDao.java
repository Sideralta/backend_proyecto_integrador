package com.backend.clinicaOdontologica.repository.impl;

import com.backend.clinicaOdontologica.repository.IDao;
import com.backend.clinicaOdontologica.entity.Odontologo;
import com.backend.clinicaOdontologica.entity.Paciente;
import com.backend.clinicaOdontologica.entity.Turno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TurnoDao implements IDao<Turno> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TurnoDao.class);
    private PacienteDaoH2 pacienteDaoH2;
    private OdontologoDaoH2 odontologoDaoH2;

    private List<Turno> turnosRepository = new ArrayList<>();

    @Autowired
    public TurnoDao(PacienteDaoH2 pacienteDaoH2, OdontologoDaoH2 odontologoDaoH2) {
        this.pacienteDaoH2 = pacienteDaoH2;
        this.odontologoDaoH2 = odontologoDaoH2;
    }

    @Override
    public Turno guardar(Turno turno) {
        Turno guardado = null;
        Paciente paciente = pacienteDaoH2.buscarPorId(turno.getPaciente().getId());
        Odontologo odontologo = odontologoDaoH2.buscarPorId(turno.getOdontologo().getId());
        if(paciente != null && odontologo != null){
            guardado = turno;
            turnosRepository.add(guardado);
            LOGGER.info("Turno guardado correctamente: {}", guardado);
        } else LOGGER.error("No puede registrarse el turno");


        return guardado;
    }

    @Override
    public List<Turno> listarTodos() {
        LOGGER.info("Listado de todos los turnos: {}", turnosRepository);
        return turnosRepository;
    }

    @Override
    public Turno buscarPorId(Long id) {

        return null;
    }

    @Override
    public Turno buscarPorCriterio(String dni) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Turno actualizar(Turno turno) {
        return null;
    }


}
