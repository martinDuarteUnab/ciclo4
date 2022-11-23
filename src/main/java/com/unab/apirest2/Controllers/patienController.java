package com.unab.apirest2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.apirest2.Models.patientModel;
import com.unab.apirest2.Repository.patienRepository;

@RestController
@RequestMapping("/paciente")
public class patienController {

    @Autowired
    patienRepository pacienteRepositorio;

    @GetMapping()
    public List<patientModel>getAllPacientes(){
        return pacienteRepositorio.findAll();
    }
    
    @PostMapping()
    public patientModel savePaciente(@RequestBody patientModel paciente){
        return pacienteRepositorio.save(paciente);
    }
}
