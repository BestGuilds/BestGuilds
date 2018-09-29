package pl.bestguilds.bukkit;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.BestGuilds;
import pl.bestguilds.BestGuildsPlugin;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.command.CommandInjector;
import pl.bestguilds.api.command.CommandManager;
import pl.bestguilds.api.guild.GuildManager;
import pl.bestguilds.api.user.UserManager;
import pl.bestguilds.bukkit.command.BukkitCommandInjector;
import pl.bestguilds.bukkit.util.Updater;

public final class BukkitBestGuilds extends JavaPlugin implements BestGuildsAPI {

  private BestGuildsPlugin plugin;
  private Updater updater;

  @Override
  public void onEnable() {
    this.plugin = new BestGuildsPlugin();
    CommandInjector commandInjector = new BukkitCommandInjector(this);
    this.plugin.registerCommands(commandInjector);
    this.updater.init();
    try {
      this.updater.checkForUpdates();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Override
  public void onDisable() {

  }

  @NotNull
  @Override
  public final UserManager getUserManager() {
    return this.plugin.getUserManager();
  }

  @NotNull
  @Override
  public final GuildManager getGuildManager() {
    return this.plugin.getGuildManager();
  }

  @NotNull
  @Override
  public final CommandManager getCommandManager() {
    return this.plugin.getCommandManager();
  }
}
