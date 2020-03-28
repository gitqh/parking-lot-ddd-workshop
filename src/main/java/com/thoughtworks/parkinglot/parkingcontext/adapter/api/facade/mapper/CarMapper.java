package com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.mapper;

import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.response.CarResponse;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author gitqh
 */
@Mapper
public interface CarMapper {

    @Mapping(source = "licensePlate", target = "carLicensePlate")
    CarResponse to(Car car);
}
