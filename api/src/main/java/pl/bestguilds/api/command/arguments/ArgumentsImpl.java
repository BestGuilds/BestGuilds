package pl.bestguilds.api.command.arguments;

import io.vavr.collection.List;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

final class ArgumentsImpl implements Arguments {

    private final List<String> args;

    ArgumentsImpl(List<String> args) {
        this.args = args;
    }

    @Override
    public int getSize() {
        return args.size();
    }

    @Override
    public List<String> get() {
        return this.args;
    }

    @Override
    public String get(int index) throws ArgumentsException {
        return args.get(index);
    }

    @Override
    public <T> T get(int index, @NotNull Function<String, T> function) throws ArgumentsException {
        return function.apply(this.asString(index));
    }

    @Override
    public String asString(int index) throws ArgumentsException {
        if (this.args.size() <= index) {
            throw new ArgumentsException("Out of range, size: " + args.size() + ", index: " + index);
        }

        return args.get(index);
    }

    @Override
    public int asInt(int index) throws ArgumentsException {
        final String content = asString(index);

        try {
            return Integer.parseInt(content);
        } catch (NumberFormatException exception) {
            throw new ArgumentsException("Cannot parse " + content + " to int.");
        }
    }

    @Override
    public float asFloat(int index) throws ArgumentsException {
        final String content = asString(index);

        try {
            return Float.parseFloat(content);
        } catch (NumberFormatException exception) {
            throw new ArgumentsException("Cannot parse " + content + " to float.");
        }
    }

    @Override
    public double asDouble(int index) throws ArgumentsException {
        final String content = asString(index);

        try {
            return Double.parseDouble(content);
        } catch (NumberFormatException exception) {
            throw new ArgumentsException("Cannot parse " + content + " to double.");
        }
    }
}
