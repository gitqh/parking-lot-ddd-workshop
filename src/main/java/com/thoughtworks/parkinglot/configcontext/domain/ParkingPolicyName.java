package com.thoughtworks.parkinglot.configcontext.domain;

import com.thoughtworks.parkinglot.annotation.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gitqh
 */
@AllArgsConstructor(staticName = "of")
@Getter
@ValueObject
public class ParkingPolicyName {
    private String name;
}
