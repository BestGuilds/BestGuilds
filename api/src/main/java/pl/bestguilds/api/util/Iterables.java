package pl.bestguilds.api.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.StreamSupport;

public final class Iterables {

    private Iterables() {
    }

    @Nullable
    public static <T> T find(@NotNull Iterable<T> iterable, Predicate<? super T> predicate) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    public static <T> Optional<T> findSafe(Iterable<T> iterable, Predicate<T> filter) {
        return Optional.ofNullable(find(iterable, filter));
    }
}
