package com.thoughtworks.parkinglot.configcontext.domain;

public interface ParkingBoyRepository {

    ParkingBoy findByName(String name);

    ParkingBoy findById(String id);
}
