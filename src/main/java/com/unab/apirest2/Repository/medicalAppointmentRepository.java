package com.unab.apirest2.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.unab.apirest2.Models.medicalAppointmentModel;


@Repository
public interface medicalAppointmentRepository extends MongoRepository<medicalAppointmentModel, String>{
        
}
