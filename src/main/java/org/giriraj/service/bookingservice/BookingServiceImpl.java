package org.giriraj.service.bookingservice;

import org.giriraj.exception.SlotNotAvailableException;
import org.giriraj.model.*;
import org.giriraj.strategy.DefaltRankingStrategy;

import java.time.LocalTime;
import java.util.List;

public class BookingServiceImpl implements BookingService{
    private final FlipMed flipMed;
    public BookingServiceImpl(FlipMed flipMed) {
        this.flipMed = flipMed;
    }

    @Override
    public List<Slot> getAvailableSlots(Speciality speciality) {
        return new DefaltRankingStrategy().getAvailableSlots(speciality, flipMed);
    }

    @Override
    public Booking bookSlot(Patient patient, Slot slot) throws SlotNotAvailableException {
        Booking booking = new Booking();
        booking.setPatient(patient);
        booking.setDoctor(slot.getDoctor());
        booking.setSlot(slot);
        if(slot.getSlotStatus().equals(SlotStatus.BOOKED)){
            booking.setBookingStatus(BookingStatus.WAITING);
            slot.getQueue().add(booking);
            System.out.println("Slot is already booked added you Booking to Waiting List");
            return booking;
        }

        List<Booking> bookings = flipMed.getBookings().stream().filter(a->a.getPatient().equals(patient) && a.getBookingStatus().equals(BookingStatus.BOOKED)).toList();
        for(Booking b : bookings){
            LocalTime currMinusThirty = b.getSlot().getTime().minusMinutes(30);
            LocalTime currPlusThirty = b.getSlot().getTime().plusMinutes(30);
            if(slot.getTime().isAfter(currMinusThirty) && slot.getTime().isBefore(currPlusThirty)){
                throw new SlotNotAvailableException("You have another booking in this time slot");
            }
        }

        slot.setSlotStatus(SlotStatus.BOOKED);

        booking.setBookingStatus(BookingStatus.BOOKED);

        flipMed.getBookings().add(booking);
        return booking;
    }

    @Override
    public Booking cancelBooking(Booking booking) {
        booking.setBookingStatus(BookingStatus.CANCELLED);
        Slot slot = booking.getSlot();
        if(!slot.getQueue().isEmpty()) {
            Booking nextBooking = slot.getQueue().poll();
            nextBooking.setBookingStatus(BookingStatus.BOOKED);
            nextBooking.setSlot(slot);

            slot.setSlotStatus(SlotStatus.BOOKED);
            return nextBooking;
        }else{
            slot.setSlotStatus(SlotStatus.AVAILABLE);
            return null;
        }
    }

}
