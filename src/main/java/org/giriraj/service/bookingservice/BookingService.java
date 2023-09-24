package org.giriraj.service.bookingservice;

import org.giriraj.exception.SlotNotAvailableException;
import org.giriraj.model.Booking;
import org.giriraj.model.Patient;
import org.giriraj.model.Slot;
import org.giriraj.model.Speciality;

import java.awt.*;
import java.util.List;

public interface BookingService {
    List<Slot> getAvailableSlots(Speciality speciality);
    Booking bookSlot(Patient patient, Slot slot) throws SlotNotAvailableException;

    Booking cancelBooking(Booking booking);
}
