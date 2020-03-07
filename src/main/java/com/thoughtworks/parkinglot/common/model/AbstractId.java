package com.thoughtworks.parkinglot.common.model;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author gitqh
 */
@Getter
public abstract class AbstractId implements Serializable {
    @EqualsAndHashCode.Include
    private String value;

    protected AbstractId() {

    }

    protected AbstractId(final String value) {
        this.value = value;
    }
}
