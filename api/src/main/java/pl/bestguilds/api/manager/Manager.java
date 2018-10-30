package pl.bestguilds.api.manager;

import io.vavr.collection.Set;
import io.vavr.control.Option;

import java.util.UUID;
import java.util.function.Predicate;

public interface Manager<T> {

    Option<T> getValue(UUID uuid);

    void addValue(UUID uuid, T t);

    void removeValue(UUID uuid);

    Set<T> getValues();

    default Option<T> findSafe(Predicate<T> filter) {
        return getValues().find(filter);
    }
}
