package com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.dto;

import java.io.Serializable;
import lombok.Value;

/**
 * @author gitqh
 */
@Value
public class PickingDTO implements Serializable {
    private final String licensePlate;
    private final String parkingLotId;
}
