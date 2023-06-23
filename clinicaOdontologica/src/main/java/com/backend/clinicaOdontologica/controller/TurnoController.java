package com.backend.clinicaOdontologica.controller;

import com.backend.clinicaOdontologica.dto.TurnoDto;
import com.backend.clinicaOdontologica.entity.Turno;
import com.backend.clinicaOdontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private final ITurnoService turnoService;

    @Autowired
    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTurnoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(turnoService.buscarTurnoPorId(id), null, HttpStatus.OK);

       /* ResponseEntity<TurnoDto> respuesta;
        TurnoDto turnoDto = turnoService.buscarTurnoPorId(id);
        if (turnoDto != null) respuesta = new ResponseEntity<>(turnoDto, null, HttpStatus.OK);
        else respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return respuesta;*/
    }

    @GetMapping()
    public List<TurnoDto> listarTurnos() {
        return turnoService.listarTodos();
    }

    //POST
    @PostMapping("/registrar")
    public ResponseEntity<TurnoDto> guardarTurno(@RequestBody Turno turno) {

        return new ResponseEntity<>(turnoService.guardarTurno(turno), null, HttpStatus.CREATED);

        /*ResponseEntity<TurnoDto> respuesta;
        TurnoDto turnoDto = turnoService.guardarTurno(turno);
        if (turnoDto != null) respuesta = new ResponseEntity<>(turnoDto, null, HttpStatus.CREATED);
        else respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return respuesta;*/
    }

    //DELETE
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id) {
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok("Turno eliminado");
    }

    //PUT
    @PutMapping("/actualizar")
    public ResponseEntity<TurnoDto> actualizarTurno(@RequestBody Turno turno) {
        return new ResponseEntity<>(turnoService.actualizarTurno(turno), null, HttpStatus.OK);

       /* ResponseEntity<TurnoDto> respuesta;
        TurnoDto turnoDto = turnoService.actualizarTurno(turno);
        if (turnoDto != null) respuesta = new ResponseEntity<>(turnoDto, null, HttpStatus.OK);
        else respuesta = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return respuesta;*/
    }


}

