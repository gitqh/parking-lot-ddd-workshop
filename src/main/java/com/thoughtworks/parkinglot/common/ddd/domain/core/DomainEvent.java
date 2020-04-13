package com.thoughtworks.parkinglot.common.ddd.domain.core;

import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author gitqh
 */
@RequiredArgsConstructor
@Getter
@ToString
public abstract class DomainEvent {
    @EqualsAndHashCode.Include
    private final String id;
    @EqualsAndHashCode.Include
    private final LocalDateTime createdAt;
    private final DomainEventType domainEventType;

    public String getIdentityName() {
        return this.getClass().getSimpleName();
    }
}
