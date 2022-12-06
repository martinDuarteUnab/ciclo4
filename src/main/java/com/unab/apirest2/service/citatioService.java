package com.unab.apirest2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.apirest2.Models.citationModel;
import com.unab.apirest2.Repository.citationRepository;

@Service
public class citatioService {

    @Autowired
    citationRepository citasRepositorio;

    public citationModel guardarCita(citationModel cita){

        return citasRepositorio.save(cita);
    }


    
}
