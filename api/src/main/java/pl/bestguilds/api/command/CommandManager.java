package pl.bestguilds.api.command;

import com.google.common.collect.ImmutableSet;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Optional;

public interface CommandManager {

  void register(@NotNull CommandExecutor<?> executor);

  default void register(CommandExecutor<?>... executors) {
    Arrays.stream(executors).forEach(this::register);
  }

  Command getMainCommand();

  void setMainCommand(CommandExecutor<?> executor);

  Optional<Command> getCommand(String name);

  ImmutableSet<Command> getSubCommands();
}
