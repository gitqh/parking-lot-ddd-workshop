package com.thoughtworks.parkinglot.adapter.api.facade.mapper;

import com.thoughtworks.parkinglot.adapter.api.facade.response.CarResponse;
import com.thoughtworks.parkinglot.domain.model.finder.Car;
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
