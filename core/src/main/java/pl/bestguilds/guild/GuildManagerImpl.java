package pl.bestguilds.guild;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.guild.GuildManager;
import pl.bestguilds.util.Iterables;

public class GuildManagerImpl implements GuildManager {

  private final ConcurrentMap<GuildManager, Guild> guildMap = new ConcurrentHashMap<>();

  @Override
  public Optional<Guild> getGuildByTag(@NotNull String tag) {
    return Iterables.find(getGuilds(), guild -> guild.getTag().equalsIgnoreCase(tag));
  }

  @Override
  public Optional<Guild> getGuildByName(@NotNull String name) {
    return Iterables.find(getGuilds(), guild -> guild.getName().equalsIgnoreCase(name));
  }

  @Override
  public Collection<Guild> getGuilds() {
    return Collections.unmodifiableCollection(this.guildMap.values());
  }
}