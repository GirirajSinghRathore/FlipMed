package org.giriraj.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FlipMed {
    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Booking> bookings;

    public FlipMed(List<Doctor> doctors, List<Patient> patients, List<Booking> bookings) {
        this.doctors = doctors;
        this.patients = patients;
        this.bookings = bookings;
    }
}
