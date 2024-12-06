package com.example.ClinicaVeterinaria_Asuncion.services;


import com.example.ClinicaVeterinaria_Asuncion.dtos.TutorRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Tutor;
import com.example.ClinicaVeterinaria_Asuncion.repositories.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }

    public Tutor createTutorService(TutorRequestDTO tutorRequestDto) {
        Tutor tutor = new Tutor();
        tutor.setName(tutorRequestDto.name());
        tutor.setEmail(tutorRequestDto.email());
        tutor.setPhone(tutorRequestDto.phone());
        tutor.setAddress(tutorRequestDto.address());
        return tutorRepository.save(tutor);
    }


}
