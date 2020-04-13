package com.thoughtworks.parkinglot.common.ddd.domain.shared;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gitqh
 */
@AllArgsConstructor(staticName = "of")
@Data
public class Time {
    private final LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public void changeUpdatedTime() {
        this.updatedTime = LocalDateTime.now();
    }
}
