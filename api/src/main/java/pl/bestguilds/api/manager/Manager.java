package pl.bestguilds.api.manager;

import com.google.common.collect.ImmutableSet;
import pl.bestguilds.api.util.Iterables;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public interface Manager<T> {

    Optional<T> getValue(UUID uuid);

    ImmutableSet<T> getValues();

    default T find(Predicate<T> filter) {
        return Iterables.find(getValues(), filter);
    }

    default Optional<T> findSafe(Predicate<T> filter) {
        return Optional.ofNullable(find(filter));
    }
}
