package com.backend.clinicaOdontologica.controller;


import com.backend.clinicaOdontologica.entity.Paciente;
import com.backend.clinicaOdontologica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
    private IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    /*@GetMapping("/index")
    public String buscarPacientePorDni(Model model, @RequestParam("dni") String dni){
        Paciente paciente = pacienteService.buscarPacientePorDni(dni);

        //agregar los atributos del objeto al modelo que mostraremos en la vista
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());

        return "index";
    }*/

    @PostMapping("registrar")
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }

    @PutMapping("/actualizar/")
    public Paciente actualizarPaciente (@RequestBody Paciente paciente){
        return pacienteService.actualizarPaciente(paciente);
    }

    @GetMapping
    public List<Paciente> listarTodos(){
        return pacienteService.listarPacientes();
    }

    @GetMapping("/{id}")
    public Paciente buscarPacientePorId(@PathVariable int id){
        return pacienteService.buscarPacientePorId(id);
    }

    //DELETE
    @DeleteMapping("/eliminar/{id}")
    public void eliminarPaciente(@PathVariable int id){
        pacienteService.eliminarPaciente(id);
    }

}
