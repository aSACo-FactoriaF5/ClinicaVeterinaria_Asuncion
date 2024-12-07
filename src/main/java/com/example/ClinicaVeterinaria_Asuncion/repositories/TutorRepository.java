package com.example.ClinicaVeterinaria_Asuncion.repositories;

import com.example.ClinicaVeterinaria_Asuncion.entities.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    List<Tutor> findByName(String name);
}
