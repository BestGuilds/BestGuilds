package pl.bestguilds.api.guild;

import com.google.common.collect.ImmutableCollection;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

public interface GuildManager {

  Optional<Guild> getGuildByTag(@NotNull String tag);

  Optional<Guild> getGuildByName(@NotNull String name);

  ImmutableCollection<Guild> getGuilds();
}