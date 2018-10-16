package pl.bestguilds.api.command;

import org.bukkit.permissions.ServerOperator;
import pl.bestguilds.api.command.arguments.Arguments;

@FunctionalInterface
public interface CommandExecutor<T extends ServerOperator> {

    void execute(T sender, Arguments args) throws CommandException;
}
