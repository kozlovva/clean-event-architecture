package ru.kozlovva.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public abstract class EventDispatcher {

    public abstract <E extends Event> void registerHandler(Class<E> eventType, EventHandler<? super E> handler);

    public abstract <E extends Event> void dispatch(E event);

    protected abstract  <E extends Event> void sendEventToHandlers(Collection<EventHandler<? extends Event>> targetEventHandlers, E event);

}
