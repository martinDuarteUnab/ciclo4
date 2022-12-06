package com.unab.apirest2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.apirest2.Models.medicModel;
import com.unab.apirest2.service.medicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/medicos")
public class medicController {
    @Autowired
    medicService medicoServicio;
    
    @GetMapping()
    public List<medicModel> listaMedicos() {
        return medicoServicio.getAllMedicos();

    }
    @PostMapping()
    public medicModel postMedicos(@RequestBody medicModel medico) {
        //TODO: process POST request
        
        return medicoServicio.saveMedico(medico);
    }
    
}
