package com.unab.apirest2.Controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unab.apirest2.Models.patientModel;
import com.unab.apirest2.Repository.patientRepository;
import com.unab.apirest2.service.patientService;

@RestController
@RequestMapping("/paciente")
public class patientController {

    @Autowired
    patientRepository pacienteRepositorio;
    @Autowired
    patientService pacienteServicio;

    @GetMapping()
    public List<patientModel> getAllPacietesOrden() {
        return pacienteServicio.getListPacientesOrden();
    }

    @GetMapping("/{id}")
    public Optional<patientModel> findPacienteById(@PathVariable("id") String id) {
        return pacienteServicio.getPacienteBy(id);
    }

    @GetMapping("/query")
    public List<patientModel> getPacientesPorApellido(@RequestParam("apellido") String apellido) {
        return pacienteServicio.getPacientesByApellido(apellido);
    }

    @GetMapping("/ciudad/{ciudad}")
    public List<patientModel> listPacientesCiudad(@PathVariable("ciudad") String ciudad) {
        return pacienteServicio.pacientesByCiudad(ciudad);
    }

    @GetMapping("/fecha/query")
    public List<patientModel> getPacienteByFechaMenor(@RequestParam("fecha") String fecha){
        LocalDate localDate = LocalDate.parse(fecha);
        return pacienteServicio.pacienteMenorFecha(localDate);
    }


    @PostMapping()
    public String savePaciente(@RequestBody patientModel paciente) {
        return pacienteServicio.guardarPaciente(paciente);
    }

    @DeleteMapping("/{id}")
    public String deletePacienteById(@PathVariable("id") String id) {

        return pacienteServicio.eliminarPacienteConId(id);

    }

}
