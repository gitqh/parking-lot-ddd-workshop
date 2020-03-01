package com.thoughtworks.parkinglot.adapter.api.facade.mapper;

import com.thoughtworks.parkinglot.adapter.api.facade.dto.ParkingBoyDTO;
import com.thoughtworks.parkinglot.adapter.api.facade.dto.ParkingLotDTO;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.GraduateParkingBoy;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

//@Mapper
@Component
public class ParkingBoyDTOMapper {

    public ParkingBoyDTO from(GraduateParkingBoy parkingBoy) {
        List<ParkingLotDTO> parkingLotDTOs = parkingBoy.getParkingLots().stream()
                .map(lot -> ParkingLotDTO.builder().capacity(lot.getCapacity()).build())
                .collect(Collectors.toList());

        return ParkingBoyDTO.builder()
                .name(parkingBoy.getName())
                .parkingBoyId(parkingBoy.getParkingBoyId().toString())
                .parkingLots(parkingLotDTOs)
                .build();
    }
}
