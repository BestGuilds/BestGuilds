package pl.bestguilds.bukkit.command;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.command.Command;
import pl.bestguilds.api.command.CommandException;
import pl.bestguilds.api.command.CommandInjector;
import pl.bestguilds.api.command.ConsoleCommandSender;
import pl.bestguilds.api.command.arguments.Arguments;
import pl.bestguilds.api.user.User;

public class BukkitCommandInjector implements CommandInjector {

  private final CommandMap    commandMap;
  private final BestGuildsAPI plugin;

  public BukkitCommandInjector(BestGuildsAPI plugin) {
    this.plugin = plugin;

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
    this.commandMap.register("bestguilds", bukkit());
  }

  @SuppressWarnings("unchecked")
  private BukkitCommand bukkit() {
    final Command command = plugin.getCommandManager().getMainCommand();

    return new BukkitCommand(command.getName(), "", "", Arrays.asList(command.getAliases())) {
      @Override
      public boolean execute(CommandSender bukkitSender, String x, String[] bukkitArgs) {
        pl.bestguilds.api.command.CommandSender commandSender = ConsoleCommandSender.get();

        if (bukkitSender instanceof Player) {
          Optional<User> user = plugin.getUserManager().getUser(((Player) bukkitSender).getUniqueId());

          if (user.isPresent()) {
            commandSender = user.get();
          }
        }

        if (bukkitArgs.length < 1) {
          executeMainCommand(commandSender, Arguments.of(bukkitArgs));
          return true;
        }

        List<String> newArgs = Arrays.asList(bukkitArgs).subList(2, bukkitArgs.length);
        final Arguments args = Arguments.of((String[]) newArgs.toArray());

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
  private void executeMainCommand(pl.bestguilds.api.command.CommandSender sender, Arguments arguments) {
    final Command command = plugin.getCommandManager().getMainCommand();
    command.getExecutor().execute(sender, arguments);
  }
}
