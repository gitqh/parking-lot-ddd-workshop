package com.thoughtworks.parkinglot.configcontext.domain;

import com.thoughtworks.parkinglot.annotation.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * @author gitqh
 */
@AllArgsConstructor(staticName = "of")
@Value
@ValueObject
public class ParkingBoyName {
    private String value;
}
