package com.thoughtworks.parkinglot.configcontext.domain;

public interface ParkingBoyRepository {
    ParkingBoyConfig findById(String id);
}
