package com.unab.apirest2.Models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("agenda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class citationModel {
    
   
    @Id
    private String id;
    private String id_medico;
    private LocalDate fecha ;
    private List<Object> citas;
}
