package pl.bestguilds.api.user;

import java.util.Optional;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.command.CommandSender;
import pl.bestguilds.api.guild.GuildMember;

public interface User extends CommandSender {

  @NotNull
  UUID getUUID();

  @NotNull
  String getName();

  @NotNull
  UserStatistics getStatistics();

  Optional<GuildMember> getGuildMember();

  void setGuildMember(@NotNull GuildMember guild);

  void sendMessage(@NotNull String content);

  interface Builder extends pl.bestguilds.api.util.Builder<User> {

    Builder uuid(@NotNull UUID uuid);

    Builder name(@NotNull String name);

    Builder statistics(@NotNull UserStatistics statistics);

    Builder guildRank(@NotNull GuildMember guild);
  }
}
