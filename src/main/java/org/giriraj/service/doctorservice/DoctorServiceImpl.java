package org.giriraj.service.doctorservice;

import lombok.extern.log4j.Log4j2;
import org.giriraj.exception.SlotNotAvailableException;
import org.giriraj.model.*;

import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DoctorServiceImpl implements DoctorService{
    Logger logger = Logger.getLogger(DoctorServiceImpl.class.getName());
    private final FlipMed flipMed;
    public DoctorServiceImpl(FlipMed flipMed){
        this.flipMed = flipMed;
    }
    @Override
    public Slot addSlot(LocalTime time, Doctor doctor) throws SlotNotAvailableException {
//        logger.log(Level.INFO, "Adding slot for doctor: " + doctor.getName() + " at time: " + time);
        List<Slot> availableSlots = doctor.getAvailableSlots();
        for(Slot slot : availableSlots){
            LocalTime currMinusThirty = time.minusMinutes(30);
            LocalTime currPlusThirty = time.plusMinutes(30);
            if(slot.getTime().isAfter(currMinusThirty) && slot.getTime().isBefore(currPlusThirty)){
                throw new SlotNotAvailableException("Slot already exists");
            }
        }
        Slot slot = new Slot(doctor, time, SlotStatus.AVAILABLE);
        availableSlots.add(slot);

        return slot;
    }

    @Override
    public List<Booking> getBookings(Doctor doctor) {
        return flipMed.getBookings().stream().filter(a->a.getDoctor().equals(doctor) && a.getBookingStatus().equals(BookingStatus.BOOKED)).toList();
    }


}
