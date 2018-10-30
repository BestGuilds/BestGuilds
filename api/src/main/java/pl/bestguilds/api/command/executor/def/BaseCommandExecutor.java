package pl.bestguilds.api.command.executor.def;

import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.command.executor.CommandExecutor;

public abstract class BaseCommandExecutor implements CommandExecutor {

    protected final BestGuildsAPI plugin;

    BaseCommandExecutor(final BestGuildsAPI plugin) {
        this.plugin = plugin;
    }
}
