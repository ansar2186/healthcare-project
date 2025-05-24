package com.patient.patient_service01.service;

import com.patient.patient_service01.dto.PatientRequestDto;
import com.patient.patient_service01.dto.PatinetResponseDto;
import com.patient.patient_service01.exception.EmailAlreadyExistsException;
import com.patient.patient_service01.mapper.PatinetMapper;
import com.patient.patient_service01.model.Patinet;
import com.patient.patient_service01.repository.PatinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}
