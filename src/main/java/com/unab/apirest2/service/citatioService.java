package com.unab.apirest2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.apirest2.Models.citationModel;
import com.unab.apirest2.Models.medicModel;
import com.unab.apirest2.Repository.citationRepository;
import com.unab.apirest2.Repository.medicRepository;

@Service
public class citatioService {

    @Autowired
    citationRepository citasRepositorio;
    @Autowired
    medicRepository medicoRepositorio;
    public citationModel guardarCita(citationModel cita){

        return citasRepositorio.save(cita);
    }

    public Optional<citationModel> citaPorId(String id){
        
        Optional<citationModel> cita = citasRepositorio.findById(id);
        Optional <medicModel> medico = medicoRepositorio.findById(cita.get().getId_medico());
        cita.get().setNombremedico(medico.get().getNombre());
        cita.get().setEpecialidad(medico.get().getEspecialidad());
        
        return cita;
    }

    
}
