package pl.bestguilds.api.guild;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

public interface GuildManager {

  Optional<Guild> getGuildByTag(@NotNull String tag);

  Optional<Guild> getGuildByName(@NotNull String name);

  Collection<Guild> getGuilds();
}