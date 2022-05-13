package ua.kosheleva.hw17;

@FunctionalInterface
public interface Limit<T> {
    boolean choise(T t);
}
