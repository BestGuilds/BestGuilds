package pl.bestguilds.command;

import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.command.arguments.Arguments;
import pl.bestguilds.api.command.executor.def.UserCommandExecutor;
import pl.bestguilds.api.user.User;

public class GuildCommand extends UserCommandExecutor {

    public GuildCommand(final BestGuildsAPI plugin) {
        super(plugin);
    }

    @Override
    public void execute(final User user, final Arguments args) {

    }
}
