package pl.bestguilds.api.command;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class Command {

  private final           String          name;
  private final           String[]        aliases;
  private final transient CommandExecutor executor;

  Command(@NotNull String name, @NotNull String[] aliases, @NotNull CommandExecutor executor) {
    this.name = name;
    this.aliases = aliases;
    this.executor = executor;
  }

  public Command(String name, CommandExecutor executor) {
    this(name, new String[0], executor);
  }

  public String getName() {
    return name;
  }

  public String[] getAliases() {
    return aliases;
  }

  public CommandExecutor getExecutor() {
    return executor;
  }

  public boolean constants(String name) {
    if (this.name.equalsIgnoreCase(name)) {
      return true;
    }

    return Arrays.stream(aliases)
        .anyMatch(alias -> alias.equalsIgnoreCase(name));
  }
}
