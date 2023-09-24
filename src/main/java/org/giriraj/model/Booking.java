package org.giriraj.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;
@Getter
@Setter

public class Booking {

    private Doctor doctor;
    private Slot slot;

    private Patient patient;

    private BookingStatus bookingStatus;

    @Override
    public String toString() {
        return doctor.getName() + " " + slot + " " +patient+" "+ bookingStatus;
    }
}
