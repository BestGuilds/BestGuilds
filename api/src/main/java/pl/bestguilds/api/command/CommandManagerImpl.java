package pl.bestguilds.api.command;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public final class CommandManagerImpl implements CommandManager {

  private final BiMap<Command, String> subCommands;

  public CommandManagerImpl() {
    this.subCommands = HashBiMap.create();
  }

  @Override
  public void register(@NotNull CommandExecutor executor) {
    Class<? extends CommandExecutor> type = executor.getClass();

    if (!type.isAnnotationPresent(SubCommand.class)) {
      return;
    }

    SubCommand subCommand = type.getAnnotation(SubCommand.class);
    Command command = new Command(subCommand.value(), subCommand.aliases(), executor);

    subCommands.put(command, command.getName());
  }

  @Override
  public void register(CommandExecutor... executors) {
    Arrays.stream(executors).forEach(this::register);
  }

  @Override
  public ImmutableSet<Command> getSubCommands() {
    return ImmutableSet.copyOf(subCommands.keySet());
  }
}
