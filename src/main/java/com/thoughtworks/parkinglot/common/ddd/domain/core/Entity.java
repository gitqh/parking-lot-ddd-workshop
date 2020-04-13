package com.thoughtworks.parkinglot.common.ddd.domain.core;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author gitqh
 */
@RequiredArgsConstructor
@ToString
public abstract class Entity {
    private final AbstractId id;

    public AbstractId getIdentity() {
        return id;
    }

    public String getId() {
        return getIdentity().getValue();
    }
}
