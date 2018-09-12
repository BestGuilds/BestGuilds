package pl.bestguilds.api.command;

import pl.bestguilds.api.command.arguments.Arguments;

@FunctionalInterface
public interface CommandExecutor<T extends CommandSender> {

  void execute(T sender, Arguments args) throws CommandException;
}
