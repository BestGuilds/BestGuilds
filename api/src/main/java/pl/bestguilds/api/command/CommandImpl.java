package pl.bestguilds.api.command;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class CommandImpl implements Command {

  private final           String          name;
  private final           String[]        aliases;
  private final transient CommandExecutor executor;

  CommandImpl(@NotNull String name, @NotNull String[] aliases, @NotNull CommandExecutor executor) {
    this.name = name;
    this.aliases = aliases;
    this.executor = executor;
  }

  public CommandImpl(String name, CommandExecutor executor) {
    this(name, new String[0], executor);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String[] getAliases() {
    return aliases;
  }

  @Override
  public CommandExecutor getExecutor() {
    return executor;
  }

  @Override
  public boolean constants(String name) {
    if (this.name.equalsIgnoreCase(name)) {
      return true;
    }

    return Arrays.stream(aliases)
        .anyMatch(alias -> alias.equalsIgnoreCase(name));
  }
}
