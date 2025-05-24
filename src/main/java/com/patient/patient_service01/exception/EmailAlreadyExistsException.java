package com.patient.patient_service01.exception;

public class EmailAlreadyExistsException extends RuntimeException {

   public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
