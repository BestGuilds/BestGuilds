package pl.bestguilds.api.util;

import io.vavr.collection.Stream;
import io.vavr.control.Option;

import java.util.function.Predicate;

public final class Iterables {

    private Iterables() {
    }

    public static <T> Option<T> findSafe(Iterable<T> iterable, Predicate<T> filter) {
        return Stream.ofAll(iterable).find(filter);
    }
}
