package com.thoughtworks.parkinglot.domain.model.parkingconfig;

public interface ParkingManagerConfigRepository {
    ParkingManagerConfig findByName(String parkingManagerName);
    ParkingManagerConfig findDefault();
}
