package com.thoughtworks.parkinglot.common.ddd.domain.core;

import com.thoughtworks.parkinglot.common.ddd.annotation.ValueObject;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author gitqh
 */
@ValueObject
@Getter
@RequiredArgsConstructor
public class AggregateFieldChange<T> {
    private final T oldValue;
    private final T newValue;
}
