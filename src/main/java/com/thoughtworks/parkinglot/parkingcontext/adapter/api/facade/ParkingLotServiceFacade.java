package com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade;

import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.dto.ParkingWithParkingBoyDTO;
import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.dto.ParkingWithParkingManagerDTO;
import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.dto.PickingDTO;
import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.mapper.CarMapper;
import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.response.CarResponse;
import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.response.ParkingLotIdResponse;
import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.response.TicketResponse;
import com.thoughtworks.parkinglot.parkingcontext.application.ParkingLotApplicationService;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLotId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class ParkingLotServiceFacade {
    private final ParkingLotApplicationService parkingLotApplicationService;
    private final CarMapper carMapper;

    public TicketResponse parkWithParkingBoy(final ParkingWithParkingBoyDTO parkingWithParkingBoyDTO) {
        return TicketResponse.to(parkingLotApplicationService
                .parkByParkingBoy(parkingWithParkingBoyDTO.getParkingBoyId(),
                        parkingWithParkingBoyDTO.getLicensePlate()));
    }

    public TicketResponse parkWithParkingManager(final ParkingWithParkingManagerDTO parkingWithParkingManagerDTO) {
        return TicketResponse.to(parkingLotApplicationService
                .parkByParkingManager(parkingWithParkingManagerDTO.getLicensePlate()));
    }

    public ParkingLotIdResponse listsParkingLotWithSpace() {
        return ParkingLotIdResponse.to(parkingLotApplicationService.listsParkingLotWithSpace());
    }

    public CarResponse pick(final PickingDTO pickingDTO) {
        return carMapper.to(parkingLotApplicationService.pick(pickingDTO.getLicensePlate(),
                new ParkingLotId(pickingDTO.getParkingLotId())));
    }
}
