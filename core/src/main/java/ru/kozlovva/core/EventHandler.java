package ru.kozlovva.core;

/**
 *  Handle event
 * @param <E>
 */
public interface EventHandler<E extends Event> {

    void onEvent(E event);

}
