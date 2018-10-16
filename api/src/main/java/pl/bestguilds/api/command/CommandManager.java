package pl.bestguilds.api.command;

import io.vavr.collection.Set;
import io.vavr.control.Option;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public interface CommandManager {

    void register(@NotNull CommandExecutor<?> executor);

    default void register(CommandExecutor<?>... executors) {
        Arrays.stream(executors).forEach(this::register);
    }

    Command getMainCommand();

    void setMainCommand(CommandExecutor<?> executor);

    Option<Command> getCommand(String name);

    Set<Command> getSubCommands();
}
