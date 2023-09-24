package org.giriraj.service.doctorservice;

import org.giriraj.exception.SlotNotAvailableException;
import org.giriraj.model.Booking;
import org.giriraj.model.Doctor;
import org.giriraj.model.Slot;

import java.time.LocalTime;
import java.util.List;

public interface DoctorService {
    Slot addSlot(LocalTime time, Doctor doctor) throws SlotNotAvailableException;
    List<Booking> getBookings(Doctor doctor);
}
