package org.giriraj.service.userservice;

import org.giriraj.model.Doctor;
import org.giriraj.model.Patient;
import org.giriraj.model.Speciality;
import org.giriraj.model.User;

public interface UserService {
    Doctor createDoctpr(String name, String email, String password, Speciality speciality);
    Patient createPatient(String name, String email, String password);
}
