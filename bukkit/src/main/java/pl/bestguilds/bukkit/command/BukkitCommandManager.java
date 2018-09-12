package pl.bestguilds.bukkit.command;

import java.lang.reflect.Field;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import pl.bestguilds.api.command.CommandException;

public class BukkitCommandManager {

  private final CommandMap commandMap;

  public BukkitCommandManager() {
    try {
      Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");
      field.setAccessible(true);
      commandMap = ((CommandMap) field.get(Bukkit.getServer()));
      field.setAccessible(false);
    } catch (IllegalAccessException | NoSuchFieldException exception) {
      throw new CommandException(exception);
    }
  }
}
