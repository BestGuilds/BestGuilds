package pl.bestguilds;

import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.command.CommandInjector;
import pl.bestguilds.api.command.CommandManager;
import pl.bestguilds.api.command.CommandManagerImpl;
import pl.bestguilds.api.guild.GuildManager;
import pl.bestguilds.command.GuildCommand;
import pl.bestguilds.command.sub.CreateGuildCommand;
import pl.bestguilds.guild.GuildManagerImpl;
import pl.bestguilds.user.UserManagerImpl;

public final class BestGuildsPlugin implements BestGuildsAPI {

  private final UserManagerImpl userManager;
  private final GuildManager    guildManager;
  private final CommandManager  commandManager;

  public BestGuildsPlugin() {
    this.userManager = new UserManagerImpl();
    this.guildManager = new GuildManagerImpl();
    this.commandManager = new CommandManagerImpl();
  }

  public void registerCommands(@NotNull CommandInjector injector) {
    this.commandManager.setMainCommand(new GuildCommand(this));
    this.commandManager.register(
        new CreateGuildCommand(this)
    );
    injector.inject();
  }

  @Override
  public @NotNull UserManagerImpl getUserManager() {
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
