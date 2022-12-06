package com.unab.apirest2.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.apirest2.Models.medicModel;
import com.unab.apirest2.Repository.medicRepository;

@Service
public class medicService {
    
    @Autowired
    medicRepository medicoRepositorio;

    public List<medicModel> getAllMedicos(){
        List<medicModel>medicos = medicoRepositorio.findAll();
        medicos.sort((Comparator.comparing(medicModel::getEspecialidad)));
        return medicos;
    }
    public medicModel saveMedico(medicModel medico){
        return medicoRepositorio.save(medico);
    }
}
