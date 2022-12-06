package com.unab.apirest2.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.unab.apirest2.Models.medicModel;

@Repository
public interface medicRepository extends MongoRepository<medicModel, String>{



    
}
