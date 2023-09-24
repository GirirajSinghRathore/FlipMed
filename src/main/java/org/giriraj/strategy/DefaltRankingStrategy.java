package org.giriraj.strategy;

import org.giriraj.model.*;

import java.util.List;

public class DefaltRankingStrategy implements SlotRankingStrategy{

    @Override
    public List<Slot> getAvailableSlots(Speciality speciality, FlipMed flipMed) {
        List<Slot> slots = (List<Slot>) flipMed.getDoctors().stream()
                .filter(doctor -> doctor.getSpeciality().equals(speciality))
                .flatMap(doctor -> doctor.getAvailableSlots().stream())
                .toList();
        return slots.stream().filter(a -> a.getSlotStatus().equals(SlotStatus.AVAILABLE)).sorted((a,b)->a.getTime().compareTo(b.getTime())).toList();
    }
}
