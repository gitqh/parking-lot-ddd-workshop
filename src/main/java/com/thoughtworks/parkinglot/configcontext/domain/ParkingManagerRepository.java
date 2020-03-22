package com.thoughtworks.parkinglot.configcontext.domain;

public interface ParkingManagerRepository {
    ParkingManager findByName(String parkingManagerName);
    ParkingManager findDefault();
}
