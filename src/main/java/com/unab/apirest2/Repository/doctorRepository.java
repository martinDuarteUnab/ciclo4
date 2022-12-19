package com.unab.apirest2.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.apirest2.Models.doctorModel;


public interface doctorRepository extends MongoRepository<doctorModel, String>{

    List<doctorModel>findByEspecialidad(String especialidad);

    
}
