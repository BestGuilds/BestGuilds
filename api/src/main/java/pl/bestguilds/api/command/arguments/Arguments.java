package pl.bestguilds.api.command.arguments;

import com.google.common.collect.ImmutableList;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

public interface Arguments {

  static Arguments of(String[] args) {
    return new ArgumentsImpl(args);
  }

  int getSize();

  ImmutableList<String> get();

  String get(int index) throws ArgumentsException;

  <T> T get(int index, @NotNull Function<String, T> function) throws ArgumentsException;

  String asString(int index) throws ArgumentsException;

  int asInt(int index) throws ArgumentsException;

  float asFloat(int index) throws ArgumentsException;

  double asDouble(int index) throws ArgumentsException;
}
