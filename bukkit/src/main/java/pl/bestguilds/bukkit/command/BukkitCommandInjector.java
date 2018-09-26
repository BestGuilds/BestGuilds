package pl.bestguilds.bukkit.command;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.command.*;
import pl.bestguilds.api.command.arguments.Arguments;
import pl.bestguilds.api.user.User;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BukkitCommandInjector implements CommandInjector {

  private final CommandMap        commandMap;
  private final BestCommandSender defaultSender;
  private final BestGuildsAPI     plugin;

  public BukkitCommandInjector(BestGuildsAPI plugin) {
    this.plugin = plugin;
    this.defaultSender = new ConsoleCommandSender.Impl();

    try {
      Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");
      field.setAccessible(true);
      commandMap = ((CommandMap) field.get(Bukkit.getServer()));
      field.setAccessible(false);
    } catch (IllegalAccessException | NoSuchFieldException exception) {
      throw new CommandException(exception);
    }
  }

  @Override
  public void inject() {
    commandMap.register("bestguilds", bukkit());
  }

  @SuppressWarnings("unchecked")
  private BukkitCommand bukkit() {
    final Command command = plugin.getCommandManager().getMainCommand();

    return new BukkitCommand(command.getName(), "a guild command", "/g", Arrays.asList(command.getAliases())) {
      @Override
      public boolean execute(CommandSender bukkitSender, String x, String[] bukkitArgs) {
        BestCommandSender commandSender = defaultSender;

        Optional<User> user = plugin.getUserManager().getUser(((Player) bukkitSender).getUniqueId());

        if (user.isPresent()) {
          commandSender = user.get();
        }

        if (bukkitArgs.length < 1) {
          executeMainCommand(commandSender, Arguments.of(bukkitArgs));
          return true;
        }

        List<String> newArgs = Arrays.asList(bukkitArgs).subList(2, bukkitArgs.length);
        final Arguments args = Arguments.of(newArgs);

        Optional<Command> subCommand = plugin.getCommandManager().getCommand(bukkitArgs[1]);

        if (subCommand.isPresent()) {
          subCommand.get().getExecutor().execute(commandSender, args);
        } else {
          executeMainCommand(commandSender, args);
        }

        return true;
      }
    };
  }

  @SuppressWarnings("unchecked")
  private void executeMainCommand(BestCommandSender sender, Arguments arguments) {
    final Command command = plugin.getCommandManager().getMainCommand();
    command.getExecutor().execute(sender, arguments);
  }
}
