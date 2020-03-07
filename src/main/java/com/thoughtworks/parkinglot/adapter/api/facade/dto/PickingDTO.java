package com.thoughtworks.parkinglot.adapter.api.facade.dto;

import java.io.Serializable;
import lombok.Value;

/**
 * @author gitqh
 */
@Value
public class PickingDTO implements Serializable {
    private String ticketId;
    private String parkingLotId;
}
