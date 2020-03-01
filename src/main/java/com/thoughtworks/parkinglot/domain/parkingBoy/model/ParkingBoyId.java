package com.thoughtworks.parkinglot.domain.parkingBoy.model;

import com.thoughtworks.parkinglot.common.model.AbstractId;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
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
@Embeddable
public class ParkingBoyId extends AbstractId {

    @Column(name = "parking_boy_id")
    private String id;

}
