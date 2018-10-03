package pl.bestguilds.api.command;

import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.user.User;

public abstract class UserCommandExecutor implements CommandExecutor<User> {

    protected final BestGuildsAPI plugin;

    public UserCommandExecutor(@NotNull BestGuildsAPI plugin) {
        this.plugin = plugin;
    }
}
