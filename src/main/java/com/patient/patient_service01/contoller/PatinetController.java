package com.patient.patient_service01.contoller;

import com.patient.patient_service01.dto.PatientRequestDto;
import com.patient.patient_service01.dto.PatinetResponseDto;
import com.patient.patient_service01.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatinetController {
    @Autowired
    private PatientService patientService;


    @PostMapping
    public ResponseEntity<PatinetResponseDto> addPatient(@Valid @RequestBody PatientRequestDto patientRequestDto){

        PatinetResponseDto patinetResponseDto = patientService.addPatient(patientRequestDto);

        return new ResponseEntity<>(patinetResponseDto, HttpStatus.CREATED);

    }

}
