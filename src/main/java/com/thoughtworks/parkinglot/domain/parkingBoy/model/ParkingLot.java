package com.thoughtworks.parkinglot.domain.parkingBoy.model;

import static com.google.common.collect.Lists.newArrayList;

import com.thoughtworks.parkinglot.domain.parkingBoy.exception.IllegalTicketException;
import com.thoughtworks.parkinglot.domain.parkingBoy.exception.NoEnoughCapacityException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Table;

/**
 * @author gitqh
 */
@Entity
@Table(name = "parking_lot")
@NoArgsConstructor
@Getter
public class ParkingLot {

    @Id
    private Long id;

    private ParkingBoyId parkingBoyId;

    private int capacity;

    @Transient
    private List<LicensePlate> licensePlates;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        licensePlates = newArrayList();
    }

    public ParkingLot(int capacity, Long id, ParkingBoyId parkingBoyId, List<LicensePlate> licensePlates) {
        this.capacity = capacity;
        this.id = id;
        this.parkingBoyId = parkingBoyId;
        this.licensePlates = licensePlates;
    }

    public void park(LicensePlate licensePlate) throws NoEnoughCapacityException {
        if (availableCapacity() < 1) {
            throw new NoEnoughCapacityException();
        }
        licensePlates.add(licensePlate);
    }

    public LicensePlate pick(LicensePlate lp) {
        LicensePlate licensePlate = licensePlates.stream()
                .filter(license -> license.equals(lp))
                .findFirst()
                .orElseThrow(IllegalTicketException::new);
        licensePlates.remove(licensePlate);
        return licensePlate;
    }

    public int availableCapacity() {
        return capacity - licensePlates.size();
    }

}
