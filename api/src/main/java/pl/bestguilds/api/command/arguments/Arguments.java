package pl.bestguilds.api.command.arguments;

import io.vavr.collection.List;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public interface Arguments {

    static Arguments of(String[] args) {
        final List<String> list = List.of(args);
        return new ArgumentsImpl(list);
    }

    static Arguments of(List<String> args) {
        return new ArgumentsImpl(args);
    }

    int getSize();

    List<String> get();

    String get(int index) throws ArgumentsException;

    <T> T get(int index, @NotNull Function<String, T> function) throws ArgumentsException;

    String asString(int index) throws ArgumentsException;

    int asInt(int index) throws ArgumentsException;

    float asFloat(int index) throws ArgumentsException;

    double asDouble(int index) throws ArgumentsException;
}
