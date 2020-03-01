package com.thoughtworks.parkinglot.domain.parkingBoy.model;

import static com.google.common.collect.Lists.newArrayList;

import com.thoughtworks.parkinglot.domain.parkingBoy.exception.IllegalTicketException;
import com.thoughtworks.parkinglot.domain.parkingBoy.exception.NoEnoughCapacityException;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Table;

/**
 * @author gitqh
 */
@Entity
@Table(name = "parking_lot")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ParkingLot {

    @Id
    private String parkingLotId;

    private ParkingBoyId parkingBoyId;

    private int capacity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "number")
    private List<LicensePlate> licensePlates;

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
