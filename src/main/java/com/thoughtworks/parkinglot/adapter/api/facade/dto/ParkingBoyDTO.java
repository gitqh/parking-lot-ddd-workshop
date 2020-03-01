package com.thoughtworks.parkinglot.adapter.api.facade.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * @author gitqh
 */
@Data
@Builder
public class ParkingBoyDTO implements Serializable {
    private String parkingBoyId;
    private List<ParkingLotDTO> parkingLots;
    private String name;
}
