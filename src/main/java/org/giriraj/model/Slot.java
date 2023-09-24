package org.giriraj.model;

import lombok.*;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Slot {
    private Doctor doctor;
    private LocalTime time;
    private SlotStatus slotStatus;
    private Queue<Booking> queue = new LinkedList<>();
//    private Patient patient;
    public Slot(Doctor doctor, LocalTime time, SlotStatus slotStatus){
        this.doctor = doctor;
        this.time = time;
        this.slotStatus = slotStatus;
    }

    @Override
    public String toString() {
        return doctor.getName() + " " + time + " " + slotStatus;
    }
}
