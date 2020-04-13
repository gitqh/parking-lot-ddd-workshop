package com.thoughtworks.parkinglot.configcontext.adapter.repository.entity;

import com.thoughtworks.parkinglot.common.ddd.annotation.Entity;
import com.thoughtworks.parkinglot.parkingcontext.domain.policy.ParkingPolicyEnum;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author gitqh
 */
@Entity
//@Table("parking_boy")
public class ParkingBoyConfigEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ParkingPolicyEnum parkingPolicy;
}
