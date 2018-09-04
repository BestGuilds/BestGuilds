package pl.bestguilds.guild;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.guild.GuildManager;
import pl.bestguilds.util.Iterables;

public class GuildManagerImpl implements GuildManager {

  private final ConcurrentMap<GuildManager, Guild> guildMap;

  public GuildManagerImpl() {
    this.guildMap = new ConcurrentHashMap<>();
  }

  @Override
  public Optional<Guild> getGuildByTag(@NotNull String tag) {
    return Iterables.find(getGuilds(), guild -> guild.getTag().equalsIgnoreCase(tag));
  }

  @Override
  public Optional<Guild> getGuildByName(@NotNull String name) {
    return Iterables.find(getGuilds(), guild -> guild.getName().equalsIgnoreCase(name));
  }

  @Override
  public ImmutableCollection<Guild> getGuilds() {
    return ImmutableSet.copyOf(this.guildMap.values());
  }
}
