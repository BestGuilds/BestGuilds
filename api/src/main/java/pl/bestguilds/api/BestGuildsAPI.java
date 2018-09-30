package pl.bestguilds.api;

import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.command.CommandManager;
import pl.bestguilds.api.guild.GuildManager;
import pl.bestguilds.api.user.UserManager;

public interface BestGuildsAPI {

  @NotNull
  UserManager getUserManager();

  @NotNull
  GuildManager getGuildManager();

  @NotNull
  CommandManager getCommandManager();

}
