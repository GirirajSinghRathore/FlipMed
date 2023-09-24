package org.giriraj.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
@Getter
@Setter

public class Doctor extends User{
    private Speciality speciality;
    private List<Slot> availableSlots;

    private final UserType userType = UserType.DOCTOR ;

    public Doctor(List<Slot> availableSlots){
        this.availableSlots = availableSlots;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
