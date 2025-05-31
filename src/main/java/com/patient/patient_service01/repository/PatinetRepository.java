package com.patient.patient_service01.repository;

import com.patient.patient_service01.model.Patinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@Repository
public interface PatinetRepository extends JpaRepository<Patinet, Long> {

    boolean existsByEmail(String email);


}
