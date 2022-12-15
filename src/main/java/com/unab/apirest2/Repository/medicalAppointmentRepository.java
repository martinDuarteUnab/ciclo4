package com.unab.apirest2.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.unab.apirest2.Models.medicalAppointmentModel;



public interface medicalAppointmentRepository extends MongoRepository<medicalAppointmentModel, String>{
        
}
