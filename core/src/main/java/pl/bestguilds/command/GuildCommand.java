package pl.bestguilds.command;

import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.command.CommandException;
import pl.bestguilds.api.command.UserCommandExecutor;
import pl.bestguilds.api.command.arguments.Arguments;
import pl.bestguilds.api.user.User;

public class GuildCommand extends UserCommandExecutor {

    public GuildCommand(@NotNull BestGuildsAPI plugin) {
        super(plugin);
    }

    @Override
    public void execute(User sender, Arguments args) throws CommandException {
        sender.sendMessage("=)");
    }
}
