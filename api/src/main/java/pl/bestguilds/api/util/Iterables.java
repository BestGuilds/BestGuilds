package pl.bestguilds.api.util;

import java.util.Optional;
import java.util.function.Predicate;
import org.jetbrains.annotations.NotNull;

public final class Iterables {

  private Iterables() {
  }

  public static <T> Optional<T> find(@NotNull Iterable<T> elements, @NotNull Predicate<T> filter) {
    for (T element : elements) {
      if (filter.test(element)) {
        return Optional.ofNullable(element);
      }
    }

    return Optional.empty();
  }
}
