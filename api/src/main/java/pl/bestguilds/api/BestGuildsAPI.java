package pl.bestguilds.api;

import java.io.File;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.command.CommandManager;
import pl.bestguilds.api.guild.GuildManager;
import pl.bestguilds.api.storage.Storage;
import pl.bestguilds.api.user.UserManager;

public interface BestGuildsAPI {

  @NotNull
  Storage getStorage();

  @NotNull
  File getDataFolder();

  @NotNull
  UserManager getUserManager();

  @NotNull
  GuildManager getGuildManager();

  @NotNull
  CommandManager getCommandManager();
}
