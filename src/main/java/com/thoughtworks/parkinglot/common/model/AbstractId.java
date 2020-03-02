package com.thoughtworks.parkinglot.common.model;

import java.io.Serializable;
import lombok.Getter;

/**
 * @author gitqh
 */
@Getter
public abstract class AbstractId implements Serializable {
    private String value;

    protected AbstractId() {}

    protected AbstractId(String value) { this.value = value; }
}
