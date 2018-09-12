package pl.bestguilds.api.command;

import com.google.common.collect.ImmutableSet;
import org.jetbrains.annotations.NotNull;

public interface CommandManager {

  void register(@NotNull CommandExecutor executor);

  void register(CommandExecutor... executors);

  ImmutableSet<Command> getSubCommands();
}
