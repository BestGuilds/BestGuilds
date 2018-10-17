package pl.bestguilds.api;

import pl.bestguilds.api.command.CommandManager;
import pl.bestguilds.api.guild.GuildManager;
import pl.bestguilds.api.user.UserManager;

public interface BestGuildsAPI {

    UserManager getUserManager();

    GuildManager getGuildManager();

    CommandManager getCommandManager();
}
