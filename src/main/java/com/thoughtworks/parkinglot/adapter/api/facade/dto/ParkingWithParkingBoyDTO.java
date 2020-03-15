package com.thoughtworks.parkinglot.adapter.api.facade.dto;

import java.io.Serializable;
import lombok.Value;

/**
 * @author gitqh
 */
@Value
public class ParkingWithParkingBoyDTO implements Serializable {
    private final String licensePlate;
    private final String parkingBoyName;
}
