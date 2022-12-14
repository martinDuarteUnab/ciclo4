package com.unab.apirest2.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.apirest2.Models.patientModel;
import com.unab.apirest2.Repository.patientRepository;

@Service
public class patientService {
    
    @Autowired
    patientRepository pacienteRepositorio;

    public String guardarPaciente(patientModel paciente){

        paciente.setNombre(paciente.getNombre().toLowerCase());
        paciente.setApellido(paciente.getApellido().toLowerCase());
        boolean estado = paciente.getId() == null || !pacienteRepositorio.existsById(paciente.getId());
        pacienteRepositorio.save(paciente);

        if(estado){      
            return "se guardo el paciente ";  
        } else{
            return "se actualizo el paciente";
        }

    }

    public List<patientModel> getListPacientesOrden(){

        List<patientModel> listaPacientes = pacienteRepositorio.findAll();
        listaPacientes.sort(Comparator.comparing(patientModel::getNombre));
        
        return listaPacientes;
    }

    public Optional<patientModel> getPacienteBy(String id){

        return pacienteRepositorio.findById(id);
    }

    public List<patientModel>getPacientesByApellido(String apellido){
        return pacienteRepositorio.findByApellido(apellido);
    }

    public String eliminarPacienteConId(String id){
        if(pacienteRepositorio.existsById(id)){
            
            Optional <patientModel> paciente = pacienteRepositorio.findById(id);
            pacienteRepositorio.deleteById(id);

            return "paciente " + paciente.get().getNombre() + " eliminado" ;

        } else{
            return "No Eliminado";
        }
    }
    public List<patientModel> pacientesByCiudad(String ciudad){
        return pacienteRepositorio.buscarPorCiudad(ciudad);
    }

    public List<patientModel>pacienteMenorFecha(LocalDate fecha){
        return pacienteRepositorio.pcientesMenoresPorFecha(fecha);
    }
}
