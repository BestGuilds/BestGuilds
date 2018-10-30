package pl.bestguilds.command.sub;

import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.command.SubCommand;
import pl.bestguilds.api.command.arguments.Arguments;
import pl.bestguilds.api.command.executor.def.UserCommandExecutor;
import pl.bestguilds.api.user.User;

public class CreateGuildCommand extends UserCommandExecutor {

    public CreateGuildCommand(final BestGuildsAPI plugin) {
        super(plugin);
    }

    @SubCommand(name = "create")
    @Override
    public void execute(final User user, final Arguments args) {

    }
}
