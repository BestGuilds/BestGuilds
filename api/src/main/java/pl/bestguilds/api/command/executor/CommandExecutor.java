package pl.bestguilds.api.command.executor;

import org.bukkit.command.CommandSender;
import pl.bestguilds.api.command.arguments.Arguments;

@FunctionalInterface
public interface CommandExecutor {

    void execute(CommandSender sender, Arguments args);
}
