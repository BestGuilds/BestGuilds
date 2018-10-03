package pl.bestguilds.util;

import com.google.common.collect.ImmutableList;
import org.jetbrains.annotations.Nullable;
import pl.bestguilds.api.util.Iterables;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface IdentifyMap<T> extends ConcurrentMap<UUID, T> {

    default Optional<T> getSafe(Object key) {
        return Optional.ofNullable(get(key));
    }

    @Nullable
    default T find(Predicate<T> filter) {
        return Iterables.find(values(), filter);
    }

    default Optional<T> findSafe(Predicate<T> filter) {
        return Iterables.findSafe(values(), filter);
    }

    default ImmutableList<T> sort(Comparator<T> comparator) {
        List<T> list = values().stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        return ImmutableList.copyOf(list);
    }

    class IdentifyHashMap<T> extends ConcurrentHashMap<UUID, T> implements IdentifyMap<T> {

        private static final long serialVersionUID = 1;
    }
}
