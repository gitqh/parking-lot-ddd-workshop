package com.thoughtworks.parkinglot.adapter.api.facade.response;

import java.io.Serializable;
import java.util.List;
import lombok.Value;

/**
 * @author gitqh
 */
@Value(staticConstructor = "of")
public class ParkingLotIdResponse implements Serializable {
    private List<String> parkingLotIds;
}
