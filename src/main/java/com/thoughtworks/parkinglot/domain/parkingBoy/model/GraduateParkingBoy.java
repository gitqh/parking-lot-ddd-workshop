package com.thoughtworks.parkinglot.domain.parkingBoy.model;

import com.thoughtworks.parkinglot.domain.parkingBoy.exception.NoEnoughCapacityException;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gitqh
 */
@Entity
@Table(name = "parking_boy")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GraduateParkingBoy {

    @EmbeddedId
    private ParkingBoyId parkingBoyId;

    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    @JoinColumn(name = "parking_boy_id")
    private List<ParkingLot> parkingLots;

    public void park(LicensePlate licensePlate) throws NoEnoughCapacityException {
        parkingLots.stream()
                .filter(parkingLot -> parkingLot.availableCapacity() > 0)
                .findFirst()
                .orElseThrow(NoEnoughCapacityException::new);
    }
}
