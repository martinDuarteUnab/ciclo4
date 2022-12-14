package com.unab.apirest2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.apirest2.Models.medicalAppointmentModel;
import com.unab.apirest2.Models.doctorModel;
import com.unab.apirest2.Repository.medicalAppointmentRepository;
import com.unab.apirest2.Repository.doctorRepository;

@Service
public class medicalAppointmentService {

    @Autowired
    medicalAppointmentRepository citasRepositorio;
    @Autowired
    doctorRepository medicoRepositorio;
    public medicalAppointmentModel guardarCita(medicalAppointmentModel cita){

        return citasRepositorio.save(cita);
    }

    public Optional<medicalAppointmentModel> citaPorId(String id){
        
        Optional<medicalAppointmentModel> cita = citasRepositorio.findById(id);
        Optional <doctorModel> medico = medicoRepositorio.findById(cita.get().getId_medico());
        cita.get().setNombremedico(medico.get().getNombre());
        cita.get().setEpecialidad(medico.get().getEspecialidad());
        
        return cita;
    }

    
}
