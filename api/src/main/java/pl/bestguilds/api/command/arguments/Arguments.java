package pl.bestguilds.api.command.arguments;

import io.vavr.collection.List;
import io.vavr.control.Option;

import java.util.function.Function;

public interface Arguments {

    static Arguments of(final List<String> args) {
        return new ArgumentsImpl(args);
    }

    List<String> get();

    Option<String> get(int index);

    <T> Option<T> get(int index, Function<String, T> function);

    default Option<Integer> asInt(int index) {
        return this.as(index, Integer::parseInt);
    }

    default Option<Float> asFloat(int index) {
        return this.as(index, Float::parseFloat);
    }

    default Option<Double> asDouble(int index) {
        return this.as(index, Double::parseDouble);
    }

    default <T> Option<T> as(int index, Function<String, T> function) {
        try {
            return this.get(index, function);
        } catch (NumberFormatException ignored) {
            return Option.none();
        }
    }

    default int size() {
        return this.get().size();
    }
}
