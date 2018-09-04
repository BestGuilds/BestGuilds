package pl.bestguilds.api.user;

import java.util.Optional;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.guild.GuildMember;

public interface User {

  @NotNull
  UUID getUUID();

  @NotNull
  String getName();

  @NotNull
  UserStatistic getStatistic();

  Optional<GuildMember> getGuildMember();

  void setGuildMember(@NotNull GuildMember guild);

  interface Builder extends pl.bestguilds.api.util.Builder<User> {

    Builder uuid(@NotNull UUID uuid);

    Builder name(@NotNull String name);

    Builder statistic(@NotNull UserStatistic statistic);

    Builder guildRank(@NotNull GuildMember guild);
  }
}