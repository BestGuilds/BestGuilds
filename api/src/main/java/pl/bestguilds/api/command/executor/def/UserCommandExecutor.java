package pl.bestguilds.api.command.executor.def;

import org.bukkit.command.CommandSender;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.command.arguments.Arguments;
import pl.bestguilds.api.user.User;

public abstract class UserCommandExecutor extends BaseCommandExecutor {

    public UserCommandExecutor(final BestGuildsAPI plugin) {
        super(plugin);
    }

    @Override
    public void execute(final CommandSender sender, final Arguments args) {
        if (sender instanceof User) {
            execute(sender, args);
        }
    }

    public abstract void execute(final User user, final Arguments args);
}
