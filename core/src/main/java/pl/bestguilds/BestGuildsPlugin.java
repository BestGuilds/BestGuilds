package pl.bestguilds;

import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.guild.GuildManager;
import pl.bestguilds.api.user.UserManager;
import pl.bestguilds.guild.GuildManagerImpl;
import pl.bestguilds.user.UserManagerImpl;

public class BestGuildsPlugin implements BestGuildsAPI {

  private final UserManager  userManager;
  private final GuildManager guildManager;

  BestGuildsPlugin() {
    this.userManager = new UserManagerImpl();
    this.guildManager = new GuildManagerImpl();
  }

  @Override
  public @NotNull UserManager getUserManager() {
    return userManager;
  }

  @Override
  public @NotNull GuildManager getGuildManager() {
    return guildManager;
  }
}
