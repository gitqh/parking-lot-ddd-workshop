package com.thoughtworks.parkinglot.parkingcontext.adapter.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.ParkingLotServiceFacade;
import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.dto.ParkingWithParkingBoyDTO;
import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.dto.ParkingWithParkingManagerDTO;
import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.dto.PickingDTO;
import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.response.CarResponse;
import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.response.ParkingLotIdResponse;
import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.response.TicketResponse;
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

    @PostMapping("/parkingboy/parking")
    @ApiOperation("park a car")
    @ResponseStatus(CREATED)
    public TicketResponse park(@RequestBody final ParkingWithParkingBoyDTO parkingWithParkingBoyDTO) {
        return parkingLotServiceFacade.parkWithParkingBoy(parkingWithParkingBoyDTO);
    }

    @PostMapping("/parkingmanager/parking")
    @ApiOperation("park a car")
    @ResponseStatus(CREATED)
    public TicketResponse park(@RequestBody final ParkingWithParkingManagerDTO parkingWithParkingManagerDTO) {
        return parkingLotServiceFacade.parkWithParkingManager(parkingWithParkingManagerDTO);
    }

    @PostMapping("/")
    @ApiOperation("list parking lot with space")
    @ResponseStatus(OK)
    public ParkingLotIdResponse listParkingLot() {
        return parkingLotServiceFacade.listsParkingLotWithSpace();
    }

    @PostMapping("/picking")
    @ApiOperation("pick a car")
    @ResponseStatus(CREATED)
    public CarResponse pick(@RequestBody final PickingDTO pickingDTO) {
        return parkingLotServiceFacade.pick(pickingDTO);
    }
}
