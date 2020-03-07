package com.thoughtworks.parkinglot.adapter.api.facade.mapper;

import com.thoughtworks.parkinglot.adapter.api.facade.response.CarResponse;
import com.thoughtworks.parkinglot.domain.model.parkinglot.Car;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
public class CarMapper {

    public CarResponse to(Car car) {
        return CarResponse.of(car.getLicensePlate());
    }
}
