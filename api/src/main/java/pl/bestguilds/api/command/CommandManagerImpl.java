package pl.bestguilds.api.command;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableSet;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.util.Iterables;

public final class CommandManagerImpl implements CommandManager {

  private       Command                mainCommand;
  private final BiMap<Command, String> subCommands;

  public CommandManagerImpl() {
    this.subCommands = HashBiMap.create();
  }

  @Override
  public void register(@NotNull CommandExecutor<?> executor) {
    Class<? extends CommandExecutor> type = executor.getClass();

    if (!type.isAnnotationPresent(SubCommand.class)) {
      return;
    }

    SubCommand subCommand = type.getAnnotation(SubCommand.class);
    Command command = new Command(subCommand.value(), subCommand.aliases(), executor);

    subCommands.put(command, command.getName());
  }

  @Override
  public Command getMainCommand() {
    return mainCommand;
  }

  @Override
  public void setMainCommand(CommandExecutor<?> executor) {
    mainCommand = new Command("bestguilds", new String[]{"guilds", "g"}, executor);
  }

  @Override
  public Optional<Command> getCommand(String name) {
    return Iterables.find(getSubCommands(), command -> command.constants(name));
  }

  @Override
  public ImmutableSet<Command> getSubCommands() {
    return ImmutableSet.copyOf(subCommands.keySet());
  }
}
