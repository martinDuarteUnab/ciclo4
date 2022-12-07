package com.unab.apirest2.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.apirest2.Models.citationModel;
import com.unab.apirest2.service.citatioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("citas")
public class citationController {
    @Autowired
    citatioService citasServicio;

    @PostMapping()
    public citationModel saveCita(@RequestBody citationModel cita){

        return citasServicio.guardarCita(cita);
    }

    @GetMapping("/{id}")
    public Optional<citationModel> getById(@PathVariable("id") String id) {
        return citasServicio.citaPorId(id);
    }
    
}
