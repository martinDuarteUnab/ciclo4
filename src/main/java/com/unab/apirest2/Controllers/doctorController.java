package com.unab.apirest2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unab.apirest2.Models.doctorModel;
import com.unab.apirest2.service.doctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/medicos")
public class doctorController {
    @Autowired
    doctorService medicoServicio;
    
    @GetMapping()
    public List<doctorModel> listaMedicos() {
        return medicoServicio.getAllMedicos();

    }
    @PostMapping()
    public doctorModel postMedicos(@RequestBody doctorModel medico) {
  
        
        return medicoServicio.saveMedico(medico);
    }

    @GetMapping("/query")
    public List<doctorModel> getDoctorPorEspecialidad(@RequestParam("especialidad") String especialidad) {
        return medicoServicio.getMedicosByEspecialidad(especialidad);
    } 
    
}
