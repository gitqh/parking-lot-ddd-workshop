package com.thoughtworks.parkinglot.adapter.api;

import static org.springframework.http.HttpStatus.CREATED;

import com.thoughtworks.parkinglot.adapter.api.facade.ParkingServiceFacade;
import com.thoughtworks.parkinglot.adapter.api.facade.dto.ParkingDTO;
import com.thoughtworks.parkinglot.adapter.api.facade.dto.PickingDTO;
import com.thoughtworks.parkinglot.domain.model.parkinglot.Car;
import com.thoughtworks.parkinglot.domain.model.parkinglot.Ticket;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gitqh
 */
@RestController
@RequestMapping("parking-lot")
@AllArgsConstructor
@Api(tags = "Parking Lot")
public class ParkingController {

    private ParkingServiceFacade parkingServiceFacade;

    @PostMapping("/parking")
    @ApiOperation("park a car")
    @ResponseStatus(CREATED)
    public TicketResponse park(@RequestBody ParkingDTO parkingDTO) {
        return new TicketResponse(parkingServiceFacade.park(parkingDTO));
    }

    @PostMapping("/picking")
    @ApiOperation("pick a car")
    @ResponseStatus(CREATED)
    public CarResponse pick(@RequestBody PickingDTO pickingDTO) {
        final Car car = parkingServiceFacade.pick(pickingDTO);
        return new CarResponse(car);
    }

    @Getter
    public static class CarResponse {
        private final String carLicensePlate;

        CarResponse(Car car) {
            this.carLicensePlate = car.getLicensePlate();
        }
    }

    @Getter
    public static class TicketResponse {
        private final String ticketId;
        private final String carLicensePlate;
        private final String parkingLotId;

        TicketResponse(Ticket ticket) {
            this.ticketId = ticket.getId().getValue();
            this.carLicensePlate = ticket.getLicensePlate();
            this.parkingLotId = ticket.getParkingLotId().getValue();
        }
    }
}
