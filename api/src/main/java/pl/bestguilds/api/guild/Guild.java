package pl.bestguilds.api.guild;

import com.google.common.collect.ImmutableSet;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.user.User;

public interface Guild {

  @NotNull
  String getTag();

  @NotNull
  String getName();

  ImmutableSet<GuildMember> getMembers();

  void addMember(@NotNull GuildMember guildMember);

  void addMember(@NotNull User user);

  interface Builder extends pl.bestguilds.api.util.Builder<Guild> {

    Builder tag(@NotNull String tag);

    Builder name(@NotNull String name);
  }
}