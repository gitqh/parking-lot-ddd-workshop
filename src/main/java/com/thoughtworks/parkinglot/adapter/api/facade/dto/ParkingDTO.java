package com.thoughtworks.parkinglot.adapter.api.facade.dto;

import java.io.Serializable;
import lombok.Value;

/**
 * @author gitqh
 */
@Value
public class ParkingDTO implements Serializable {
    private String licensePlate;
}
