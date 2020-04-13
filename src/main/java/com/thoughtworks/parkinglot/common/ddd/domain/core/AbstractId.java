package com.thoughtworks.parkinglot.common.ddd.domain.core;

import com.thoughtworks.parkinglot.common.ddd.annotation.ValueObject;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author gitqh
 */
@Getter
@AllArgsConstructor
@ValueObject
public abstract class AbstractId implements Serializable {
    @EqualsAndHashCode.Include
    private String value;

    protected AbstractId() {

    }
}
