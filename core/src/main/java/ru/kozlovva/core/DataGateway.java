package ru.kozlovva.core;

import java.util.Optional;

public interface DataGateway<T> {
    T save(T t);
    Optional<T> findById(String id);
}
