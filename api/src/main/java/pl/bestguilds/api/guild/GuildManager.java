package pl.bestguilds.api.guild;

import com.google.common.collect.ImmutableSet;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

public interface GuildManager {

  Optional<Guild> getGuildByTag(@NotNull String tag);

  Optional<Guild> getGuildByName(@NotNull String name);

  ImmutableSet<Guild> getGuilds();
}
