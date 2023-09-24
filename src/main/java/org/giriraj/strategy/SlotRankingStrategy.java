package org.giriraj.strategy;

import org.giriraj.model.AvailableSlot;
import org.giriraj.model.FlipMed;
import org.giriraj.model.Slot;
import org.giriraj.model.Speciality;

import java.util.List;

public interface SlotRankingStrategy {
    List<Slot> getAvailableSlots(Speciality speciality, FlipMed flipMed);
}
