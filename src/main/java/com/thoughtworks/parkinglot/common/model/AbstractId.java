package com.thoughtworks.parkinglot.common.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author gitqh
 */
@Getter
@AllArgsConstructor
public abstract class AbstractId implements Serializable {
    @EqualsAndHashCode.Include
    private String value;

    protected AbstractId() {

    }
}
