package com.thoughtworks.parkinglot.adapter.api;

import com.thoughtworks.parkinglot.adapter.api.facade.ParkingServiceFacade;
import com.thoughtworks.parkinglot.adapter.api.facade.dto.ParkingBoyDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
