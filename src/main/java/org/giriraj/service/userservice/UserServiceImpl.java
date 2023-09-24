package org.giriraj.service.userservice;

import org.giriraj.model.*;
import org.giriraj.service.userservice.UserService;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {

    private final FlipMed flipMed;

    public UserServiceImpl(FlipMed flipMed) {
        this.flipMed = flipMed;
    }
    @Override
    public Doctor createDoctpr(String name, String email, String password, Speciality speciality){
        Doctor doctor = new Doctor(new ArrayList<>());
        doctor.setName(name);
        doctor.setEmail(email);
        doctor.setPassword(password);
        doctor.setSpeciality(speciality);
        flipMed.getDoctors().add(doctor);
        return doctor;
    }

    @Override
    public Patient createPatient(String name, String email, String password) {
        Patient patient = new Patient();
        patient.setName(name);
        patient.setEmail(email);
        patient.setPassword(password);
        flipMed.getPatients().add(patient);
        return patient;
    }
}
