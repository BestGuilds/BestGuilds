package pl.bestguilds.api.user;

import java.util.Optional;
import java.util.UUID;

import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

import pl.bestguilds.api.command.BestCommandSender;
import pl.bestguilds.api.guild.GuildMember;
import pl.bestguilds.api.statistics.Statistics;

public interface User extends BestCommandSender, Statistics {

  UUID getUUID();

  String getName();

  Statistics getStatistics();

  Optional<GuildMember> getGuildMember();

  void setGuildMember(@NotNull GuildMember guild);

  void sendMessage(@NotNull String content);

  Optional<Player> getPlayer();

  void setPlayer(Player player);

  interface Builder extends pl.bestguilds.api.util.Builder<User> {

    Builder uuid(@NotNull UUID uuid);

    Builder name(@NotNull String name);

    Builder statistics(@NotNull Statistics statistics);

    Builder guildMember(@NotNull GuildMember guild);
  }
}
