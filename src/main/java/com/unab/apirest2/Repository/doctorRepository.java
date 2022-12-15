package com.unab.apirest2.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.apirest2.Models.doctorModel;


public interface doctorRepository extends MongoRepository<doctorModel, String>{



    
}
