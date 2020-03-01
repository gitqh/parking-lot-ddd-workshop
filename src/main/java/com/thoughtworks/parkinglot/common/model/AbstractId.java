package com.thoughtworks.parkinglot.common.model;

import java.io.Serializable;
import lombok.Getter;

/**
 * @author gitqh
 */
@Getter
public abstract class AbstractId implements Serializable {
    private String id;

    protected AbstractId() {}

    protected AbstractId(String id) { this.id = id; }
}
