package com.thoughtworks.parkinglot.configcontext.adapter.api;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gitqh
 */
@RestController
@RequestMapping("parking-config")
@AllArgsConstructor
@Api(tags = "Parking Config")
public class ParkingConfigController {
}
