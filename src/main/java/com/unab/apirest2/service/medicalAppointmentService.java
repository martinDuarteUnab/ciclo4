package com.unab.apirest2.service;

import java.util.List;
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

    public medicalAppointmentModel guardarCita(medicalAppointmentModel cita) {

        return citasRepositorio.save(cita);
    }

    public List<medicalAppointmentModel> todasLasCitas() {
        return citasRepositorio.findAll();
    }

    public Optional<medicalAppointmentModel> citaPorId(String id) {

        Optional<medicalAppointmentModel> cita = citasRepositorio.findById(id);
        Optional<doctorModel> medico = medicoRepositorio.findById(cita.get().getId_medico());
        cita.get().setNombremedico(medico.get().getNombre());
        cita.get().setEspecialidad(medico.get().getEspecialidad());

        return cita;
    }

    public medicalAppointmentModel saveAgenda(medicalAppointmentModel agenda) {
        return citasRepositorio.save(agenda);
    }

   /*  public medicalAppointmentModel actualizarCita(medicalAppointmentModel citaActualizada) {
        // Busca la cita existente a partir de su ID
        medicalAppointmentModel citaExistente = citasRepositorio.findById(citaActualizada.getId()).orElse(null);

        // Si no se encontró la cita, devuelve null
        if (citaExistente == null) {
            return null;
        }

        // Modifica los campos necesarios en la cita existente
        citaExistente.setId_medico(citaActualizada.getId_medico());
        citaExistente.setFecha(citaActualizada.getFecha());
        citaExistente.setCitas(citaActualizada.getCitas());

        // Guarda la cita modificada en la base de datos y devuelve el objeto modificado
        return citasRepositorio.save(citaExistente);
    } */

    public String eliminarAgendaPorId(String id) {
        if (citasRepositorio.existsById(id)) {
            citasRepositorio.deleteById(id);
            return "Se elimino citas";
        } else {
            return "Fallo al eliminar";
        }
    }

}
