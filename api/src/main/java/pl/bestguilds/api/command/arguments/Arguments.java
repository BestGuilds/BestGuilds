package pl.bestguilds.api.command.arguments;

import io.vavr.collection.List;
import io.vavr.control.Option;

import java.util.function.Function;

public interface Arguments {

    static Arguments of(final List<String> args) {
        return new ArgumentsImpl(args);
    }

    static Arguments of(final java.util.List<String> arguments) {
        final List<String> args = List.ofAll(arguments);
        return of(args);
    }

    static Arguments of(final String[] arguments) {
        final List<String> args = List.of(arguments);
        return of(args);
    }

    List<String> get();

    Option<String> get(int index);

    <T> Option<T> get(int index, Function<String, T> function);

    default Option<Integer> asInt(int index) {
        try {
            return this.get(index, Integer::parseInt);
        } catch (NumberFormatException ignored) {
            return Option.none();
        }
    }

    default Option<Float> asFloat(int index) {
        try {
            return this.get(index, Float::parseFloat);
        } catch (NumberFormatException ignored) {
            return Option.none();
        }
    }

    default Option<Double> asDouble(int index) {
        try {
            return this.get(index, Double::parseDouble);
        } catch (NumberFormatException ignored) {
            return Option.none();
        }
    }

    default int size() {
        return this.get().size();
    }
}
