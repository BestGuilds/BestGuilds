package pl.bestguilds.api.command.arguments;

import io.vavr.collection.List;
import io.vavr.control.Option;

import java.util.function.Function;

public final class ArgumentsImpl implements Arguments {

    private final List<String> args;

    ArgumentsImpl(final List<String> args) {
        this.args = args;
    }

    @Override
    public List<String> get() {
        return this.args;
    }

    @Override
    public Option<String> get(final int index) {
        final String arg = this.args.get(index);
        return Option.of(arg);
    }

    @Override
    public <T> Option<T> get(final int index, final Function<String, T> function) {
        return this.get(index).map(function);
    }
}