package pl.bestguilds.api.user;

import java.util.Optional;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.guild.Guild;

public interface User {

  @NotNull
  UUID getUUID();

  @NotNull
  String getName();

  Optional<Guild> getGuild();

  void setGuild(Guild guild);
}