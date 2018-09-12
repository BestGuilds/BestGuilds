package pl.bestguilds.api.command;

public interface ConsoleCommandSender extends CommandSender {

  @Override
  default String getName() {
    return "[Console]";
  }
}
