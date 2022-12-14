package com.unab.apirest2.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("medicos")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class doctorModel {

    @Id
    private String id;
    private Integer ndocumento;
    private String nombre;
    private String apellido;
    private String especialidad;

}
