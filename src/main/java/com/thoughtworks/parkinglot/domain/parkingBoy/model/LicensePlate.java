package com.thoughtworks.parkinglot.domain.parkingBoy.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author gitqh
 */
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class LicensePlate {

    @Id
    private String number;

    private String ParkingLotId;

}
