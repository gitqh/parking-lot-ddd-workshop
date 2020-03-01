package com.thoughtworks.parkinglot.adapter.api;

import static org.springframework.http.HttpStatus.CREATED;

import com.thoughtworks.parkinglot.adapter.api.facade.ParkingServiceFacade;
import com.thoughtworks.parkinglot.adapter.api.facade.dto.ParkingBoyDTO;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.LicensePlate;
import com.thoughtworks.parkinglot.domain.ticket.model.Ticket;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gitqh
 */
@RestController
@RequestMapping("parking-boy")
@AllArgsConstructor
@Api(tags = "Parking")
public class ParkingController {

    private ParkingServiceFacade parkingServiceFacade;

    @GetMapping("/{parkingBoyId}")
    @ApiOperation("retrieve parking boy")
    public ParkingBoyDTO retrieveParkingBoy(@PathVariable String parkingBoyId) {
        return parkingServiceFacade.find(parkingBoyId);
    }

    @PostMapping("/{parkingBoyId}/license-plate/{number}")
    @ApiOperation("park a car")
    @ResponseStatus(CREATED)
    public Ticket park(@PathVariable String parkingBoyId, @PathVariable String number) {
        return parkingServiceFacade.park(parkingBoyId, number);
    }
}
