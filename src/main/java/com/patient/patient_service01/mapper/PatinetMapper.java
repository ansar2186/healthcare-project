package com.patient.patient_service01.mapper;

import com.patient.patient_service01.dto.PatientRequestDto;
import com.patient.patient_service01.dto.PatinetResponseDto;
import com.patient.patient_service01.model.Patinet;

import java.time.LocalDate;

public class PatinetMapper {


    public static Patinet patinetDtoConvertToPatinet(PatientRequestDto patientRequestDto) {

        Patinet patinet = new Patinet();

        patinet.setName(patientRequestDto.getName());
        patinet.setEmail(patientRequestDto.getEmail());
        patinet.setAddress(patientRequestDto.getAddress());
        patinet.setDateOfBirth(patientRequestDto.getDateOfBirth());
        patinet.setRegistrationDate(patientRequestDto.getRegistrationDate());
        patinet.setRegistrationDate(LocalDate.now());

        return patinet;
    }

    public static PatinetResponseDto patinetResponseDtoToPatinetResponseDto(Patinet patient) {

        PatinetResponseDto patinetResponseDto = new PatinetResponseDto();

        patinetResponseDto.setName(patient.getName());
        patinetResponseDto.setEmail(patient.getEmail());
        patinetResponseDto.setAddress(patient.getAddress());
        patinetResponseDto.setDateOfBirth(patient.getDateOfBirth());
        //patinetResponseDto.setRegistrationDate(patient.getRegistrationDate());

        return patinetResponseDto;


    }
}
