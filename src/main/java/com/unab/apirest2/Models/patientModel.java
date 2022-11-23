package com.unab.apirest2.Models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("pacientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class patientModel {
    
    @Id
    private String nombre;
    private String apellido;
    private List<String> alergias;  //ejemplo:["acetaminofen","ibuprofeno"]
    private Object direccion;       //ejemplo : direccion:{ciudad; "Buacramanga", departamento:"Santander}
        
    
}

