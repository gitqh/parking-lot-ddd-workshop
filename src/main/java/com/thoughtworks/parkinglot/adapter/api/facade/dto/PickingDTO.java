package com.thoughtworks.parkinglot.adapter.api.facade.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * @author gitqh
 */
@Data
public class PickingDTO implements Serializable {
    private String ticketId;
    private String parkingLotId;
}
