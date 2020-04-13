package com.thoughtworks.parkinglot.common.ddd.domain.core;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.thoughtworks.parkinglot.common.ddd.annotation.ReadModel;
import com.thoughtworks.parkinglot.common.ddd.domain.shared.Time;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import lombok.Data;

/**
 * @author gitqh
 */
@Data
@ReadModel
public abstract class AggregateRoot extends Entity {
    private final Set<DomainEvent> events = Sets.newHashSet();
    private final Time time;

    public AggregateRoot(AbstractId id, Time time) {
        super(id);
        this.time = time;
    }

    public AggregateRoot(AbstractId id) {
        super(id);
        LocalDateTime now = LocalDateTime.now();
        this.time = Time.of(now, now);
    }

    public List<DomainEvent> getEvents() {
        return Collections.unmodifiableList(Lists.newArrayList(events));
    }

    protected boolean addEvent(DomainEvent domainEvent) {
        return events.add(domainEvent);
    }

    protected void change() {
        this.time.changeUpdatedTime();
    }

    public LocalDateTime getCreatedTime() {
        return this.time.getCreatedTime();
    }

    public LocalDateTime getUpdatedTime() {
        return this.time.getUpdatedTime();
    }

    protected <T> AggregateFieldChange<T> change(T newValue, Consumer<T> setConsumer, Supplier<T> getSupplier) {
        AggregateFieldChange<T> aggregateFieldChange = new AggregateFieldChange<>(getSupplier.get(), newValue);
        setConsumer.accept(newValue);
        return aggregateFieldChange;
    }

    protected <T> AggregateFieldChange<T> change(OptionalObject<T> newValue, Consumer<T> setConsumer, Supplier<T> getSupplier) {
        if (newValue == null) {
            return null;
        }
        return change(newValue.getValue(), )
    }
}
