package com.example.ClinicaVeterinaria_Asuncion.controllers;


import com.example.ClinicaVeterinaria_Asuncion.dtos.PatientRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Patient;
import com.example.ClinicaVeterinaria_Asuncion.services.PatientServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clinic")
public class PatientController {

    private final PatientServices patientServices;

    public PatientController(PatientServices patientServices) {
        this.patientServices = patientServices;
    }

    @GetMapping("/patient")
    public List<Patient> getAllPatients() {
        return patientServices.getAllService();
    }


    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> optionalPatient = patientServices.findById(id);
        if (optionalPatient.isPresent()) {
            return new ResponseEntity<Patient>(optionalPatient.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/patient")
    public ResponseEntity<Patient> addPatient(@RequestBody PatientRequestDTO patientRequestDTO) {
        Patient patient = patientServices.addPatientService(patientRequestDTO);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/patient/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody PatientRequestDTO patientRequestDTO) {
        try {
            Patient updatedPatient = patientServices.updatePatientService(id, patientRequestDTO);
            return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
