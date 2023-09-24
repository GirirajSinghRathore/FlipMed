package org.giriraj;

import org.giriraj.exception.SlotNotAvailableException;
import org.giriraj.model.*;
import org.giriraj.service.bookingservice.BookingService;
import org.giriraj.service.bookingservice.BookingServiceImpl;
import org.giriraj.service.doctorservice.DoctorService;
import org.giriraj.service.doctorservice.DoctorServiceImpl;
import org.giriraj.service.userservice.UserServiceImpl;
import org.giriraj.service.userservice.UserService;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Doctor> doctors = new ArrayList<>();
        List<Patient> patients = new ArrayList<>();
        List<Booking> bookings = new ArrayList<>();
        FlipMed flipMed = new FlipMed(doctors, patients, bookings);
        UserService userService = new UserServiceImpl(flipMed);
        Doctor d1 =  userService.createDoctpr("Doctor1", "giriraj@gmail.com", "password", Speciality.CARDIOLOGIST);

        Doctor d2 =  userService.createDoctpr("Doctor2", "giriraj@gmail.com", "password", Speciality.CARDIOLOGIST);


        DoctorService doctorService = new DoctorServiceImpl(flipMed);
        doctorService.addSlot(LocalTime.of(9, 30), d1);
        doctorService.addSlot(LocalTime.of(10, 0), d1);
        doctorService.addSlot(LocalTime.of(10, 30), d1);

        doctorService.addSlot(LocalTime.of(9, 30), d2);
        doctorService.addSlot(LocalTime.of(10, 0), d2);
        doctorService.addSlot(LocalTime.of(10, 30), d2);


        Patient p1 = userService.createPatient("P1","p1@g.com","pass");
        Patient p2 = userService.createPatient("P2","p2@g.com","pass");


        BookingService bookingService = new BookingServiceImpl(flipMed);
        List<Slot> availableSlots = bookingService.getAvailableSlots(Speciality.CARDIOLOGIST);
        availableSlots.forEach(System.out::println);

        Booking b1 = bookingService.bookSlot(p1, availableSlots.get(0));
        System.out.println(b1);
        Booking b2 = bookingService.bookSlot(p1, availableSlots.get(2));
        System.out.println(b2);
        Booking b3 = bookingService.bookSlot(p1, availableSlots.get(0));
        System.out.println(b3);
        bookingService.cancelBooking(b1);
        System.out.println(b3);
        System.out.println("Bookings for doctor: " + d1.getName());
        doctorService.getBookings(d1).forEach(System.out::println);













    }
}