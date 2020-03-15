package com.thoughtworks.parkinglot.domain.model.parkingconfig;

public interface ParkingBoyConfigRepository {

    ParkingBoyConfig findByName(String name);

    ParkingBoyConfig findById(String id);
}
