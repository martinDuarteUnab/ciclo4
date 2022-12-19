package com.unab.apirest2.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.apirest2.Models.doctorModel;
import com.unab.apirest2.Repository.doctorRepository;

@Service
public class doctorService {
    
    @Autowired
    doctorRepository medicoRepositorio;

    public List<doctorModel> getAllMedicos(){
        List<doctorModel>medicos = medicoRepositorio.findAll();
        medicos.sort((Comparator.comparing(doctorModel::getEspecialidad)));
        return medicos;
    }
    public doctorModel saveMedico(doctorModel medico){
        return medicoRepositorio.save(medico);
    }

    public List<doctorModel>getMedicosByEspecialidad(String especialidad){
        return medicoRepositorio.findByEspecialidad(especialidad);
    }
}
