package com.thoughtworks.parkinglot.common.ddd.domain.core;

import com.thoughtworks.parkinglot.common.ddd.annotation.ValueObject;
import lombok.Getter;

/**
 * @author gitqh
 */
@ValueObject
@Getter
public class OptionalObject<T> {
    private final T value;

    public OptionalObject(final T value) {
        this.value = value;
    }
}
