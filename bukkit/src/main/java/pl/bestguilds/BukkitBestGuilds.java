package pl.bestguilds;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.BestGuildsPlugin;
import pl.bestguilds.api.guild.GuildManager;
import pl.bestguilds.api.user.UserManager;

public final class BukkitBestGuilds extends JavaPlugin implements BestGuildsPlugin {

  private BestGuilds plugin;

  @Override
  public void onEnable() {
    this.plugin = new BestGuilds();
  }

  @Override
  public void onDisable() {

  }

  @Override
  public @NotNull UserManager getUserManager() {
    return plugin.getUserManager();
  }

  @Override
  public @NotNull GuildManager getGuildManager() {
    return plugin.getGuildManager();
  }
}