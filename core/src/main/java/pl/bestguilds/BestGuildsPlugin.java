package pl.bestguilds;

import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.command.CommandManager;
import pl.bestguilds.api.command.CommandManagerImpl;
import pl.bestguilds.api.guild.GuildManager;
import pl.bestguilds.command.sub.CreateGuildCommand;
import pl.bestguilds.guild.GuildManagerImpl;
import pl.bestguilds.user.UserManager;

public final class BestGuildsPlugin implements BestGuildsAPI {

  private final UserManager    userManager;
  private final GuildManager   guildManager;
  private final CommandManager commandManager;

  public BestGuildsPlugin() {
    this.userManager = new UserManager();
    this.guildManager = new GuildManagerImpl();
    this.commandManager = new CommandManagerImpl();
  }

  public void registerCommands() {
    this.commandManager.register(
        new CreateGuildCommand(this)
    );
  }

  @Override
  public @NotNull UserManager getUserManager() {
    return userManager;
  }

  @Override
  public @NotNull GuildManager getGuildManager() {
    return guildManager;
  }

  @Override
  public @NotNull CommandManager getCommandManager() {
    return commandManager;
  }
}
