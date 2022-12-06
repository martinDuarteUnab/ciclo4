package com.unab.apirest2.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.unab.apirest2.Models.citationModel;


@Repository
public interface citationRepository extends MongoRepository<citationModel, String>{
        
}
