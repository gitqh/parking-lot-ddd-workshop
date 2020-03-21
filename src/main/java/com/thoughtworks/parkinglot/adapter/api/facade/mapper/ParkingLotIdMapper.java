package com.thoughtworks.parkinglot.adapter.api.facade.mapper;

import com.thoughtworks.parkinglot.adapter.api.facade.response.ParkingLotIdResponse;
import com.thoughtworks.parkinglot.domain.model.finder.ParkingLotId;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
public class ParkingLotIdMapper {

    public ParkingLotIdResponse to(final List<ParkingLotId> parkingLotIds) {
        List<String> parkingLotIdStrings = parkingLotIds.stream()
                .map(ParkingLotId::getValue)
                .collect(Collectors.toList());
        return ParkingLotIdResponse.of(parkingLotIdStrings);
    }
}
