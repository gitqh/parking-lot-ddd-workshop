package com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.response;

import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLotId;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Value;

/**
 * @author gitqh
 */
@Value(staticConstructor = "of")
public class ParkingLotIdResponse implements Serializable {
    private List<String> parkingLotIds;

    public static ParkingLotIdResponse to(final List<ParkingLotId> parkingLotIds) {
        return ParkingLotIdResponse.of(
                parkingLotIds.stream().map(ParkingLotId::getValue).collect(Collectors.toList()));
    }
}
