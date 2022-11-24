package com.unab.apirest2.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.unab.apirest2.Models.patientModel;

@Repository
public interface patienRepository extends MongoRepository<patientModel, String>{
    
    List<patientModel>findByApellido(String apellido);
}
   