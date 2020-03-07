package com.thoughtworks.parkinglot.domain.model.parkinglot;

import com.thoughtworks.parkinglot.common.model.AbstractId;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author gitqh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ParkingBoyId extends AbstractId {

    private String id;

    public static ParkingBoyId newParkingBoyId() {
        return new ParkingBoyId(UUID.randomUUID().toString().replace("-", ""));
    }

}
