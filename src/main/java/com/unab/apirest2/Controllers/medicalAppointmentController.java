package com.unab.apirest2.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.apirest2.Models.medicalAppointmentModel;
import com.unab.apirest2.service.medicalAppointmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("citas")
public class medicalAppointmentController {
    @Autowired
    medicalAppointmentService citasServicio;
    // matodo para guardar una cita

    @GetMapping
    public List<medicalAppointmentModel> findAllMedicallApoinments() {
        return citasServicio.todasLasCitas();
    }

    @PostMapping()
    public medicalAppointmentModel saveCita(@RequestBody medicalAppointmentModel cita) {

        return citasServicio.guardarCita(cita);
        /*
         * ejemplo de como introducis el json
         *
         * {
         * 
         * "id_medico":"1",
         * "fecha":"2022-12-08",
         * "citas":[
         * {"hora":"8:00-8:30",
         * "id_paciente":"5"}
         * ]
         * }
         */
    }

    // metodo para traer los datos de una cita por id
    @GetMapping("/{id}")
    public Optional<medicalAppointmentModel> getById(@PathVariable("id") String id) {
        return citasServicio.citaPorId(id);
    }

    /* @PutMapping("/{id}")
    public medicalAppointmentModel actualizarCita(@PathVariable("id") String id, @RequestBody medicalAppointmentModel citaActualizada) {
        // Asigna el ID de la cita a actualizar al objeto de cita actualizado
        citaActualizada.setId(id);

        // Llama al método de actualización de citas del servicio y devuelve el resultado
        return citasServicio.actualizarCita(citaActualizada);

    } */
}
