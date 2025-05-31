package com.patient.patient_service01.service;

import com.patient.patient_service01.dto.PatientRequestDto;
import com.patient.patient_service01.dto.PatinetResponseDto;
import com.patient.patient_service01.exception.EmailAlreadyExistsException;
import com.patient.patient_service01.mapper.PatinetMapper;
import com.patient.patient_service01.model.Patinet;
import com.patient.patient_service01.repository.PatinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class PatientService {

    @Autowired
    private PatinetRepository patinetRepository;

    public PatinetResponseDto addPatient(PatientRequestDto patientRequestDto) throws EmailAlreadyExistsException {
        Patinet patinet = PatinetMapper.patinetDtoConvertToPatinet(patientRequestDto);

        if (patinetRepository.existsByEmail(patinet.getEmail())) {
            throw new EmailAlreadyExistsException("Email Already Exits is DB , Please try with Different email");
        }

        Patinet patinetSaved = patinetRepository.save(patinet);
        PatinetResponseDto patinetResponseDto = PatinetMapper.patinetResponseDtoToPatinetResponseDto(patinetSaved);
        return patinetResponseDto;

    }

    public PatinetResponseDto updatePatient(Long id, PatientRequestDto patientRequestDto) {
        Patinet patient = patinetRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Patient not found with ID : " + id));

        patient.setName(patientRequestDto.getName());
        patient.setEmail(patientRequestDto.getEmail());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setDateOfBirth(patientRequestDto.getDateOfBirth());

        Patinet savedPatinet = patinetRepository.save(patient);

        return PatinetMapper.patinetResponseDtoToPatinetResponseDto(savedPatinet);


    }
}
