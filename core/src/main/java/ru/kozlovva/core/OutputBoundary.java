package ru.kozlovva.core;

public interface OutputBoundary<V, R> {
    V getViewModel();
    void present(R response);
}
