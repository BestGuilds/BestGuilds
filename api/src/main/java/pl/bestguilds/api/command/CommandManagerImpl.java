package pl.bestguilds.api.command;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableSet;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.command.arguments.Arguments;
import pl.bestguilds.api.user.User;
import pl.bestguilds.api.util.Iterables;

import java.util.Optional;

public final class CommandManagerImpl implements CommandManager {

  private final BiMap<Command, String> subCommands;
  private       Command                mainCommand;

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
    Command command = new CommandImpl(subCommand.value(), subCommand.aliases(), executor);

    subCommands.put(command, command.getName());
  }

  @Override
  public Command getMainCommand() {
    return mainCommand;
  }

  @Override
  public void setMainCommand(CommandExecutor<?> executor) {
    mainCommand = new CommandImpl("bestguilds", new String[]{"guilds", "g"}, executor);
  }

  @Override
  public Optional<Command> getCommand(String name) {
    return Iterables.findSafe(getSubCommands(), command -> command.contains(name));
  }

  @Override
  public ImmutableSet<Command> getSubCommands() {
    return ImmutableSet.copyOf(subCommands.keySet());
  }
}
