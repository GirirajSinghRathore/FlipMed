package org.giriraj.model;

import lombok.ToString;

import java.util.List;

public class Patient extends User{
    private final UserType userType = UserType.PATIENT;

    @Override
    public String toString() {
        return super.toString() + "UserType " + userType;
    }
}
