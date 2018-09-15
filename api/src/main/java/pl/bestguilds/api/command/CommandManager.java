package pl.bestguilds.api.command;

import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public interface CommandManager {

  void register(@NotNull CommandExecutor executor);

  default void register(CommandExecutor... executors) {
    Arrays.stream(executors).forEach(this::register);
  }

  ImmutableSet<Command> getSubCommands();
}
