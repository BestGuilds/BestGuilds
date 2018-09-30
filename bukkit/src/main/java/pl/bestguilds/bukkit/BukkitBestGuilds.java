package pl.bestguilds.bukkit;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.BestGuildsPlugin;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.command.CommandInjector;
import pl.bestguilds.api.command.CommandManager;
import pl.bestguilds.api.guild.GuildManager;
import pl.bestguilds.api.user.UserManager;
import pl.bestguilds.bukkit.command.BukkitCommandInjector;
import pl.bestguilds.Updater;

public final class BukkitBestGuilds extends JavaPlugin implements BestGuildsAPI {

  private BestGuildsPlugin plugin;

  @Override
  public void onLoad() {
    this.plugin = new BestGuildsPlugin();
    Updater.checkVersion(this.getLogger(), this.getDescription().getVersion());
  }

  @Override
  public void onEnable() {
    CommandInjector commandInjector = new BukkitCommandInjector(this);
    this.plugin.registerCommands(commandInjector);
  }

  @Override
  public void onDisable() {

  }

  @NotNull
  @Override
  public final UserManager getUserManager() {
    return plugin.getUserManager();
  }

  @NotNull
  @Override
  public final GuildManager getGuildManager() {
    return plugin.getGuildManager();
  }

  @NotNull
  @Override
  public final CommandManager getCommandManager() {
    return plugin.getCommandManager();
  }
}
