package com.thoughtworks.parkinglot.adapter.api;

import static org.springframework.http.HttpStatus.CREATED;

import com.thoughtworks.parkinglot.adapter.api.facade.ParkingLotServiceFacade;
import com.thoughtworks.parkinglot.adapter.api.facade.dto.ParkingDTO;
import com.thoughtworks.parkinglot.adapter.api.facade.dto.PickingDTO;
import com.thoughtworks.parkinglot.adapter.api.facade.response.CarResponse;
import com.thoughtworks.parkinglot.adapter.api.facade.response.TicketResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
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
public class ParkingLotController {

    private ParkingLotServiceFacade parkingLotServiceFacade;

    @PostMapping("/parking")
    @ApiOperation("park a car")
    @ResponseStatus(CREATED)
    public TicketResponse park(@RequestBody final ParkingDTO parkingDTO) {
        return parkingLotServiceFacade.park(parkingDTO);
    }

    @PostMapping("/picking")
    @ApiOperation("pick a car")
    @ResponseStatus(CREATED)
    public CarResponse pick(@RequestBody final PickingDTO pickingDTO) {
        return parkingLotServiceFacade.pick(pickingDTO);
    }
}
