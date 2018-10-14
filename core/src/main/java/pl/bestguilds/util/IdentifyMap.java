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

public interface IdentifyMap<V> extends ConcurrentMap<UUID, V> {

    default Optional<V> getSafe(Object key) {
        return Optional.ofNullable(get(key));
    }

    @Nullable
    default V find(Predicate<V> filter) {
        return Iterables.find(values(), filter);
    }

    default Optional<V> findSafe(Predicate<V> filter) {
        return Iterables.findSafe(values(), filter);
    }

    default ImmutableList<V> sort(Comparator<V> comparator) {
        List<V> list = values().stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        return ImmutableList.copyOf(list);
    }

    class IdentifyHashMap<V> extends ConcurrentHashMap<UUID, V> implements IdentifyMap<V> {

        private static final long serialVersionUID = 1;
    }
}
