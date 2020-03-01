package com.thoughtworks.parkinglot.adapter.api.facade.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gitqh
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLotDTO implements Serializable {
    private Integer capacity;
}
