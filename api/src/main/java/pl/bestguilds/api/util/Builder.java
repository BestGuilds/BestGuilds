package pl.bestguilds.api.util;

@FunctionalInterface
public interface Builder<T> {

  T build();
}