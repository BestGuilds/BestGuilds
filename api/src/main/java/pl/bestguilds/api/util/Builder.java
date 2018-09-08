package pl.bestguilds.api.util;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface Builder<T> {

  @NotNull
  T build();
}
