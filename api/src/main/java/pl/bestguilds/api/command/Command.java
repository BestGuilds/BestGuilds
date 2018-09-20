package pl.bestguilds.api.command;

public interface Command {

  String getName();

  String[] getAliases();

  CommandExecutor getExecutor();

  boolean constants(String name);
}
