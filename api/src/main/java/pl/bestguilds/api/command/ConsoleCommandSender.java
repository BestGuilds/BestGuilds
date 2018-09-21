package pl.bestguilds.api.command;

public interface ConsoleCommandSender extends BestCommandSender {

  @Override
  default String getName() {
    return "[CONSOLE]";
  }

  class Impl implements ConsoleCommandSender {

  }
}
