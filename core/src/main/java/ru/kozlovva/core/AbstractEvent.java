package ru.kozlovva.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class AbstractEvent implements Event {
    protected String id = UUID.randomUUID().toString();
    protected String traceId = UUID.randomUUID().toString();
    protected Instant date = Instant.now();

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }
}
