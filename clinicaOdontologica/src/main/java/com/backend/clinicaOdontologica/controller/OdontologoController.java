package com.backend.clinicaOdontologica.controller;

import com.backend.clinicaOdontologica.entity.Odontologo;
import com.backend.clinicaOdontologica.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {this.odontologoService = odontologoService;}


    /*@GetMapping("/index")
    public String buscarOdontologo(Model model, @RequestParam("id") int id) {
        Odontologo odontologo = odontologoService.buscarOdontologo(id);

        //agregar los atributos del objeto al modelo que mostraremos en la vista
        model.addAttribute("matricula", odontologo.getNumeroMatricula());
        return "index";
    }*/

    @GetMapping()
    public List<Odontologo> listarOdontologos(){
        return odontologoService.listarOdontologos();
    }

    @GetMapping("/{id}")
    public Odontologo buscarOdontologoPorId(@PathVariable int id){
        return odontologoService.buscarOdontologo(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarOdontologo(@PathVariable int id){
        odontologoService.eliminarOdontologo(id);
    }

    @PostMapping("/registrar")
    public Odontologo registrarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.registrarOdontologo(odontologo);
    }

    @PutMapping("/actualizar")
    public Odontologo actualizarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.actualizarOdontologo(odontologo);

    }
}
