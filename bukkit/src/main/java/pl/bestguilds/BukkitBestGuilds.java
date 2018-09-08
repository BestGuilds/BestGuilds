package pl.bestguilds;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.guild.GuildManager;
import pl.bestguilds.api.user.UserManager;

public final class BukkitBestGuilds extends JavaPlugin implements BestGuildsAPI {

  private BestGuildsPlugin plugin;

  @Override
  public void onEnable() {
    this.plugin = new BestGuildsPlugin();
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
