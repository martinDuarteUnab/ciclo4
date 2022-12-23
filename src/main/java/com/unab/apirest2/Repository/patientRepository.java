package com.unab.apirest2.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import com.unab.apirest2.Models.patientModel;


public interface patientRepository extends MongoRepository<patientModel, String>{
    
    List<patientModel>findByApellido(String apellido);

    @Query("{'direccion.ciudad':?0}")
    List<patientModel> buscarPorCiudad(String ciudad);
    
    @Query("{fechanac:{$lt:?0}}")
    List<patientModel>pcientesMenoresPorFecha(LocalDate fecha);

    List<patientModel> findByFechanac(LocalDate fechanac);

    Boolean existsByIdentificacion(Integer id);

    Optional<patientModel> findByIdentificacion(Integer identificacion);
}
   