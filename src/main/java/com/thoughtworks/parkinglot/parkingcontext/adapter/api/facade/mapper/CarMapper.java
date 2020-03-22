package com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.mapper;

import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.response.CarResponse;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.Car;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
public class CarMapper {

    public CarResponse to(final Car car) {
        return CarResponse.of(car.getLicensePlate());
    }
}
